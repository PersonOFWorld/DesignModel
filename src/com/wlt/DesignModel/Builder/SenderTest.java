package com.wlt.DesignModel.Builder;

/**
 * Created by somoOne on 2016/3/17.
 */
public interface SenderTest {
    public void send();
}
class MailSend implements SenderTest{
    public void send(){
        System.out.println("This is MialSend");
    }
}
class WeiChatSend implements SenderTest{
    public void send() {
        System.out.println("This is WeiChatSend");
    }
}