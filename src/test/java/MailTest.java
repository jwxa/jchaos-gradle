import com.github.jwxa.Application;
import org.apache.commons.collections.map.HashedMap;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.util.ClassUtils;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * 邮件发送测试类
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/4/16 ProjectName: jchaos-gradle Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class MailTest {

    @Autowired
    private JavaMailSender mailSender;

    private static final String PIC_DIR = "C:\\Users\\Jwxa\\Code\\jchaos-gradle\\build\\resources\\main\\static\\";

    /**
     * 文本邮件
     * @throws Exception
     */
    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("171413094@qq.com");
        message.setTo("171413094@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
    }

    /**
     * 带附件的邮件
     * @throws Exception
     */
    @Test
    public void sendAttachmentsMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("171413094@qq.com");
        helper.setTo("171413094@qq.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");
        FileSystemResource file = new FileSystemResource(new File(PIC_DIR + "1.jpg"));
        helper.addAttachment("附件-1.jpg", file);
        mailSender.send(mimeMessage);
    }

    /**
     * 嵌入静态资源
     * @throws Exception
     */
    @Test
    public void sendInlineMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("171413094@qq.com");
        helper.setTo("171413094@qq.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:picture1\" ></body></html>", true);
        FileSystemResource file = new FileSystemResource(new File(PIC_DIR + "1.jpg"));
        helper.addInline("picture1", file);
        mailSender.send(mimeMessage);
    }

    /**
     * 模版邮件
     * @throws Exception
     */
    @Test
    public void sendTemplateMail() throws Exception {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("171413094@qq.com");
        helper.setTo("171413094@qq.com");
        helper.setSubject("主题：模板邮件");
        Map<String, Object> model = new HashedMap();
        model.put("username", "jwxa");
        String text = VelocityEngineUtils.mergeTemplateIntoString(
                ve, "templates/template.vm", "UTF-8", model);
        helper.setText(text, true);
        mailSender.send(mimeMessage);
    }


}
