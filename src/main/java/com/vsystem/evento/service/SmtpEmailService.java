package com.vsystem.evento.service;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SmtpEmailService extends AbstractEmailService {

	@Autowired
	private MailSender mailSender; //responsavel por buscar todas as config de email no application.properties
	
	@Autowired
	private JavaMailSender javaMailSender; //implementaçao  envio html
	
	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) { //implementaçao para envio smtp
		LOG.info("Enviando email...");
		mailSender.send(msg);
		LOG.info("Email enviado");
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) { //implementaçao  envio html
		LOG.info("Enviando email...");
		javaMailSender.send(msg);
		LOG.info("Email enviado");
		
	}
}
