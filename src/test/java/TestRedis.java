import com.github.jwxa.Application;
import com.github.jwxa.model.EoSymStaffDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Redis存储测试类
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/28 ProjectName: jchaos-gradle Version: 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestRedis {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        stringRedisTemplate.opsForValue().set("name","jwxa");
        Assert.assertEquals("jwxa",stringRedisTemplate.opsForValue().get("name"));
    }


    @Test
    public void testObj() throws InterruptedException {
        EoSymStaffDO eoSymStaffDO = new EoSymStaffDO();
        eoSymStaffDO.setStaffId("jwxa");
        eoSymStaffDO.setEmail("jwxa9000@qq.com");
        ValueOperations<String, EoSymStaffDO> operations=redisTemplate.opsForValue();
        operations.set("obj",eoSymStaffDO,1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        boolean exists=redisTemplate.hasKey("obj");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
    }

}
