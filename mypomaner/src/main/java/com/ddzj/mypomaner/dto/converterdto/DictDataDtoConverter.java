package com.ddzj.mypomaner.dto.converterdto;

import com.ddzj.mypomaner.dto.DictDataSaveDto;
import com.ddzj.mypomaner.entity.TblDictData;
import org.mapstruct.Mapper;

/**
 * @Author:yangzibo
 * @CreateTime:2023-12-24 13:37
 * @Description:
 * @Version:1.0
 **/
@Mapper(componentModel = "Spring")
public interface DictDataDtoConverter {

    DictDataSaveDto tblDictDataToDictDataSaveDto(TblDictData dictDataDto);

}
