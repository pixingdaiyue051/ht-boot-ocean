package com.tequeno.common.temail;

import com.tequeno.common.constants.HtCommonRegPattern;
import com.tequeno.common.constants.HtPropertyConstant;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailUtil {

    private final static boolean SSL = true;
    private final static String HOST_NAME = "smtp.163.com";
    private final static String SSL_PORT = "465";
    private final static String USER_NAME = "pixingdaiyue051@163.com";
    private final static String PASSWORD = "pixingdaiyue051";
    private final static String CHARSET = HtPropertyConstant.CHARSET_UTF8;

    public static EmailRespone send(EmailWrapper wrapper) {
        EmailRespone respone = new EmailRespone();
        respone.setSuccess(true);
        respone.setMsg("邮件发送成功!");
        try {
            checkEmailWrapper(wrapper, respone);
            if (respone.getSuccess()) {
                HtmlEmail email = new HtmlEmail();
                email.setCharset(CHARSET);
                email.setSSL(SSL);
                email.setHostName(HOST_NAME);
                email.setSslSmtpPort(SSL_PORT);
                email.setAuthentication(USER_NAME, PASSWORD);
                email.setFrom(USER_NAME, USER_NAME);
                email.setSubject(wrapper.getSubject());
                if (StringUtils.isNotBlank(wrapper.getToName())) {
                    email.addTo(wrapper.getToEmail(), wrapper.getToName());
                } else {
                    email.addTo(wrapper.getToEmail());
                }
                email.setHtmlMsg(wrapper.getEmailMsg());
                if (wrapper.getAttachments() != null && !wrapper.getAttachments().isEmpty()) {
                    wrapper.getAttachments().stream().forEach((emailAttachment) -> {
                        try {
                            emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);
                            email.attach(emailAttachment);
                        } catch (EmailException e) {
                            e.printStackTrace();
                        }
                    });
                }
                email.send();
            }
        } catch (Exception e) {
            respone.setSuccess(false);
            respone.setMsg("EmailUtil类内部异常!");
            e.printStackTrace();
        }
        return respone;
    }

    private static void checkEmailWrapper(EmailWrapper wrapper, EmailRespone respone) {
        if (StringUtils.isBlank(wrapper.getSubject())) {
            respone.setSuccess(false);
            respone.setMsg("邮件主题为空，无法发送！");
            return;
        }
        if (StringUtils.isBlank(wrapper.getToEmail())) {
            respone.setSuccess(false);
            respone.setMsg("接受邮件为空，无法发送！");
            return;
        }
        String emailReg = HtCommonRegPattern.REG_MAIL;
        boolean matchOver = wrapper.getToEmail().matches(emailReg);
        if (!matchOver) {
            respone.setSuccess(false);
            respone.setMsg("接收邮件格式不对，无法发送！");
            return;
        }
        if (StringUtils.isBlank(wrapper.getEmailMsg())) {
            respone.setSuccess(false);
            respone.setMsg("消息为空，无法发送！");
            return;
        }
    }
}