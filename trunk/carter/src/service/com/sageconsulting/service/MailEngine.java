/*
 * MailEngine.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * Class for sending e-mail messages based on Velocity templates or with
 * attachments.
 */
public class MailEngine
{
    protected static final Log log = LogFactory.getLog(MailEngine.class);

    private MailSender mailSender;

    private VelocityEngine velocityEngine;

    public void setMailSender(MailSender sender)
    {
        this.mailSender = sender;
    }

    public void setVelocityEngine(VelocityEngine engine)
    {
        this.velocityEngine = engine;
    }

    /**
     * Send a simple message based on a Velocity template.
     * 
     * @param msg
     * @param templateName
     * @param model
     */
    public void sendMessage(SimpleMailMessage msg, String templateName, Map<String, Object> model)
    {
        String result = null;

        try
        {
            result = VelocityEngineUtils.mergeTemplateIntoString(this.velocityEngine, templateName, model);
        }
        catch (VelocityException e)
        {
            e.printStackTrace();
        }

        msg.setText(result);
        send(msg);
    }

    /**
     * Send a simple message with pre-populated values.
     * 
     * @param msg
     */
    public void send(SimpleMailMessage msg)
    {
        try
        {
            //this.mailSender.send(msg);
        }
        catch (MailException ex)
        {
            // log it and go on
            log.error(ex.getMessage());
        }
    }

    /**
     * Convenience method for sending messages with attachments.
     * 
     * @param emailAddresses
     * @param resource
     * @param bodyText
     * @param subject
     * @param attachmentName
     * @throws MessagingException
     */
    public void sendMessage(String[] emailAddresses, ClassPathResource resource, String bodyText, String subject,
        String attachmentName) throws MessagingException
    {
        MimeMessage message = ((JavaMailSenderImpl) this.mailSender).createMimeMessage();

        // use the true flag to indicate you need a multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(emailAddresses);
        helper.setText(bodyText);
        helper.setSubject(subject);

        helper.addAttachment(attachmentName, resource);

        ((JavaMailSenderImpl) this.mailSender).send(message);
    }
}
