package com.example.springbootTest.testNg;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * @Description base
 * @Author lss0555
 * @Date 2018/12/20/020 14:59
 **/
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTestNg extends AbstractTestNGSpringContextTests {
}
