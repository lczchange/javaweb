import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class TestJava {
    @Test
    public void test1(){
        System.out.println("hello world!");
        System.out.println("第二次提交");

        String json = "{\"name\":\"aa\",\"password\":\"123\"}";
        User user = JSONObject.parseObject(json, User.class);
        System.out.println(user.toString());

    }
}
