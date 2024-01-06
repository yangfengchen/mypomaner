package com.ddzj.mypomaner.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ddzj.mypomaner.dto.DictTypeEditDto;
import com.ddzj.mypomaner.dto.DictTypeSearchPageDto;
import com.ddzj.mypomaner.dto.SelectDto;
import com.ddzj.mypomaner.vo.PageListDto;
import com.ddzj.mypomaner.entity.TblDictType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 字典表; 服务类
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
public interface ITblDictTypeService extends IService<TblDictType> {

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
     * 根据id 查询字典表
     * @param id
     * @return
     */
    TblDictType findById(String id);

    /**
     * 保存字典表数据
     * @param dictTypeEditDto
     * @return
     */
    TblDictType saveDto(DictTypeEditDto dictTypeEditDto);

    /**
     * 查询所有数据返回
     * @return
     */
    List<SelectDto> findSelectDtoAll();

    /**
     * 根据字段集合查询数据
     * @param dictTypes
     * @return
     */
    List<TblDictType> findListByDictType(List<String> dictTypes);

    /**
     * 根据id删除数据
     * @param id
     */
    void delteById(String id);
}
