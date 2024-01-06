package com.ddzj.mypomaner.vo.convertervo;

import com.ddzj.mypomaner.entity.TblDictType;
import com.ddzj.mypomaner.vo.DictTypeListVo;
import com.ddzj.mypomaner.vo.DictTypeViewVo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Author:yangzibo
 * @CreateTime:2023-12-23 23:45
 * @Description:
 * @Version:1.0
 **/
@Mapper(componentModel = "Spring")
public interface DictTypeVoConverter {
    //DictTypeConverter INSTANCE = Mappers.getMapper(DictTypeConverter.class);

    DictTypeViewVo tblDictTypeToDictTypeViewVo(TblDictType dictTypeDto);

    List<DictTypeListVo> tblDictTypeToDictTypeListVo(List<TblDictType> dictTypeDtos);
}
