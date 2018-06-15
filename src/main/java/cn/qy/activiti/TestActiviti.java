package cn.qy.activiti;

import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.engine.test.Deployment;
import org.junit.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

//创建流程引擎
public class TestActiviti {

    public ProcessEngine createProcessEngine(){
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
//        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
//        processEngineConfiguration.buildProcessEngine();
//        System.out.println("success");

        //3. 方式三获取默认引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println("success");
        return processEngine;
    }
    @Test
    public void deploy(){
        ProcessEngine processEngine = createProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
       org.activiti.engine.repository.Deployment deployment = repositoryService.createDeployment().addClasspathResource("diagram/leave.bpmn").addClasspathResource("diagram/leave.png").name("leaveProcess").category("OA").deploy();
        System.out.println(deployment.getId()+ "   " + deployment.getName());
    }
@Test
    public void startProcess(){
        String key = "leaveBill";
        ProcessEngine processEngine = createProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key);
        System.out.println(processInstance.getId()+ "   " + processInstance.getProcessDefinitionId());
    }
@Test
    public void queryProcess(){
        String assignee = "lc";
        ProcessEngine processEngine = createProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        TaskQuery taskQuery = taskService.createTaskQuery();
        List<Task> list = taskQuery.taskAssignee(assignee).list();
        for(Task task:list){
            System.out.println(task.getAssignee() + "    " + task.getName() + "   " + task.getId());
        }
    }
}
