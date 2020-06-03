package com.example.drools;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述一下
 *
 * @author :szs
 * @date :2020-06-03 15:26
 */
@Data
public class FactEntry {

    public Map<String, Object> factMap;

    public Map<String, Object> execRel=new HashMap<>();

    public void insertResult(String k, Object v) {
        this.execRel.put(k, v);
    }

}
