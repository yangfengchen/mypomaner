package com.ddzj.mypomaner.service;

import com.ddzj.mypomaner.entity.TblProjectField;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 项目字段表; 服务类
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
public interface ITblProjectFieldService extends IService<TblProjectField> {

    /**
     * 根据项目编码及表id查询项目表对应字段集合
     * @param projectCode
     * @param tableId
     * @return
     */
    List<TblProjectField> findByProjectCodeAndTableId(String projectCode, String tableId);

}
