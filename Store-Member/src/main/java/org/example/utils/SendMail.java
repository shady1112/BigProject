package org.example.utils;


import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.util.MailSSLSocketFactory;
import lombok.extern.slf4j.Slf4j;
import org.example.common.result.Result;


@Slf4j
public class SendMail {
    public static Result sendMail(String userMail, String authCode) throws Exception {
        // 这里展示带图片的邮件发送
        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.qq.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");

        // 关于QQ邮箱，还要设置SSL加密，加上以下代码即可
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);

        // 使用JavaMail发送邮件的5个步骤
        // 1.创建定义整个应用程序所需要的环境信息的Session
        // 这个也是QQ才有的，其他邮箱可以不用
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                // 发件人邮件用户名、授权码
                return new PasswordAuthentication("shadyaa@qq.com", "mdrkhzyssefabiei");
            }
        });

        // 开启Session的debug模式，（可以不开）这样就可以查看到程序发送Email的运行状态
        // 就是说在你的控制台里面会输出一些信息
        session.setDebug(false);
        // 2、通过session得到transport对象
        Transport ts = session.getTransport();
        try {

            // 3、使用邮箱的用户名和授权码连上邮件服务器
            ts.connect("smtp.qq.com", "shadyaa@qq.com", "mdrkhzyssefabiei");
            // 4、创建邮件
            // 创建邮件对象(需要传递Session)
            MimeMessage message = new MimeMessage(session);
            // 指明邮件的发件人
            message.setFrom(new InternetAddress("shadyaa@qq.com"));
            // 指明邮件的收件人
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(userMail));
            // 邮件的标题
            message.setSubject("ItBooks 验证码");
            // 准备图片数据
            // MimeBodyPart代表一块一块的资源内容
            MimeBodyPart image = new MimeBodyPart();
            // 图片需要经过数处理，DataHandler，不然会乱码
            DataHandler dh = new DataHandler(new FileDataSource("Store-Member/src/main/resources/img/159602672991491.png"));
            // 在我们的Body中放入这个图片处理数据
            image.setDataHandler(dh);
            // 给图片设置一个ID，我们后面可以使用,就是下面的src里面可以直接用
            image.setContentID("x.jpg");

            // 准备正文数据
            MimeBodyPart text = new MimeBodyPart();
            text.setContent("您的验证码为"+authCode+"<br/><img src='cid:x.jpg'>", "text/html;charset=UTF-8");

            // 数据描述关系
            // 用MimeMultipart封装前面的一块一块的内容
            MimeMultipart mm = new MimeMultipart();
            mm.addBodyPart(text);
            mm.addBodyPart(image);
            mm.setSubType("related");

            // 设置到消息中，保存修改
            message.setContent(mm);
            message.saveChanges();
            // 5、发送邮件
            ts.sendMessage(message, message.getAllRecipients());
            // 关闭连接
            ts.close();
            return  ResultUtil.success("邮件发送成功！");
        }catch (Exception e){
            e.printStackTrace();
            return  ResultUtil.error("邮件发送失败，请重试！");
        }

    }


    public static void main(String[] args) throws Exception {

        Result result = sendMail("13161579903@163.com", "123415");
        System.out.println(result.getMsg());
    }
}

