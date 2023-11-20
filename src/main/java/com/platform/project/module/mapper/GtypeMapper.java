package com.platform.project.module.mapper;

import java.util.List;
import com.platform.project.module.domain.Gtype;

/**
 * 货物类型Mapper接口
 * 
 */
public interface GtypeMapper 
{
    /**
     * 查询货物类型
     * 
     * @param gtypeId 货物类型主键
     * @return 货物类型
     */
    public Gtype selectGtypeByGtypeId(Long gtypeId);

    /**
     * 查询货物类型列表
     * 
     * @param gtype 货物类型
     * @return 货物类型集合
     */
    public List<Gtype> selectGtypeList(Gtype gtype);

    /**
     * 新增货物类型
     * 
     * @param gtype 货物类型
     * @return 结果
     */
    public int insertGtype(Gtype gtype);

    /**
     * 修改货物类型
     * 
     * @param gtype 货物类型
     * @return 结果
     */
    public int updateGtype(Gtype gtype);

    /**
     * 删除货物类型
     * 
     * @param gtypeId 货物类型主键
     * @return 结果
     */
    public int deleteGtypeByGtypeId(Long gtypeId);

    /**
     * 批量删除货物类型
     * 
     * @param gtypeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGtypeByGtypeIds(Long[] gtypeIds);
}
