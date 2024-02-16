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

public class EntityClass {

  private String classPath;
  private String createFileDate;
  private String createFileDateYear;
  private String createFileAuth;
  private String className;
  private String tableName;
  private String extendName;
  private List<ColumnClass> columnClassList;
  private String des;
  private String abstractDomainPath;


  /**
   * 获取
   *
   * @return classPath
   */
  public String getClassPath() {
    return this.classPath;
  }

  /**
   * 设置
   *
   * @param classPath
   */
  public void setClassPath(String classPath) {
    this.classPath = classPath;
  }

  /**
   * 获取
   *
   * @return createFileDate
   */
  public String getCreateFileDate() {
    return this.createFileDate;
  }

  /**
   * 设置
   *
   * @param createFileDate
   */
  public void setCreateFileDate(String createFileDate) {
    this.createFileDate = createFileDate;
  }

  /**
   * 获取
   *
   * @return createFileDateYear
   */
  public String getCreateFileDateYear() {
    return this.createFileDateYear;
  }

  /**
   * 设置
   *
   * @param createFileDateYear
   */
  public void setCreateFileDateYear(String createFileDateYear) {
    this.createFileDateYear = createFileDateYear;
  }

  /**
   * 获取
   *
   * @return createFileAuth
   */
  public String getCreateFileAuth() {
    return this.createFileAuth;
  }

  /**
   * 设置
   *
   * @param createFileAuth
   */
  public void setCreateFileAuth(String createFileAuth) {
    this.createFileAuth = createFileAuth;
  }

  /**
   * 获取
   *
   * @return className
   */
  public String getClassName() {
    return this.className;
  }

  /**
   * 设置
   *
   * @param className
   */
  public void setClassName(String className) {
    this.className = className;
  }

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
   * @return extendName
   */
  public String getExtendName() {
    return this.extendName;
  }

  /**
   * 设置
   *
   * @param extendName
   */
  public void setExtendName(String extendName) {
    this.extendName = extendName;
  }

  /**
   * 获取
   *
   * @return columnClassList
   */
  public List<ColumnClass> getColumnClassList() {
    return this.columnClassList;
  }

  /**
   * 设置
   *
   * @param columnClassList
   */
  public void setColumnClassList(List<ColumnClass> columnClassList) {
    this.columnClassList = columnClassList;
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
   * @return abstractDomainPath
   */
  public String getAbstractDomainPath() {
    return this.abstractDomainPath;
  }

  /**
   * 设置
   *
   * @param abstractDomainPath
   */
  public void setAbstractDomainPath(String abstractDomainPath) {
    this.abstractDomainPath = abstractDomainPath;
  }
}
