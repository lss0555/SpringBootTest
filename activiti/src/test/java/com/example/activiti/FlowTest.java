package com.example.activiti;

import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @Description 流程测试
 * @Author lss0555
 * @Date 2019/4/15/015 9:46
 **/
public class FlowTest  extends BaseTestNg{
    //部署流程
    @Test
    public void deployProcess(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        DeploymentBuilder builder = repositoryService.createDeployment();
        builder.addClasspathResource("bpmn/leave.bpmn");//bpmn文件的名称
        Deployment deploy = builder.deploy();
        System.out.println("部署ID："+deploy.getId());
        System.out.println("部署名称："+deploy.getName());
    }

    //启动流程
    @Test
    public void startProcess() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("leave");//流程的名称，对应流程定义表的key字段，也可以使用ByID来启动流程
        System.out.println("流程实例ID:"+instance.getId());//流程实例ID
        System.out.println("流程定义ID:"+instance.getProcessDefinitionId());//流程定义ID
    }





    //查询指定流程节点的详细流程信息
    @Test
    public void queryTask(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        //根据assignee(节点接受人)查询任务
        String assignee = "staff";//
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(assignee).list();

        //首次运行的时候这个没有输出，因为第一次运行的时候扫描act_ru_task的表里面是空的，
        // 但第一次运行完成之后里面会添加一条记录，之后每次运行里面都会添加一条记录
        for (Task task : tasks) {
            System.out.println("taskId=" +"流程任务节点信息ID："+ task.getId() +"\n"+
                    ",taskName:" +"流程任务节点名称ID：" +task.getName() +"\n"+
                    ",assignee:" + "流程任务节点接受人："+task.getAssignee() +"\n"+
                    ",createTime:" +"流程任务节点创建时间："+ task.getCreateTime());
        }
    }


    //查询流程定义明细
    @Test
    public void queryProcdef(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //创建查询对象
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
        //添加查询条件
        query.processDefinitionKey("leave");//通过key获取
        // .processDefinitionName("My process")//通过name获取
        // .orderByProcessDefinitionId()//根据ID排序
        //执行查询获取流程定义明细
        List<ProcessDefinition> pds = query.list();
        for (ProcessDefinition pd : pds) {
            System.out.println("ID:"+pd.getId()+",NAME:"+pd.getName()+",KEY:"+pd.getKey()+",VERSION:"+pd.getVersion()+",RESOURCE_NAME:"+pd.getResourceName()+",DGRM_RESOURCE_NAME:"+pd.getDiagramResourceName());
        }
    }

    /**
     * @Description  查询历史任务
     **/
    @Test
    public void findHistoryTask() {
        String taskAssignee = "staff";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        List<HistoricTaskInstance> list = processEngine.getHistoryService()// 与历史数据（历史表）相关的Service
                .createHistoricTaskInstanceQuery()// 创建历史任务实例查询
                .taskAssignee(taskAssignee)// 指定历史任务的办理人
                .list();
        if (list != null && list.size() > 0) {
            for (HistoricTaskInstance hti : list) {
                System.out.println(hti.getId() +"\n"+ hti.getName() +"\n"+ hti.getProcessInstanceId() + "   "
                        + hti.getStartTime() +"\n"+hti.getEndTime() +"\n"+ hti.getDurationInMillis());
                System.out.println("################################");
            }
        }

    }


    /**
     * @Description   查询流程状态（判断流程正在执行，还是结束）
     **/
    @Test
    public void isProcessEnd() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        String processInstanceId = "5002";
        ProcessInstance pi = processEngine.getRuntimeService()// 表示正在执行的流程实例和执行对象
                .createProcessInstanceQuery()// 创建流程实例查询
                .processInstanceId(processInstanceId)// 使用流程实例ID查询
                .singleResult();
        if (pi == null) {
            System.out.println("流程已经结束");
        } else {
            System.out.println("流程没有结束");
        }
    }
}
