package com.platform.project.module.mapper;

import com.platform.project.module.domain.Notice;

import java.util.List;

/**
 * 公告Mapper接口
 * 
 */
public interface NoticeMapper 
{
    /**
     * 查询公告
     * 
     * @param noticeId 公告主键
     * @return 公告
     */
    public Notice selectNoticeByNoticeId(Long noticeId);

    /**
     * 查询公告列表
     * 
     * @param notice 公告
     * @return 公告集合
     */
    public List<Notice> selectNoticeList(Notice notice);

    /**
     * 新增公告
     * 
     * @param notice 公告
     * @return 结果
     */
    public int insertNotice(Notice notice);

    /**
     * 修改公告
     * 
     * @param notice 公告
     * @return 结果
     */
    public int updateNotice(Notice notice);

    /**
     * 删除公告
     * 
     * @param noticeId 公告主键
     * @return 结果
     */
    public int deleteNoticeByNoticeId(Long noticeId);

    /**
     * 批量删除公告
     * 
     * @param noticeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNoticeByNoticeIds(Long[] noticeIds);
}
