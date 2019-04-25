package com.example.flowable.controller;

import com.example.flowable.model.TResult;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.*;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.image.ProcessDiagramGenerator;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description 请假流程
 * @Author lss0555
 **/
@RestController
public class LeaveController {
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private ProcessEngine processEngine;

    /**
     * @Description 开启流程
     **/
    @GetMapping("Leave")
    public String startLeave(String userId, Integer day) {
        if(userId==""||day==null){
            return "请输入用户id以及请假的天数";
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("taskUser", userId);
        map.put("day", day);
        ProcessInstance leave = runtimeService.startProcessInstanceByKey("Leave", map);
        return "启动流程的ID:" + leave.getId();
    }

    /**
     * 获取审批管理列表
     */
    @GetMapping(value = "/UserTasklist")
    public String list(String userId) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(userId).orderByTaskCreateTime().desc().list();
        for (Task task : tasks) {
            System.out.println(task.toString());
        }
        return tasks.toArray().toString();
    }


    /**
     * 批准
     *
     * @param taskId 任务ID
     */
    @RequestMapping(value = "apply")
    @ResponseBody
    public String apply(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            throw new RuntimeException("流程不存在");
        }
        //通过审核
        HashMap<String, Object> map = new HashMap<>();
        map.put("outcome", "通过");
        taskService.complete(taskId, map);
        return "审批完成";
    }

    /**
     * 拒绝
     */
    @ResponseBody
    @RequestMapping(value = "reject")
    public String reject(String taskId) {
        if(taskId==null||taskId.equals("")){
            return "请输入任务ID";
        }else {
            HashMap<String, Object> map = new HashMap<>();
            map.put("outcome", "驳回");
            taskService.complete(taskId, map);
            return "审批拒绝";
        }

    }

    /**
     * 评论
     */
    @GetMapping(value = "comment")
    public String comment(String taskId) {
        if(taskId==null||taskId.equals("")){
            return "请输入任务ID";
        }else {
            taskService.addComment(taskId, "","");
            return "审批拒绝";
        }

    }

    /**
     * 生成流程图
     * @param processId 任务ID
     */
    @RequestMapping(value = "processDiagram")
    public void genProcessDiagram(HttpServletResponse httpServletResponse, String processId) throws Exception {
        ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(processId).singleResult();

        //流程走完的不显示图
        if (pi == null) {
            return;
        }
        Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        //使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
        String InstanceId = task.getProcessInstanceId();
        List<Execution> executions = runtimeService
                .createExecutionQuery()
                .processInstanceId(InstanceId)
                .list();

        //得到正在执行的Activity的Id
        List<String> activityIds = new ArrayList<>();
        List<String> flows = new ArrayList<>();
        for (Execution exe : executions) {
            List<String> ids = runtimeService.getActiveActivityIds(exe.getId());
            activityIds.addAll(ids);
        }

        //获取流程图
        BpmnModel bpmnModel = repositoryService.getBpmnModel(pi.getProcessDefinitionId());
        ProcessEngineConfiguration engconf = processEngine.getProcessEngineConfiguration();
        ProcessDiagramGenerator diagramGenerator = engconf.getProcessDiagramGenerator();
        InputStream in = diagramGenerator.generateDiagram(bpmnModel, "png", activityIds, flows, engconf.getActivityFontName(), engconf.getLabelFontName(), engconf.getAnnotationFontName(), engconf.getClassLoader(), 1.0);
        OutputStream out = null;
        byte[] buf = new byte[1024];
        int legth = 0;
        try {
            out = httpServletResponse.getOutputStream();
            while ((legth = in.read(buf)) != -1) {
                out.write(buf, 0, legth);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }


    /**
     * desc: flowable配置----为放置生成的流程图中中文乱码
     */
    @Configuration
    public class FlowableConfig implements EngineConfigurationConfigurer<SpringProcessEngineConfiguration> {
        @Override
        public void configure(SpringProcessEngineConfiguration engineConfiguration) {
            engineConfiguration.setActivityFontName("宋体");
            engineConfiguration.setLabelFontName("宋体");
            engineConfiguration.setAnnotationFontName("宋体");
        }
    }


}
