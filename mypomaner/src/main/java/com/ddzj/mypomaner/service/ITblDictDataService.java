package com.ddzj.mypomaner.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ddzj.mypomaner.dto.DictDataSaveDto;
import com.ddzj.mypomaner.dto.DictDataSearchDto;
import com.ddzj.mypomaner.entity.TblDictData;

import java.util.List;

/**
 * <p>
 * 字典数据表; 服务类
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
public interface ITblDictDataService extends IService<TblDictData> {

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
     * 保存字典数据表数据
     * @param entityDto
     * @return
     */
    TblDictData saveDto(DictDataSaveDto entityDto);

    /**
     * 根据id删除数据
     * @param id
     */
    void delteById(String id);
}
