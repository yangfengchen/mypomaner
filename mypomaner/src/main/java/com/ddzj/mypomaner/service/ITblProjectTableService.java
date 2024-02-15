package com.ddzj.mypomaner.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ddzj.mypomaner.dto.*;
import com.ddzj.mypomaner.entity.TblProjectTable;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 项目表管理; 服务类
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
public interface ITblProjectTableService extends IService<TblProjectTable> {
    /**
     * 分页查询项目表
     * @param page
     * @param searchPageDto
     * @return
     */
    IPage<TblProjectTable> queryPageByEntityDto(IPage<TblProjectTable> page, ProjectTableSearchPageDto searchPageDto);

    /**
     * 根据id 查询项目表
     * @param id
     * @return
     */
    TblProjectTable findById(String id);

    /**
     * 保存项目表
     * @param saveDto
     * @return
     */
    TblProjectTable saveDto(ProjectTableSaveDto saveDto);

    /**
     * 根据id删除数据
     * @param id
     */
    void delteById(String id);
}
