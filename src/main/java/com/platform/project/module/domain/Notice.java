package com.platform.project.module.domain;

import com.platform.framework.aspectj.lang.annotation.Excel;
import com.platform.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 公告对象 module_notice
 *
 */
public class Notice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公告id */
    private Long noticeId;

    /** 公告标题 */
    @Excel(name = "公告标题")
    private String noticeName;

    /** 公告内容 */
    @Excel(name = "公告内容")
    private String noticeContent;

    public void setNoticeId(Long noticeId) 
    {
        this.noticeId = noticeId;
    }

    public Long getNoticeId() 
    {
        return noticeId;
    }
    public void setNoticeName(String noticeName) 
    {
        this.noticeName = noticeName;
    }

    public String getNoticeName() 
    {
        return noticeName;
    }
    public void setNoticeContent(String noticeContent) 
    {
        this.noticeContent = noticeContent;
    }

    public String getNoticeContent() 
    {
        return noticeContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("noticeId", getNoticeId())
            .append("noticeName", getNoticeName())
            .append("noticeContent", getNoticeContent())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
