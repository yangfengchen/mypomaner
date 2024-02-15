package com.ddzj.mypomaner.service;

import com.ddzj.mypomaner.entity.TblProjectConfig;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 项目配置; 服务类
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
public interface ITblProjectConfigService extends IService<TblProjectConfig> {

    /**
     * 根据项目编码 集合获取项目配置
     * @param projectCodeList
     * @return
     */
    List<TblProjectConfig> findByProjectCodeList(List<String> projectCodeList);

    /**
     * 根据项目编码 获取项目配置
     * @param projectCode
     * @return
     */
    TblProjectConfig findByProjectCode(String projectCode);

}
