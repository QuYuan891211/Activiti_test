package cn.qy.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class TestActiviti2 {
    public ProcessEngine createProcessEngine(){
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        return processEngineConfiguration.buildProcessEngine();
    }

    public void deployProcess(){

    }
}
