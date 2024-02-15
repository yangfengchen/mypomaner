package com.ddzj.mypomaner.vo.convertervo;

import com.ddzj.mypomaner.entity.TblProjectInfo;
import com.ddzj.mypomaner.vo.ProjectInfoListVo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @Author:yangzibo
 * @CreateTime:2024-02-15 15:19
 * @Description:
 * @Version:1.0
 **/
@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectInfoVoConverter {
    List<ProjectInfoListVo> entityListToListVos(List<TblProjectInfo> tblProjectInfoList);

    ProjectInfoListVo entityToListVo(TblProjectInfo tblProjectInfo);
}
