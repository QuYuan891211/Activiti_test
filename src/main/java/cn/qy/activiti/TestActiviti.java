package cn.qy.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.test.Deployment;
import org.junit.Test;
import org.springframework.stereotype.Repository;

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
    @Test
    public void deploy(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
       org.activiti.engine.repository.Deployment deployment = repositoryService.createDeployment().addClasspathResource("diagram/leave.bpmn").addClasspathResource("diagram/leave.png").name("leaveProcess").category("OA").deploy();
        System.out.println(deployment.getId()+ "   " + deployment.getName());
    }
}
