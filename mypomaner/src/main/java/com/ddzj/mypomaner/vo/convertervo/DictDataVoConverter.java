package com.ddzj.mypomaner.vo.convertervo;

import com.ddzj.mypomaner.entity.TblDictData;
import com.ddzj.mypomaner.vo.DictDataListVo;
import com.ddzj.mypomaner.vo.DictDataViewVo;
import com.ddzj.mypomaner.vo.DictTypeViewVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * @Author:yangzibo
 * @CreateTime:2023-12-24 13:37
 * @Description:
 * @Version:1.0
 **/
@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDataVoConverter {
    /*@Mapping(ignore = true, target = "dictName")*/
    DictDataListVo dictDataToListVo(TblDictData dictDataDto);

/*
    @Mapping(ignore = true, target = "dictName")
*/
    DictDataViewVo dictDataToViewVo(TblDictData dictDataDto);
}
