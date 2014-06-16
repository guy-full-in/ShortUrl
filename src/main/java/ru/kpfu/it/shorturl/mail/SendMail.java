package ru.kpfu.it.shorturl.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import ru.kpfu.it.shorturl.model.Url;

/**
 * Created by Ayrat on 16.06.2014.
 */

public class SendMail {

    private MailSender mailSender;

    private String from = "shorturlitis@gmail.com";

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(Url url) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(url.getAuthor().getEmail());
        message.setSubject("Сокращенная ссылка от сервиса ShortUrl");
        message.setText("Вы сократили ссылку " + url.getOriginalLink() + ". Теперь вы можете воспользоваться короткой ссылкой: localhost:8080/" + url.getShortCode());
        System.out.println("Start sending mail from " + from + " to " + url.getAuthor().getEmail());
        mailSender.send(message);
        System.out.println("Mail is send from " + from + " to " + url.getAuthor().getEmail());
    }
}
