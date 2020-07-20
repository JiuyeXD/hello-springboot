package com.example.demo_springboot;

import junit.framework.TestCase;
import org.junit.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {DemoSpringbootApplication.class})
public class DemoSpringbootApplicationTests {

    @Test
    public void testOne() {
        System.out.println("test hello 1");
        TestCase.assertEquals(1,1);
    }
    @Test
    public void testTwo() {
        System.out.println("test hello 2");
        TestCase.assertEquals(1,0);
    }
    @Before
    public void testBefore(){
        System.out.println("before");
    }
    @After
    public void testAfter(){
        System.out.println("after");
    }

}
