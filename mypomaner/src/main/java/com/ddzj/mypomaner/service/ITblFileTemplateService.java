package com.ddzj.mypomaner.service;

import com.ddzj.mypomaner.dto.FileTemplateSaveDto;
import com.ddzj.mypomaner.dto.FileTemplateSearchDto;
import com.ddzj.mypomaner.entity.TblFileTemplate;
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
public interface ITblFileTemplateService extends IService<TblFileTemplate> {

    /**
     * 根据表id查询字段模板表
     * @param searchDto
     * @return
     */
    List<TblFileTemplate> findBySearchDto(FileTemplateSearchDto searchDto);

    /**
     * 批量保存字段模板表字段
     * @return
     */
    List<TblFileTemplate> saveDtoList(List<FileTemplateSaveDto> entitys);
}
