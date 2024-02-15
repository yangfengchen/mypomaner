package com.ddzj.mypomaner.vo.convertervo;

import com.ddzj.mypomaner.entity.TblProjectTable;
import com.ddzj.mypomaner.vo.ProjectTableListVo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @Author:yangzibo
 * @CreateTime:2024-02-15 20:03
 * @Description:
 * @Version:1.0
 **/
@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectTableVoConverter {
    ProjectTableListVo entityToListVo(TblProjectTable projectTable);

    List<ProjectTableListVo> entityListToListVos(List<TblProjectTable> projectTableList);
}
