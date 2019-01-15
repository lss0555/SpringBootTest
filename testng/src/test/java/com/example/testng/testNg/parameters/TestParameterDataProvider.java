package com.example.testng.testNg.parameters;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 参数测试
 * @Author lss0555
 * @Date 2018/12/21/021 17:29
 **/
public class TestParameterDataProvider {
    @Test(dataProvider = "num")
    public void test(int x, int y) {
        System.out.println("结果:"+(x+y));
    }

    @DataProvider(name = "num")
    public Object[][] provideData() {

        return new Object[][] { { 1, 2 }, { 2, 3 }, { 4, 5 } };
    }

    //传递对象参数
    @Test(dataProvider = "map")
    public void testConnection(Map<String, String> map) {

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
        }

    }

    @DataProvider(name = "map")
    public Object[][] provideDbConfig() {
        HashMap<String, String> map = new HashMap<>();
        map.put("username","user");
        map.put("password","pass");
        return new Object[][] { { map } };
    }

}
