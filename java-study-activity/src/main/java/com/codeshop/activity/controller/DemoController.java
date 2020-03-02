package com.codeshop.activity.controller;

import com.codeshop.activity.entity.dto.LeaveDTO;
import com.codeshop.activity.util.FlowUtils;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.*;

@RestController
@RequestMapping("/user")
public class DemoController {

    @Resource
    private RuntimeService runtimeService;

    @Resource
    private TaskService taskService;

    @Resource
    private IdentityService identityService;

    @Transactional
    @PostMapping(value = "/leave")
    public Object startProcess(@RequestBody LeaveDTO leaveDTO) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(leaveDTO.getProcessId());
        // 完成第一个任务
        String processInstanceId = processInstance.getProcessInstanceId(); // 流程实例id
        Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();

        return true;
    }

}
