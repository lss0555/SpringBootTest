package com.example.flowable.controller;

import org.attoparser.util.TextUtil;
import org.flowable.engine.IdentityService;
import org.flowable.engine.TaskService;
import org.flowable.engine.task.Comment;
import org.flowable.identitylink.api.IdentityLink;
import org.flowable.identitylink.service.IdentityLinkType;
import org.flowable.idm.api.Group;
import org.flowable.task.api.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 任务测试
 * @Author lss0555
 **/
@RestController
public class TaskTestController {
    @Resource
    TaskService taskService;

    @Resource
    IdentityService identityService;

    /**
     * @Description 创建任务,设置任务的名称,id,接受人
     **/
    @GetMapping("/creatTask")
    public String creatTast(String taskId,String taskname,String assigness) {
        if (taskId.equals("")||taskname.equals("")||assigness.equals("")) {
            return "请填写参数";
        } else {
            Task task = taskService.newTask(taskId);
            //设置任务的持有人

            //申明任务持有人的用户id
            String ownerid="897";
            task.setOwner(ownerid);

            //设置任务的受理人
            task.setAssignee(assigness);

            //设置任务的名称
            task.setName(taskname);

            //设置任务的参数
            taskService.setVariable(taskId,"arg0","hello world");
            taskService.setVariable(taskId,"arg1",false);

            //设置多个参数
            HashMap<String,String> map=new HashMap<>();
            map.put("reason1","reason aa");
            map.put("reason2","reason aabb");
            taskService.setVariables(taskId,map);



            System.out.println("任务详情:" + task.toString());

            //保存任务
            taskService.saveTask(task);
            return "任务ID:" + task.getId() + "";
        }
    }


    /**
     * @Description  删除任务
     **/
    @GetMapping("/deleteTask")
    public String deleteTask(String taskId){
        if(taskId.equals("")){
            return "任务ID参数为空";
        }else {
            //根据任务taskID删除任务
//            taskService.deleteTask(taskId);
            //根据任务taskID删除任务,包括子任务和历史记录
            taskService.deleteTask(taskId,true);
            return "删除成功";
        }
    }
  //------------------------------------------任务的权限------------------------------------------------------------------------------


    /**
     * @Description  设置候选用户组,用户  相关的数据表 -- act_ru_identitylink
     **/
    @GetMapping("/setUserGroup")
    public String sesTaskGroup(){
        //申明任务组的ID
        String groupid="7788";
        //创建组
        Group group = identityService.newGroup(groupid);
        group.setType("manager");
        group.setName("经理组");
        identityService.saveGroup(group);
        //根据组的ID来查询该用户组
        Group singleResult = identityService.createGroupQuery().groupId("7788").singleResult();

        //申请任务的ID
        String taskId="555";
        //创建任务
        Task task = taskService.newTask(taskId);
        //保存任务
        taskService.saveTask(task);
        //绑定用户组与任务的关系,具体数据在表中查看---> act_ru_identitylink
        taskService.addCandidateGroup(taskId,singleResult.getId());

        //删除用户组身份连接关系
//        taskService.deleteGroupIdentityLink(taskId,singleResult.getId(), IdentityLinkType.CANDIDATE);

        //删除用户组的权限
//        taskService.deleteCandidateGroup(taskId,singleResult.getId());

        //设置任务的候选用户
        taskService.addCandidateUser(taskId,"123");

        //删除任务的候选人
//        taskService.deleteCandidateUser(taskId,"123");
        return "set success";
    }

    /**
     * @Description  根据用户ID查询任务
     **/
    @GetMapping("/queryTaskByUserid")
    public String queryTaskByUserId(String userid){
        if(userid.equals("")){
            return "用户的userid参数为空";
        }else {
            List<Task> taskList = taskService.createTaskQuery().taskCandidateUser(userid).list();
            return taskList.toString();
        }
    }


    /**
     * @Description  任务添加评论
     *  涉及到的表: act_hi_comment
     **/
    @GetMapping("/addTaskComment")
    public String addTaskComment(String taskid){
        if(taskid.equals("")){
            return "taskid参数为空";
        }else {
            taskService.addComment(taskid,"","comment text");
            return "set success";
        }
    }

    /**
     * @Description  任务添加评论
     *  涉及到的表: act_hi_comment
     **/
    @GetMapping("/getTaskCmoment")
    public void addTaskComment(){
        //申明任务的id
        String taskid="";
        //获取任务的评论列表数据
        List<Comment> commentList = taskService.getTaskComments(taskid);
        System.out.println("任务评论数:"+commentList.size());
    }



    /**
     * @Description  任务的申明与完成
     **/
    @GetMapping("/taskcomplite")
    public void taskcomplite(){
        //申明任务的id
        String taskid="";
        //完成任务
        taskService.complete(taskid);

        //完成任务,附加参数
        HashMap<String,Object> map=new HashMap<>();
        taskService.complete(taskid,map);

        //任务的申明
        taskService.claim(taskid,"1");
    }

}
