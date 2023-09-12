/**
 * @ClassName EmailUtil
 * @Author 24
 * @Date 2023/6/23 15:59
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailUtil {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String context) {

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setFrom("kp2427431300@163.com");
            helper.setSubject(subject);
            helper.setText(context, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            System.out.println("发送失败");
        }

    }

}

//    may the force be with you.
//    @ClassName   EmailUtil
//    Created by 24 on 2023/6/23.
