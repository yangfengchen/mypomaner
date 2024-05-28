package com.ddzj.mypomaner.buildcode.entity;

/**
 * <p>
 *
 * </p>
 *
 * <p>
 * Copyright: 2019 . All rights reserved.
 * </p>
 * <p>
 * Company: Zsoft
 * </p>
 * <p>
 * CreateDate:2019-12-11
 * </p>
 *
 * @author pc
 * @history Mender:pc；Date:2019-12-11；
 */

public class TableColumn {

  private String columnName;
  private String des;
  private String columnType;
  // 是否索引
  private Boolean indexStatus;
  // 索引前缀名称
  private String indexName;


  /**
   * 获取
   *
   * @return columnName
   */
  public String getColumnName() {
    return this.columnName;
  }

  /**
   * 设置
   *
   * @param columnName
   */
  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }

  /**
   * 获取
   *
   * @return des
   */
  public String getDes() {
    return this.des;
  }

  /**
   * 设置
   *
   * @param des
   */
  public void setDes(String des) {
    this.des = des;
  }

  /**
   * 获取
   *
   * @return columnType
   */
  public String getColumnType() {
    return this.columnType;
  }

  /**
   * 设置
   *
   * @param columnType
   */
  public void setColumnType(String columnType) {
    this.columnType = columnType;
  }

  public Boolean getIndexStatus() {
    return indexStatus;
  }

  public void setIndexStatus(Boolean indexStatus) {
    this.indexStatus = indexStatus;
  }

  public String getIndexName() {
    return indexName;
  }

  public void setIndexName(String indexName) {
    this.indexName = indexName;
  }
}
