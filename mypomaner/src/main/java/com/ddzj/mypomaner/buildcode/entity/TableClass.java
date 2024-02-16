package com.ddzj.mypomaner.buildcode.entity;

import java.util.List;

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

public class TableClass {

  private String tableName;
  private String tableDesc;
  private List<TableColumn> columnList;
  private List<TableColumn> staticTableColumns;


  /**
   * 获取
   *
   * @return tableName
   */
  public String getTableName() {
    return this.tableName;
  }

  /**
   * 设置
   *
   * @param tableName
   */
  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  /**
   * 获取
   *
   * @return tableDesc
   */
  public String getTableDesc() {
    return this.tableDesc;
  }

  /**
   * 设置
   *
   * @param tableDesc
   */
  public void setTableDesc(String tableDesc) {
    this.tableDesc = tableDesc;
  }

  /**
   * 获取
   *
   * @return columnList
   */
  public List<TableColumn> getColumnList() {
    return this.columnList;
  }

  /**
   * 设置
   *
   * @param columnList
   */
  public void setColumnList(List<TableColumn> columnList) {
    this.columnList = columnList;
  }

  /**
   * 获取
   *
   * @return staticTableColumns
   */
  public List<TableColumn> getStaticTableColumns() {
    return this.staticTableColumns;
  }

  /**
   * 设置
   *
   * @param staticTableColumns
   */
  public void setStaticTableColumns(List<TableColumn> staticTableColumns) {
    this.staticTableColumns = staticTableColumns;
  }
}
