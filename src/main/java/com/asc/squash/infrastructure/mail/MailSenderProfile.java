package com.asc.squash.infrastructure.mail;


import com.asc.squash.domaine.IMailDomaine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * Classe dédiée à l'envoi de mail via Spring Mail
 * @author Judicael
 *
 */
@Component
public class MailSenderProfile implements IMailDomaine {

	@Autowired
	private JavaMailSender javaMailSender;
	
	/**
	 * Envoi d'un mail à partir d'un text de  corps de message et d'un destinataire
	 * @param subject
	 * @param message
	 * @param recipient
	 * @throws Exception
	 */
	@Override
	public void sendMail(String subject, String message, String recipient) throws Exception {

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setSubject(subject);
		mail.setText(message);
		mail.setTo(recipient);
		javaMailSender.send(mail);
	}
}
