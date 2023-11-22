package com.appstore.modules.app.service;

import com.appstore.modules.app.domain.SuApps;

import java.util.List;

/**
 * 应用商店Service接口
 * 
 * @author phoerain
 * @date 2023-11-22
 */
public interface ISuAppsService 
{
    /**
     * 查询应用商店
     * 
     * @param appId 应用商店主键
     * @return 应用商店
     */
    public SuApps selectSuAppsByAppId(Long appId);

    /**
     * 查询应用商店列表
     * 
     * @param suApps 应用商店
     * @return 应用商店集合
     */
    public List<SuApps> selectSuAppsList(SuApps suApps);

    /**
     * 新增应用商店
     * 
     * @param suApps 应用商店
     * @return 结果
     */
    public int insertSuApps(SuApps suApps);

    /**
     * 修改应用商店
     * 
     * @param suApps 应用商店
     * @return 结果
     */
    public int updateSuApps(SuApps suApps);

    /**
     * 批量删除应用商店
     * 
     * @param appIds 需要删除的应用商店主键集合
     * @return 结果
     */
    public int deleteSuAppsByAppIds(Long[] appIds);

    /**
     * 删除应用商店信息
     * 
     * @param appId 应用商店主键
     * @return 结果
     */
    public int deleteSuAppsByAppId(Long appId);
}
