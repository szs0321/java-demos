package com.example.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession ks = kieContainer.newKieSession();

        //返回信息实例化
        Map<String,String> execResult=new HashMap<>();


        Map<String, Object> fact = new HashMap<>();
        fact.put("result",execResult);
        fact.put("姓名", "张三");
        fact.put("年龄", 18);
        fact.put("诊断列表", creatediags());

        ks.insert(fact);
        ks.fireAllRules();
        execResult= (Map)fact.get("result");
        execResult.entrySet().forEach((m)->{
            System.out.println(m.getKey()+"____"+m.getValue());
        });
    }




    static Set<Map<String, Object>> creatediags() {
        Map<String, Object> dg1 = new HashMap<>();
        dg1.put("诊断编码", 111);
        dg1.put("诊断名称", "测试诊断1");

        Map<String, Object> dg2 = new HashMap<>();
        dg2.put("诊断编码", 222);
        dg2.put("诊断名称", null);
        Map<String, Object> dg3 = new HashMap<>();
        dg3.put("诊断编码", 333);
        dg3.put("诊断名称", "测试诊断名称3");
        Set<Map<String, Object>> diags = new HashSet<>();
        diags.addAll(Arrays.asList(dg1, dg2, dg3));
        return diags;
    }


}

