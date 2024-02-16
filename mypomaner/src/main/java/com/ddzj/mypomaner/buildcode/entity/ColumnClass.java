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
 * CreateDate:2019-08-28
 * </p>
 *
 * @author pc
 * @history Mender:pc；Date:2019-08-28；
 */

public class ColumnClass {

  /** 数据库字段名称 **/
  private String columnName;
  /** 代码字段类型 **/
  private String columnType;
  /** 数据库字段长度 **/
  private String columnLength;
  /** 数据库字段首字母小写且去掉下划线字符串 **/
  private String changeColumnName;
  /** 数据库字段注释 **/
  private String columnComment;
  /** 数据库字段首字母大写且去掉下划线字符串 **/
  private String changeColumnNameDx;

  private String colomnDbName;


  /**
   * 获取 数据库字段名称
   *
   * @return columnName 数据库字段名称
   */
  public String getColumnName() {
    return this.columnName;
  }

  /**
   * 设置 数据库字段名称
   *
   * @param columnName 数据库字段名称
   */
  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }

  /**
   * 获取 数据库字段类型
   *
   * @return columnType 数据库字段类型
   */
  public String getColumnType() {
    return this.columnType;
  }

  /**
   * 设置 数据库字段类型
   *
   * @param columnType 数据库字段类型
   */
  public void setColumnType(String columnType) {
    this.columnType = columnType;
  }

  /**
   * 获取 数据库字段长度
   *
   * @return columnLength 数据库字段长度
   */
  public String getColumnLength() {
    return this.columnLength;
  }

  /**
   * 设置 数据库字段长度
   *
   * @param columnLength 数据库字段长度
   */
  public void setColumnLength(String columnLength) {
    this.columnLength = columnLength;
  }

  /**
   * 获取 数据库字段首字母小写且去掉下划线字符串
   *
   * @return changeColumnName 数据库字段首字母小写且去掉下划线字符串
   */
  public String getChangeColumnName() {
    return this.changeColumnName;
  }

  /**
   * 设置 数据库字段首字母小写且去掉下划线字符串
   *
   * @param changeColumnName 数据库字段首字母小写且去掉下划线字符串
   */
  public void setChangeColumnName(String changeColumnName) {
    this.changeColumnName = changeColumnName;
  }

  /**
   * 获取 数据库字段注释
   *
   * @return columnComment 数据库字段注释
   */
  public String getColumnComment() {
    return this.columnComment;
  }

  /**
   * 设置 数据库字段注释
   *
   * @param columnComment 数据库字段注释
   */
  public void setColumnComment(String columnComment) {
    this.columnComment = columnComment;
  }

  /**
   * 获取 数据库字段首字母大写且去掉下划线字符串
   *
   * @return changeColumnNameDx 数据库字段首字母大写且去掉下划线字符串
   */
  public String getChangeColumnNameDx() {
    return this.changeColumnNameDx;
  }

  /**
   * 设置 数据库字段首字母大写且去掉下划线字符串
   *
   * @param changeColumnNameDx 数据库字段首字母大写且去掉下划线字符串
   */
  public void setChangeColumnNameDx(String changeColumnNameDx) {
    this.changeColumnNameDx = changeColumnNameDx;
  }

  /**
   * 获取
   *
   * @return colomnDbName
   */
  public String getColomnDbName() {
    return this.colomnDbName;
  }

  /**
   * 设置
   *
   * @param colomnDbName
   */
  public void setColomnDbName(String colomnDbName) {
    this.colomnDbName = colomnDbName;
  }
}
