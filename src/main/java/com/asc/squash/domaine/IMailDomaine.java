package com.asc.squash.domaine;

public interface IMailDomaine {

    void sendMail(String subject, String message, String recipient) throws Exception;
}
