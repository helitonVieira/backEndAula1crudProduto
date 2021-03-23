package com.vsystem.evento.service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.vsystem.evento.model.Produto;

public interface EmailService {

	void sendOrderConfirmationEmail(Produto obj); // envio de email SMTP e MOCK
	
	void sendEmail(SimpleMailMessage msg); //enviar o email SMTP
	
	void sendOrderConfirmationHtmlEmail(Produto obj);//enviar o email HTML
	
	void sendHtmlEmail(MimeMessage msg);//enviar o email HTML
	
	//void sendNewPasswordEmail(Cliente cliente, String newPass);
}
