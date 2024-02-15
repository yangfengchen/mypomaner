package com.ddzj.mypomaner.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ddzj.mypomaner.dto.ProjectInfoSaveDto;
import com.ddzj.mypomaner.dto.ProjectInfoSearchPageDto;
import com.ddzj.mypomaner.entity.TblProjectInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ddzj.mypomaner.entity.TblProjectTable;

import java.util.List;

/**
 * <p>
 * 项目信息表; 服务类
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
public interface ITblProjectInfoService extends IService<TblProjectInfo> {
    /**
     * 分页查询字段表
     * @param page
     * @param searchPageDto
     * @return
     */
    IPage<TblProjectInfo> queryPageByEntityDto(IPage<TblProjectInfo> page, ProjectInfoSearchPageDto searchPageDto);

    /**
     * 根据id 查询字典表
     * @param id
     * @return
     */
    TblProjectInfo findById(String id);

    /**
     * 保存字段配置
     * @param saveDto
     * @return
     */
    TblProjectInfo saveDto(ProjectInfoSaveDto saveDto);

    /**
     * 根据id删除数据
     * @param id
     */
    void delteById(String id);

    /**
     * 查询获取所有项目信息
     * @param searchDto
     * @return
     */
    List<TblProjectInfo> findListBySearchDto(ProjectInfoSearchPageDto searchDto);

    /**
     * 根据项目编码获取项目信息
     * @param projectCode
     * @return
     */
    TblProjectInfo findByProjectCode(String projectCode);
}
