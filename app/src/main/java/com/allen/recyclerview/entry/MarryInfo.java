/*
******************************* Copyright (c)*********************************\
**
**                 (c) Copyright 2015, Allen, china, shanghai
**                          All Rights Reserved
**
**                          
**                         
**-----------------------------------版本信息------------------------------------
** 版    本: V0.1
**
**------------------------------------------------------------------------------
********************************End of Head************************************\
*/
package com.allen.recyclerview.entry;

/**
 * 文 件 名: MarryInfo
 * 创 建 人: Allen
 * 创建日期: 17/1/6 22:44
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
public class MarryInfo {

    private String name;
    private String phone;
    private boolean isRepeat;
    private boolean isValid;
    public boolean isShow=false;


    public MarryInfo(final String name, final String phone, final boolean isRepeat, final boolean isValid) {
        this.name = name;
        this.phone = phone;
        this.isRepeat = isRepeat;
        this.isValid = isValid;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public boolean isRepeat() {
        return isRepeat;
    }

    public void setRepeat(final boolean repeat) {
        isRepeat = repeat;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(final boolean valid) {
        isValid = valid;
    }
}
