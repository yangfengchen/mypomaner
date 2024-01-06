package com.ddzj.mypomaner.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ddzj.mypomaner.dto.DictDataSearchDto;
import com.ddzj.mypomaner.entity.TblDictData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 字典数据表; Mapper 接口
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
public interface TblDictDataMapper extends BaseMapper<TblDictData> {
    /**
     * 根据字段类型查询字典数据表
     * @param dictCode
     * @return
     */
    List<TblDictData> findByDictCode(String dictCode);

    /**
     * 分页查询字段表
     * @param page
     * @param entityDto
     * @return
     */
    IPage<TblDictData> queryPageByEntityDto(IPage<?> page, DictDataSearchDto entityDto);

    /**
     * 根据字段类型查询最大得序号
     * @param dictCode
     * @return
     */
    Integer getMaxSortByDictCode(String dictCode);
}
