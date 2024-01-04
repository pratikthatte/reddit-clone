package com.project.redditclone.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import com.project.redditclone.exception.RedditErrorException;
import com.project.redditclone.model.NotificationEmail;

@Service
public class MailService {
	
	private static Logger log = LoggerFactory.getLogger(MailService.class);
	
	private final JavaMailSender javaMailSender;
	private final MailContentBuilder mailContentBuilder;
	
	public MailService(JavaMailSender javaMailSender, MailContentBuilder mailContentBuilder) {
		this.javaMailSender = javaMailSender;
		this.mailContentBuilder = mailContentBuilder;
	}
	
    void sendMail(NotificationEmail notificationEmail) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("springreddit@email.com");
            messageHelper.setTo(notificationEmail.getEmailRecepient());
            messageHelper.setSubject(notificationEmail.getEmailSubject());
            messageHelper.setText(mailContentBuilder.build(notificationEmail.getEmailBody()));        };
        try {
            javaMailSender.send(messagePreparator);
            log.info("Activation email sent!!");
        } catch (MailException e) {
            throw new RedditErrorException("Exception occurred when sending mail to " + notificationEmail.getEmailRecepient(),e);
        }
    }
	
}
