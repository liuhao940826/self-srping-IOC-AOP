package com.alan.test;

import com.alan.beans.JsonResult;
import com.alibaba.fastjson.JSONObject;

/**
 * @Classname TestMain
 * @Description TODO
 * @Date 2020/7/1 2:37 下午
 * @Created by liuhao
 */
public class TestMain {


    public static void main(String[] args) {
        JsonResult result = new JsonResult();
        System.out.println(JSONObject.toJSON(result));
        String responseStr = JSONObject.toJSONString(JSONObject.toJSON(result));
        System.out.println(responseStr);




    }
}
