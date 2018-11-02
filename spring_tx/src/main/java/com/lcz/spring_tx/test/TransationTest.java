package com.lcz.spring_tx.test;

import com.lcz.spring_tx.domain.Acount;
import com.lcz.spring_tx.service.IAcountService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransationTest {

    @Test
    public void test1() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAcountService acountService = (IAcountService) context.getBean("acountService");
        acountService.transfer("aa","bb",100f);
        Acount acount = acountService.findAcountById(1);
        System.out.println(acount.toString());

    }
}
