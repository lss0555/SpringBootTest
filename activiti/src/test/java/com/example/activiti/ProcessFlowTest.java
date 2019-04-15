package com.example.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.testng.annotations.Test;

/**
 * @Description 审核过程
 * @Author lss0555
 * @Date 2019/4/15/015 9:46
 **/
public class ProcessFlowTest  extends BaseTestNg{

    /**
     * @Description  完成指定节点的流程流程
     **/
    @Test
    public void startProcessApproval(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        //taskId 就是查询任务中的 ID
        String taskId = "5002";
        //完成请假申请任务
        taskService.complete(taskId);
    }

    /**
     * @Description  查询当前节点的流程以及完成
     **/
    @Test
    public void queryThisProcess(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("leave");

        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery().processInstanceId(instance.getId()).singleResult();
        System.out.println("当前流程ID:"+task.getId());
        taskService.complete(task.getId());
    }
}
