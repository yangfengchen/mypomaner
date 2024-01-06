package com.ddzj.mypomaner.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ddzj.mypomaner.dto.DictTypeSearchPageDto;
import com.ddzj.mypomaner.dto.FieldConfigSaveDto;
import com.ddzj.mypomaner.dto.FieldConfigSearchPageDto;
import com.ddzj.mypomaner.entity.TblDictType;
import com.ddzj.mypomaner.entity.TblFieldConfig;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 项目配置; 服务类
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
public interface ITblFieldConfigService extends IService<TblFieldConfig> {

    /**
     * 分页查询字段表
     * @param page
     * @param entityDto
     * @return
     */
    IPage<TblFieldConfig> queryPageByEntityDto(Page<TblFieldConfig> page, FieldConfigSearchPageDto entityDto);

    /**
     * 根据id 查询字典表
     * @param id
     * @return
     */
    TblFieldConfig findById(String id);

    /**
     * 保存字段配置
     * @param entity
     * @return
     */
    TblFieldConfig saveDto(FieldConfigSaveDto entity);

    /**
     * 根据id删除数据
     * @param id
     */
    void delteById(String id);

    /**
     * 根据数据库类型查询所有的字段配置
     * @param databaseType
     * @return
     */
    List<TblFieldConfig> findByDatabaseType(String databaseType);
}
