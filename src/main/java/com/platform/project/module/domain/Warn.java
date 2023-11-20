package com.platform.project.module.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.platform.framework.web.domain.BaseEntity;
import com.platform.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 报警对象 module_warn
 *
 */
public class Warn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 报警id */
    private Long warnId;

    /** 所属分区 */
    private Long areaId;

    /** 所属分区 */
    @Excel(name = "所属分区")
    private String areaName;

    /** 报警名称 */
    @Excel(name = "报警名称")
    private String warnName;

    /** 报警原因 */
    @Excel(name = "报警原因")
    private String warnReason;

    /** 当前情况 */
    @Excel(name = "当前情况")
    private String warnDesc;

    /** 报警状态 */
    @Excel(name = "报警状态")
    private String warnStatus;

    /** 处理意见 */
    private String warnIdea;
    private String type;
    @TableField(exist = false)
    private Long manager_id;

    public Long getManager_id() {
        return manager_id;
    }

    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWarnId(Long warnId)
    {
        this.warnId = warnId;
    }

    public Long getWarnId() 
    {
        return warnId;
    }
    public void setAreaId(Long areaId) 
    {
        this.areaId = areaId;
    }

    public Long getAreaId() 
    {
        return areaId;
    }
    public void setAreaName(String areaName) 
    {
        this.areaName = areaName;
    }

    public String getAreaName() 
    {
        return areaName;
    }
    public void setWarnName(String warnName) 
    {
        this.warnName = warnName;
    }

    public String getWarnName() 
    {
        return warnName;
    }
    public void setWarnReason(String warnReason) 
    {
        this.warnReason = warnReason;
    }

    public String getWarnReason() 
    {
        return warnReason;
    }
    public void setWarnDesc(String warnDesc) 
    {
        this.warnDesc = warnDesc;
    }

    public String getWarnDesc() 
    {
        return warnDesc;
    }
    public void setWarnStatus(String warnStatus) 
    {
        this.warnStatus = warnStatus;
    }

    public String getWarnStatus() 
    {
        return warnStatus;
    }
    public void setWarnIdea(String warnIdea) 
    {
        this.warnIdea = warnIdea;
    }

    public String getWarnIdea() 
    {
        return warnIdea;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("warnId", getWarnId())
            .append("areaId", getAreaId())
            .append("areaName", getAreaName())
            .append("warnName", getWarnName())
            .append("warnReason", getWarnReason())
            .append("warnDesc", getWarnDesc())
            .append("warnStatus", getWarnStatus())
            .append("warnIdea", getWarnIdea())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
