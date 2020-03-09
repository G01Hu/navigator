package com.ferrotec.oa.init;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description: TODO
 * @Author: huqy
 * @Date: 2020/2/13
 */
@SpringBootTest
public class InitDB {
    @Autowired
    RepositoryService repositoryService;
    /**
     *  创建activiti 6.0 所需表
     *  目前使用7.1.0.M6  比6.0少 ACT_HI_* 表
     */
    @Test
    public void createTables(){
        ProcessEngineConfiguration processEngineConfigurationFromResourceDefault = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("java/com/xj/oa/init/activiti.cfg.xml");
        ProcessEngine processEngine = processEngineConfigurationFromResourceDefault.buildProcessEngine();
        System.out.println(processEngine);
    }
    @Test
    public void c(){
        System.out.println(repositoryService);
    }
}
