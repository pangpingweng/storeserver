package com.platform.project.module.service.impl;

import com.platform.common.utils.DateUtils;
import com.platform.project.module.domain.Notice;
import com.platform.project.module.mapper.NoticeMapper;
import com.platform.project.module.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公告Service业务层处理
 * 
 */
@Service
public class NoticeServiceImpl implements INoticeService 
{
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 查询公告
     * 
     * @param noticeId 公告主键
     * @return 公告
     */
    @Override
    public Notice selectNoticeByNoticeId(Long noticeId)
    {
        return noticeMapper.selectNoticeByNoticeId(noticeId);
    }

    /**
     * 查询公告列表
     * 
     * @param notice 公告
     * @return 公告
     */
    @Override
    public List<Notice> selectNoticeList(Notice notice)
    {
        return noticeMapper.selectNoticeList(notice);
    }

    /**
     * 新增公告
     * 
     * @param notice 公告
     * @return 结果
     */
    @Override
    public int insertNotice(Notice notice)
    {
        notice.setCreateTime(DateUtils.getNowDate());
        return noticeMapper.insertNotice(notice);
    }

    /**
     * 修改公告
     * 
     * @param notice 公告
     * @return 结果
     */
    @Override
    public int updateNotice(Notice notice)
    {
        notice.setUpdateTime(DateUtils.getNowDate());
        return noticeMapper.updateNotice(notice);
    }

    /**
     * 批量删除公告
     * 
     * @param noticeIds 需要删除的公告主键
     * @return 结果
     */
    @Override
    public int deleteNoticeByNoticeIds(Long[] noticeIds)
    {
        return noticeMapper.deleteNoticeByNoticeIds(noticeIds);
    }

    /**
     * 删除公告信息
     * 
     * @param noticeId 公告主键
     * @return 结果
     */
    @Override
    public int deleteNoticeByNoticeId(Long noticeId)
    {
        return noticeMapper.deleteNoticeByNoticeId(noticeId);
    }
}
