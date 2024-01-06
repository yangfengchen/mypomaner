package com.ddzj.mypomaner.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ddzj.mypomaner.dto.DictTypeSearchPageDto;
import com.ddzj.mypomaner.entity.TblDictType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 字典表; Mapper 接口
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
public interface TblDictTypeMapper extends BaseMapper<TblDictType> {
    /**
     * 根据字段类型查询字典表
     * @param dictType
     * @return
     */
    TblDictType findByDictType(String dictType);

    /**
     * 分页查询字段表
     * @param page
     * @param entityDto
     * @return
     */
    IPage<TblDictType> queryPageByEntityDto(IPage<?> page, DictTypeSearchPageDto entityDto);

    /**
     * 根据字段集合查询数据
     * @param dictTypes
     * @return
     */
    List<TblDictType> findListByDictType(List<String> dictTypes);
}
