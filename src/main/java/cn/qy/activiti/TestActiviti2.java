package cn.qy.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestActiviti2 {
    public ProcessEngine createProcessEngine(){
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        return processEngineConfiguration.buildProcessEngine();
    }

    @Test
    public void deployProcess(){
        ProcessEngine processEngine = createProcessEngine();
        Deployment deployment = processEngine.getRepositoryService().createDeployment().addClasspathResource("diagram/bankProcess.bpmn").addClasspathResource("diagram/bankProcess.png").name("bankProcess").category("bank").deploy();

        System.out.println(deployment.getId()+ "   " + deployment.getName() + "   " + deployment.getDeploymentTime());
    }

    @Test
    public void startProcess(){
        ProcessEngine processEngine = createProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("bankProcess");
        System.out.println(processInstance.getId()+ "   " + processInstance.getProcessDefinitionId());
    }
    @Test
    public void complete(){
        ProcessEngine processEngine = createProcessEngine();
        Map<String,Object> params = new HashMap<String, Object>();

        params.put("variable","express");
        params.put("expressManager","qu");
//        map_assginee.put()
        processEngine.getTaskService().complete("4204",params);
    }
}
