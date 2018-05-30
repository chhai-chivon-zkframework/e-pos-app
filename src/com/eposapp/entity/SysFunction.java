package com.eposapp.entity;

import java.util.Date;

/**
 * All rights reserved.
 *
 * @author chhai chivon on 11-May-18
 */
public class SysFunction {
    private String appCode;
    private String funcId;
    private String funcDesc;
    private String funcGroup;
    private String iconFile;
    private String orderLevel;
    private String departmentId;
    private String recordStatus;
    private String authStat;
    private String makerId;
    private Date makerDate;


    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    public String getFuncDesc() {
        return funcDesc;
    }

    public void setFuncDesc(String funcDesc) {
        this.funcDesc = funcDesc;
    }

    public String getFuncGroup() {
        return funcGroup;
    }

    public void setFuncGroup(String funcGroup) {
        this.funcGroup = funcGroup;
    }

    public String getIconFile() {
        return iconFile;
    }

    public void setIconFile(String iconFile) {
        this.iconFile = iconFile;
    }

    public String getOrderLevel() {
        return orderLevel;
    }

    public void setOrderLevel(String orderLevel) {
        this.orderLevel = orderLevel;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getAuthStat() {
        return authStat;
    }

    public void setAuthStat(String authStat) {
        this.authStat = authStat;
    }

    public String getMakerId() {
        return makerId;
    }

    public void setMakerId(String makerId) {
        this.makerId = makerId;
    }

    public Date getMakerDate() {
        return makerDate;
    }

    public void setMakerDate(Date makerDate) {
        this.makerDate = makerDate;
    }
}
