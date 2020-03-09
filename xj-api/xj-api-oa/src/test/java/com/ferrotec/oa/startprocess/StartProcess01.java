package com.ferrotec.oa.startprocess;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description: TODO
 * @Author: huqy
 * @Date: 2020/2/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class StartProcess01 {

    private ProcessEngine processEngine;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RuntimeService runtimeService;

    @Test
    public void start01(){
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Ue1aae59065ba422b9898786d54de8117");
    }
}
