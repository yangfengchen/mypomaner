package com.ddzj.mypomaner.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ddzj.mypomaner.dto.TableTemplateSaveDto;
import com.ddzj.mypomaner.dto.TableTemplateSearchPageDto;
import com.ddzj.mypomaner.entity.TblTableTemplate;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 表模板; 服务类
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
public interface ITblTableTemplateService extends IService<TblTableTemplate> {

    /**
     * 分页查询字段表
     * @param page
     * @param entityDto
     * @return
     */
    IPage<TblTableTemplate> queryPageByEntityDto(IPage<TblTableTemplate> page, TableTemplateSearchPageDto entityDto);

    /**
     * 根据id 查询字典表
     * @param id
     * @return
     */
    TblTableTemplate findById(String id);

    /**
     * 保存字段配置
     * @param saveDto
     * @return
     */
    TblTableTemplate saveDto(TableTemplateSaveDto saveDto);

    /**
     * 根据id删除数据
     * @param id
     */
    void delteById(String id);
}
