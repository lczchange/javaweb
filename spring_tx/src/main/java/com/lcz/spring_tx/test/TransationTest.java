package com.lcz.spring_tx.test;

import com.google.gson.Gson;
import com.lcz.spring_tx.domain.Acount;
import com.lcz.spring_tx.service.IAcountService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransationTest {

    @Test
    public void test1() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAcountService acountService = (IAcountService) context.getBean("acountService");
        acountService.transfer("aa", "bb", 100f);
        Acount acount = acountService.findAcountById(1);
        System.out.println(acount.toString());

    }

    //"[{"channel_id":100},{"channel_id":200}]"
    @Test
    public void testjson() {
        String josn = "[{\"channel_id\":100},{\"channel_id\":200}]";
        Gson gson = new Gson();
        Map<String, Integer> map = gson.fromJson(josn, Map.class);
        System.out.println(map.size());
    }

    public static boolean isEmpty(CharSequence str) {
        if (str == null || "".equals(str)) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void test22() {
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(11,"aa");
        map.put(12,"bb");
        map.put(13,"cc");
        Gson gson = new Gson();
        String json = gson.toJson(map);
        String num = "0225a";
        String arayChannel = "{\"channelList\":[{\"channelId\":11},{\"channelId\":12},{\"channelId\":13}]}";
        if (num.matches("[0-9]{1,}")){
            System.out.println(Integer.valueOf(num));
        }
        Map map1 = gson.fromJson(arayChannel, Map.class);
        System.out.println(map1.get("channelList"));

        Integer[] arrayStr = {111,222,333};
        System.out.println(gson.toJson(arrayStr));
        List<Integer> list = new ArrayList<>();
        list.add(111);
        list.add(112);
        list.add(113);
        System.out.println(gson.toJson(list));
        String  json2 = "[111,112,113]";
        List<Integer> list1 = gson.fromJson(json2, List.class);
        System.out.println(list1);


    }
}
