package com.ddzj.mypomaner.service;

import com.ddzj.mypomaner.dto.FieldTemplateSaveDto;
import com.ddzj.mypomaner.dto.FieldTemplateSearchDto;
import com.ddzj.mypomaner.entity.TblFieldTemplate;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 字段模板表; 服务类
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
public interface ITblFieldTemplateService extends IService<TblFieldTemplate> {

    /**
     * 根据表id查询字段模板表
     * @param searchDto
     * @return
     */
    List<TblFieldTemplate> findBySearchDto(FieldTemplateSearchDto searchDto);

    /**
     * 批量保存字段模板表字段
     * @return
     */
    List<TblFieldTemplate> saveDtoList(List<FieldTemplateSaveDto> entitys);
}
