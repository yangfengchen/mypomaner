package com.ddzj.mypomaner.vo.convertervo;

import com.ddzj.mypomaner.dto.FieldConfigSaveDto;
import com.ddzj.mypomaner.entity.TblDictData;
import com.ddzj.mypomaner.entity.TblFieldConfig;
import com.ddzj.mypomaner.vo.DictDataListVo;
import com.ddzj.mypomaner.vo.DictDataViewVo;
import com.ddzj.mypomaner.vo.FieldConfigListVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @Author:yangzibo
 * @CreateTime:2023-12-24 13:37
 * @Description:
 * @Version:1.0
 **/
@Mapper(componentModel = "Spring")
public interface FieldConfigVoConverter {

    @Mappings({
            @Mapping(ignore = true, target = "databaseTypeName"),
            @Mapping(ignore = true, target = "fieldDbTypeName")
    })
    FieldConfigListVo tblFieldConfigToFieldConfigListVo(TblFieldConfig tblFieldConfig);

    /*@Mappings({
            @Mapping(ignore = true, target = "databaseTypeName"),
            @Mapping(ignore = true, target = "fieldDbTypeName")
    })*/
//    FieldConfigSaveDto tblFieldConfigToFieldConfigListVo(TblFieldConfig tblFieldConfig);

    /*@Mappings({
            @Mapping(ignore = true, target = "databaseTypeName"),
            @Mapping(ignore = true, target = "fieldDbTypeName")
    })*/
/*
    List<FieldConfigSaveDto> tblFieldConfigToFieldConfigSaveDto(List<TblFieldConfig> tblFieldConfigs);
*/
}
