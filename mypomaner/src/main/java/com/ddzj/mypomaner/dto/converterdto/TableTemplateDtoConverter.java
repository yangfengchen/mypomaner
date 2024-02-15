package com.ddzj.mypomaner.dto.converterdto;

import com.ddzj.mypomaner.dto.TableTemplateSaveDto;
import com.ddzj.mypomaner.entity.TblTableTemplate;
import org.mapstruct.Mapper;

/**
 * @Author:yangzibo
 * @CreateTime:2024-02-15 11:59
 * @Description:
 * @Version:1.0
 **/
@Mapper(componentModel = "Spring")
public interface TableTemplateDtoConverter {

    TableTemplateSaveDto tableTemplateToEditDto(TblTableTemplate tblTableTemplate);

}
