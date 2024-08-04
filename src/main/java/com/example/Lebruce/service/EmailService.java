package com.example.Lebruce.service;


import com.example.Lebruce.model.DTO.EmailContext;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public interface   EmailService {

    void sendEmail(EmailContext email)throws MessagingException;
}
