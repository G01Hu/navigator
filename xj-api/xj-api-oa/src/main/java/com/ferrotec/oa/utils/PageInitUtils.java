package com.ferrotec.oa.utils;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.converter.util.InputStreamProvider;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.impl.util.io.InputStreamSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Process Id生成
 *
 * @author H
 * @version 1.0
 * @date 2020/1/4
 **/
public class PageInitUtils {

    public static String FIRST_RESULT;
    public static String MAX_RESULTS;


    /**
     * Process Id生成
     * 如果id开头已数字开头则在页面渲染时会报错
     * @return Process Id
     */
    public static String getProcessId(){
        return "U" + UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }


    /**
     * 将前台传过来的bpmn转换为activiti对象
     * @param
     * @return
     */
    public static BpmnModel xmlToBpmnModel(String xml){
        //创建转换器
        BpmnXMLConverter converter = new BpmnXMLConverter();
        //将string类型转为InputStream
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xml.getBytes());

        InputStreamProvider inputStreamProvider  = new InputStreamSource(byteArrayInputStream);

        return converter.convertToBpmnModel(inputStreamProvider, true, false, "UTF-8");
    }

    public static int firstResult(int pageNum, int pageSize){

        return (pageNum - 1) * pageSize;
    }
}
