package com.passerbywhu.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MailSenderListener implements ApplicationListener<MailSendEvent> {
    @Override
    public void onApplicationEvent(MailSendEvent mailSendEvent) {
        System.out.println("onMailSendEvent " + mailSendEvent.getTo());
    }
}
