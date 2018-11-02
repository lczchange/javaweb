import com.alibaba.fastjson.JSONObject;
import com.lcz.ssm.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJava {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/applicationContext_service.xml");
        IUserService userService = (IUserService) context.getBean("userService");
        userService.getAllUser();
    }
}
