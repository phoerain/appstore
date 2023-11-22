package com.appstore.modules.app.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.appstore.common.annotation.Excel;
import com.appstore.common.core.domain.BaseEntity;

/**
 * 应用商店对象 su_apps
 * 
 * @author phoerain
 * @date 2023-11-22
 */
public class SuApps extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 应用ID */
    private Long appId;

    /** 应用logo */
    @Excel(name = "应用logo")
    private String appLogo;

    /** 应用名称 */
    @Excel(name = "应用名称")
    private String appName;

    /** 应用描述 */
    @Excel(name = "应用描述")
    private String addDescription;

    /** 应用版本 */
    @Excel(name = "应用版本")
    private String appVersion;

    /** 作者ID */
    @Excel(name = "作者ID")
    private Long authorId;

    /** 作者姓名 */
    @Excel(name = "作者姓名")
    private String authorName;

    /** 作者电话 */
    @Excel(name = "作者电话")
    private String authorPhone;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String appPath;

    /** 文件大小 */
    @Excel(name = "文件大小")
    private Long appSize;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatTime;

    /** 是否删除（0：否，1：是） */
    @Excel(name = "是否删除", readConverterExp = "0=：否，1：是")
    private String isDel;

    public void setAppId(Long appId) 
    {
        this.appId = appId;
    }

    public Long getAppId() 
    {
        return appId;
    }
    public void setAppLogo(String appLogo) 
    {
        this.appLogo = appLogo;
    }

    public String getAppLogo() 
    {
        return appLogo;
    }
    public void setAppName(String appName) 
    {
        this.appName = appName;
    }

    public String getAppName() 
    {
        return appName;
    }
    public void setAddDescription(String addDescription) 
    {
        this.addDescription = addDescription;
    }

    public String getAddDescription() 
    {
        return addDescription;
    }
    public void setAppVersion(String appVersion) 
    {
        this.appVersion = appVersion;
    }

    public String getAppVersion() 
    {
        return appVersion;
    }
    public void setAuthorId(Long authorId) 
    {
        this.authorId = authorId;
    }

    public Long getAuthorId() 
    {
        return authorId;
    }
    public void setAuthorName(String authorName) 
    {
        this.authorName = authorName;
    }

    public String getAuthorName() 
    {
        return authorName;
    }
    public void setAuthorPhone(String authorPhone) 
    {
        this.authorPhone = authorPhone;
    }

    public String getAuthorPhone() 
    {
        return authorPhone;
    }
    public void setAppPath(String appPath) 
    {
        this.appPath = appPath;
    }

    public String getAppPath() 
    {
        return appPath;
    }
    public void setAppSize(Long appSize) 
    {
        this.appSize = appSize;
    }

    public Long getAppSize() 
    {
        return appSize;
    }
    public void setCreatTime(Date creatTime) 
    {
        this.creatTime = creatTime;
    }

    public Date getCreatTime() 
    {
        return creatTime;
    }
    public void setIsDel(String isDel) 
    {
        this.isDel = isDel;
    }

    public String getIsDel() 
    {
        return isDel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("appId", getAppId())
            .append("appLogo", getAppLogo())
            .append("appName", getAppName())
            .append("addDescription", getAddDescription())
            .append("appVersion", getAppVersion())
            .append("authorId", getAuthorId())
            .append("authorName", getAuthorName())
            .append("authorPhone", getAuthorPhone())
            .append("appPath", getAppPath())
            .append("appSize", getAppSize())
            .append("createBy", getCreateBy())
            .append("creatTime", getCreatTime())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("isDel", getIsDel())
            .toString();
    }
}
