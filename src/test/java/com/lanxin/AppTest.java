package com.lanxin;


import com.lanxin.config.ShiroConfig;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        Md5Hash hash=new Md5Hash("111","~!@#$%^&",10);
        System.out.println(hash.toString());


        //ApplicationContext applicationContext =new AnnotationConfigApplicationContext("com.lanxin");
    }

}
