package cn.qy.activiti;

import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

//创建流程引擎
public class TestActiviti {
    @Test
    public void createProcessEngine(){
        //1. 方式一用代码方式创建
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        processEngineConfiguration.setJdbcDriver("oracle.jdbc.driver.OracleDriver");
        processEngineConfiguration.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:orcl");
        processEngineConfiguration.setJdbcUsername("scott");
        processEngineConfiguration.setJdbcPassword("tiger");
        processEngineConfiguration.setDatabaseSchemaUpdate("true");
        processEngineConfiguration.buildProcessEngine();
        System.out.println("success");
    }
}
