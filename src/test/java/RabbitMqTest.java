import com.github.jwxa.Application;
import com.github.jwxa.queue.RabbitMqSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/5/7 ProjectName: jchaos-gradle Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RabbitMqTest {

    @Autowired
    private RabbitMqSender sender;

    @Test
    public void hello() throws Exception {
        sender.send();
    }

}
