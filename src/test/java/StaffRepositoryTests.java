import com.github.jwxa.Application;
import com.github.jwxa.dao.StaffRepository;
import com.github.jwxa.model.EoSymStaffDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/28 ProjectName: jchaos-gradle Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class StaffRepositoryTests {
    @Autowired
    private StaffRepository staffRepository;

    @Test
    public void test(){
        EoSymStaffDO eoSymStaffDO =  staffRepository.findByStaffId("admin");
        System.out.println(eoSymStaffDO);
    }


}
