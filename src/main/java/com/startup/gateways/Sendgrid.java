package com.startup.gateways;

import com.sendgrid.*;
import com.startup.model.User;

import java.io.IOException;

public class Sendgrid {
    public static void sendEmail(User user) {
        Email from = new Email("no-reply@rent-estimate.com");
        String subject = "Updates to ";
        Email to = new Email(user.getEmailAddress());
        Content content = new Content("text/plain", user.toString());
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        request.method = Method.POST;
        request.endpoint = "mail/send";
        Response response = null;
        try {
            request.body = mail.build();
            response = sg.api(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(response.statusCode);
        System.out.println(response.body);
        System.out.println(response.headers);
    }
}
