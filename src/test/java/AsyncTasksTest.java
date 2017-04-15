import com.github.jwxa.Application;
import com.github.jwxa.task.AsyncTasks;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

/**
 * 异步调用任务测试类
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/4/15 ProjectName: jchaos-gradle Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AsyncTasksTest {

    @Autowired
    private AsyncTasks task;

    @Test
    public void test() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> task1 = task.doTaskOne();
        Future<String> task2 = task.doTaskTwo();
        Future<String> task3 = task.doTaskThree();
        while(true) {
            if(task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }
}
