package com.example.flowable.handle;

import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;

/**
 * @Description 指定经理的assignnss
 * @Author lss0555
 * @Date 2019/4/24/024 17:16
 **/
public class ManagerTaskHandler implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setAssignee("经理");
    }
}
