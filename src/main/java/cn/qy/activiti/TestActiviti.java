package cn.qy.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

//创建流程引擎
public class TestActiviti {
    @Test
    public void createProcessEngine(){
        //1. 方式一用代码方式创建
//        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
//        processEngineConfiguration.setJdbcDriver("oracle.jdbc.driver.OracleDriver");
//        processEngineConfiguration.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:orcl");
//        processEngineConfiguration.setJdbcUsername("scott");
//        processEngineConfiguration.setJdbcPassword("tiger");
//        processEngineConfiguration.setDatabaseSchemaUpdate("true");
//        processEngineConfiguration.buildProcessEngine();
//        System.out.println("success");

        //2.方式二通过配置文件创建
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        processEngineConfiguration.buildProcessEngine();
        System.out.println("success");

        //3. 方式三获取默认引擎
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        System.out.println("success");

    }
    
}
