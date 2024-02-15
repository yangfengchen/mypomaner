package com.ddzj.mypomaner.dto.converterdto;

import com.ddzj.mypomaner.dto.FieldTemplateSaveDto;
import com.ddzj.mypomaner.entity.TblFieldTemplate;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Author:yangzibo
 * @CreateTime:2024-02-15 10:37
 * @Description:
 * @Version:1.0
 **/
@Mapper(componentModel = "Spring")
public interface FieldTemplateDtoConverter {
    List<FieldTemplateSaveDto> entityToSaveDto(List<TblFieldTemplate> tblFieldTemplates);

}
