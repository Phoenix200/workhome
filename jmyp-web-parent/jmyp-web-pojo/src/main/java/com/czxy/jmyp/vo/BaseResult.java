package com.czxy.jmyp.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName BaseResult
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/12 14:31
 * @Version 1.0
 **/
@Data
public class BaseResult {
    private Map<String, Object> data =new HashMap<>();

    /**
     * 提示方法
     * @param errno  提示码
     * @param errmsg  提示
     */
    public BaseResult(Integer errno,String errmsg){
        data.put("errno",errno);
        data.put("errmsg",errmsg);
    }

    /**
     *
     * @param key
     * @param msg
     * @return
     */
    public BaseResult append(String key , Object msg){
        data.put(key,msg);
        return this;
    }
}
