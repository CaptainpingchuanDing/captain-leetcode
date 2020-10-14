package pers.captain.algorithm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        String test = "[2.4, 3.6, 5.7]";

        JSONArray jsonArray  = JSON.parseArray(test);

        for(int i = 0; i< jsonArray.size();i++){
            BigDecimal f = (BigDecimal) jsonArray.get(i);
            System.out.println(f);
        }

        List<BigDecimal> result = JSON.parseObject(test,ArrayList.class);

//        for(int i = 0; i< result.size();i++){
//            System.out.println(result.get(i)* 2.3f);
//        }
    }
}

