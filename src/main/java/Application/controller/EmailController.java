package Application.controller;

import Application.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;
    @RequestMapping(value = "/email")
    public String sendEmail(){
        emailService.sendEmail();
        return "Email Sent !";
    }

}
