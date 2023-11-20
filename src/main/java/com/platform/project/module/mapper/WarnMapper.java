package com.platform.project.module.mapper;

import java.util.List;
import com.platform.project.module.domain.Warn;

/**
 * 报警Mapper接口
 * 
 */
public interface WarnMapper 
{
    /**
     * 查询报警
     * 
     * @param warnId 报警主键
     * @return 报警
     */
    public Warn selectWarnByWarnId(Long warnId);

    /**
     * 查询报警列表
     * 
     * @param warn 报警
     * @return 报警集合
     */
    public List<Warn> selectWarnList(Warn warn);

    /**
     * 新增报警
     * 
     * @param warn 报警
     * @return 结果
     */
    public int insertWarn(Warn warn);

    /**
     * 修改报警
     * 
     * @param warn 报警
     * @return 结果
     */
    public int updateWarn(Warn warn);

    /**
     * 删除报警
     * 
     * @param warnId 报警主键
     * @return 结果
     */
    public int deleteWarnByWarnId(Long warnId);

    /**
     * 批量删除报警
     * 
     * @param warnIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWarnByWarnIds(Long[] warnIds);
}
