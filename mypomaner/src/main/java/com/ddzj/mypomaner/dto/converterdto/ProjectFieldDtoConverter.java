package com.ddzj.mypomaner.dto.converterdto;

import com.ddzj.mypomaner.dto.ProjectFieldSaveDto;
import com.ddzj.mypomaner.entity.TblFieldTemplate;
import com.ddzj.mypomaner.entity.TblProjectField;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Author:yangzibo
 * @CreateTime:2024-02-15 20:22
 * @Description:
 * @Version:1.0
 **/
@Mapper(componentModel = "Spring")
public interface ProjectFieldDtoConverter {

    ProjectFieldSaveDto entityToSaveDto(TblProjectField tblProjectField);

    List<ProjectFieldSaveDto> entityListToSaveDtos(List<TblProjectField> tblProjectFieldList);

    ProjectFieldSaveDto templateEntityToSaveDto(TblFieldTemplate tblFieldTemplate);

    TblProjectField saveDtoToFiledEntity(ProjectFieldSaveDto saveDto);
}
