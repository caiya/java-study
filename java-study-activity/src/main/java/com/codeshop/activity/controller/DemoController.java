package com.codeshop.activity.controller;

import com.codeshop.activity.entity.dto.LeaveDTO;
import com.codeshop.activity.util.FlowUtils;
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

@RestController
@RequestMapping("/user")
public class DemoController {

    @Resource
    private RuntimeService runtimeService;

    @Resource
    private TaskService taskService;

    @Resource
    private FlowUtils flowUtils;

    @Transactional
    @PostMapping(value = "/leave")
    public Object startProcess(@RequestBody LeaveDTO leaveDTO) {
        // 业务校验（省略）
        // 设置流程上下文数据（省略）
        // 开启流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(leaveDTO.getProcessId()); // key 对应bpmn文件中id的属性值
        // 完成第一个任务
        String processInstanceId = processInstance.getProcessInstanceId(); // 流程实例id
        Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();

        // 完成任务
        taskService.complete(task.getId());
        return true;
    }

    /**
     * 查看实例流程图，根据流程实例ID获取流程图
     */
    @GetMapping(value = "process/{instanceId}")
    public void traceprocess(HttpServletResponse response, @PathVariable("instanceId") String instanceId) throws Exception {
        InputStream in = flowUtils.getResourceDiagramInputStream(instanceId);
        ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(in, output);
    }

    @GetMapping(value = "/task/{assignee}")
    public Object findAllTask(@PathVariable String assignee) {
        return taskService.createTaskQuery().orderByTaskCreateTime().desc()
                .taskCandidateOrAssigned(assignee)
                .list();
    }
}
