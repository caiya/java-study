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

    @Resource
    private FlowUtils flowUtils;

    @Transactional
    @PostMapping(value = "/leave")
    public Object startProcess(@RequestBody LeaveDTO leaveDTO) {
        // 设置流程启动人
        identityService.setAuthenticatedUserId(String.valueOf(leaveDTO.getUserId()));
        // 业务校验（省略）
        // 设置流程上下文数据（省略）
        // 开启流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(leaveDTO.getProcessId()); // key 对应bpmn文件中id的属性值
        // 完成第一个任务
        String processInstanceId = processInstance.getProcessInstanceId(); // 流程实例id
        Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();

        // 完成任务
        // 指定处理人
        Map<String, Object> map = new HashMap<>();
        map.put("userId", 2);
        taskService.complete(task.getId(), map);
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
        List<Task> taskList = taskService.createTaskQuery().orderByTaskCreateTime().desc()
                .taskCandidateOrAssigned(assignee)
                .list();
        List<Map<String, Object>> list = new LinkedList<>();
        for (Task task: taskList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", task.getId());
            map.put("name", task.getName());
            map.put("owner", task.getOwner());
            map.put("assignee", task.getAssignee());
            map.put("dueDate", task.getDueDate());
            map.put("processDefinitionId", task.getProcessDefinitionId());
            map.put("processInstanceId", task.getProcessInstanceId());
            list.add(map);
        }
        return list;
    }
}
