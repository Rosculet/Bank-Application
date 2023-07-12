package com.example.bank_security.controller;


import com.example.bank_security.model.contact_messages.ContactMessagesEntity;
import com.example.bank_security.model.contact_messages.DTO.ContactDTO;
import com.example.bank_security.model.contact_messages.DTO.ContactMapper;
import com.example.bank_security.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @PostMapping(value = "/contact", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveContactInquiryDetails(@RequestBody ContactDTO contact) {
        ContactMessagesEntity contactMessages = null;
        ResponseEntity responseEntity = null;
        try {
            contactMessages = ContactMapper.INSTANCE.contactDtoToContact(contact);
            contactRepository.save(contactMessages);


            if (contactMessages.getContactId() > 0) {
                responseEntity = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Contact message sent");
            }
        } catch (Exception ex) {
            responseEntity = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + ex.getMessage());
        }
        return responseEntity;
    }

}