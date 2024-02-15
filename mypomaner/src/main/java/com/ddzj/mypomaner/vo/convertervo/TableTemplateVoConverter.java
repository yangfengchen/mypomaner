package com.ddzj.mypomaner.vo.convertervo;

import com.ddzj.mypomaner.entity.TblFieldConfig;
import com.ddzj.mypomaner.entity.TblTableTemplate;
import com.ddzj.mypomaner.vo.TableTemplateListVo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @Author:yangzibo
 * @CreateTime:2024-02-15 11:53
 * @Description:
 * @Version:1.0
 **/
@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TableTemplateVoConverter {

    List<TableTemplateListVo> tableTemplateToListVo(List<TblTableTemplate> tableTemplates);
}
