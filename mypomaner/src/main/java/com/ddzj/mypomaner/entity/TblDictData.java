package com.ddzj.mypomaner.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 字典数据表;
 * </p>
 *
 * @author yzb
 * @since 2023-12-23
 */
@TableName("TBL_DICT_DATA")
public class TblDictData extends AbstractEntity  {

    private static final long serialVersionUID = 1L;


    private String dictLabel;

    private String dictValue;

    private Integer dictSort;

    private String dictCode;

    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public Integer getDictSort() {
        return dictSort;
    }

    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    @Override
    public String toString() {
        return "TblDictData{" +
                "id = " + id +
                ", tenantId = " + tenantId +
                ", revision = " + revision +
                ", createdBy = " + createdBy +
                ", createdTime = " + createdTime +
                ", updatedBy = " + updatedBy +
                ", updatedTime = " + updatedTime +
                ", dictLabel = " + dictLabel +
                ", dictValue = " + dictValue +
                ", dictSort = " + dictSort +
                ", dictCode = " + dictCode +
                "}";
    }
}
