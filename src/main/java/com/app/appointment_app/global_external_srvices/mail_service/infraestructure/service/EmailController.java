package com.app.appointment_app.global_external_srvices.mail_service.infraestructure.service;

import com.app.appointment_app.global_external_srvices.mail_service.domain.facade.EmailServiceFacade;
import com.app.appointment_app.global_external_srvices.mail_service.domain.facade.SendMailData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sendmail")
public class EmailController {
    @Autowired
    private EmailServiceFacade emailServiceFacade;
    @PostMapping()
    public String enviarCorreo(@RequestBody SendMailData mailData) {
        emailServiceFacade.sendMail(mailData);
        return "Correo enviado con éxito";
    }
}
