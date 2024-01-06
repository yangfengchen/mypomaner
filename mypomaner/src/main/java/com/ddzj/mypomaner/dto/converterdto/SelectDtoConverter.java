package com.ddzj.mypomaner.dto.converterdto;

import com.ddzj.mypomaner.dto.SelectDto;
import com.ddzj.mypomaner.entity.TblDictData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @Author:yangzibo
 * @CreateTime:2024-01-02 07:39
 * @Description:
 * @Version:1.0
 **/
@Mapper(componentModel = "Spring")
public interface SelectDtoConverter {

    @Mappings({
            @Mapping(source="dictLabel", target = "label"),
            @Mapping(source="dictValue", target = "value")
    })
    SelectDto tblDictDataToSelectDto(TblDictData tblDictData);

    @Mappings({
            @Mapping(source="dictLabel", target = "label"),
            @Mapping(source="dictValue", target = "value")
    })
    List<SelectDto> tblDictDataToSelectDto(List<TblDictData> tblDictDatas);

}
