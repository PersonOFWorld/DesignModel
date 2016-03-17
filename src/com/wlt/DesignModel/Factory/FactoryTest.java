package com.wlt.DesignModel.Factory;

/**
 * Created by somoOne on 2016/3/17.
 */
public class FactoryTest {
    public static void main(String []args) {
        System.out.println("第一种测试  一个工厂方法模式");
        SendFactory0 sendFactory0 = new SendFactory0();
        sendFactory0.produce("Mail").send();
        System.out.println("第二种测试  多个共产方法模式");
        SendFactory1 sendFactory1=new SendFactory1();
        sendFactory1.produceMail().send();
        System.out.println("第三种测试  静态工厂方法模式");
        SendFactory2.produceWeiChat().send();
        System.out.println("第四种测试  抽象工厂方法模式");
        Providor providor=new WeiCHatAbstactFactory();
        providor.providor().send();
    }
}

interface Sender{
    public void send();
}
class MailSend implements Sender{
    public void send(){
        System.out.println("This is MialSend");
    }
}
class WeiChatSend implements Sender{
    public void send() {
        System.out.println("This is WeiChatSend");
    }
}
//第一种，有局限，当字符串不能匹配则创建失败
class SendFactory0{
    public Sender produce(String type){
        if(type=="Mail"){
               return new MailSend();
        }else if(type=="WeiChat"){
            return new WeiChatSend();
        }else{
            System.out.print("请输入正确的类型");
            return null;
        }
    }
}
//第二种，创建多个工厂方法，建造不同的对象
class SendFactory1{
    public Sender produceMail(){
        return new MailSend();
    }
    public Sender produceWeiChat(){
        return new WeiChatSend();
    }
}
//静态工程方法，创建对象不需要实例化
class SendFactory2{
    public static Sender produceMail(){
        return new MailSend();
    }
    public static Sender produceWeiChat(){
        return new WeiChatSend();
    }
}
//抽象工程模式
interface Providor{
    public Sender providor();
}
class MailAbstractFactory implements Providor{
    public Sender providor() {
        return new MailSend();
    }
}
class WeiCHatAbstactFactory implements Providor{
    public Sender providor() {
        return new WeiChatSend();
    }
}