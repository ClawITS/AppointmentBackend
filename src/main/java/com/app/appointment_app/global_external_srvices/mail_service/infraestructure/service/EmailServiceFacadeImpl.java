package com.app.appointment_app.global_external_srvices.mail_service.infraestructure.service;

import com.app.appointment_app.global_external_srvices.mail_service.domain.facade.EmailServiceFacade;
import com.app.appointment_app.global_external_srvices.mail_service.domain.facade.SendMailData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceFacadeImpl implements EmailServiceFacade {
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendMail(SendMailData sendMailData) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("clawitclinicalmessage@gmail.com");
        mail.setTo(sendMailData.getAddressee());
        mail.setSubject(sendMailData.getAffair());
        mail.setText(sendMailData.getMessage());
        javaMailSender.send(mail);
    }
}
