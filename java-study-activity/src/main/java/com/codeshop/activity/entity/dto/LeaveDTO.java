package com.codeshop.activity.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LeaveDTO {
    private Integer userId;
    private String reason; // 请假理由
    private Integer days; // 请假天数
    private Date createTime; // 申请时间

    private String processId; // 流程id
}
