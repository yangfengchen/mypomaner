package com.ddzj.mypomaner.dto.converterdto;

import com.ddzj.mypomaner.dto.FileTemplateSaveDto;
import com.ddzj.mypomaner.entity.TblFileTemplate;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Author:yangzibo
 * @CreateTime:2024-02-15 10:37
 * @Description:
 * @Version:1.0
 **/
@Mapper(componentModel = "Spring")
public interface FileTemplateDtoConverter {
    List<FileTemplateSaveDto> entityToSaveDto(List<TblFileTemplate> tblFileTemplates);

}
