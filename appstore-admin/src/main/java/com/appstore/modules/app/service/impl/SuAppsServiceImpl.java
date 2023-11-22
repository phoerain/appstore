package com.appstore.modules.app.service.impl;

import java.util.List;
import com.appstore.common.utils.DateUtils;
import com.appstore.modules.app.domain.SuApps;
import com.appstore.modules.app.mapper.SuAppsMapper;
import com.appstore.modules.app.service.ISuAppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 应用商店Service业务层处理
 * 
 * @author phoerain
 * @date 2023-11-22
 */
@Service
public class SuAppsServiceImpl implements ISuAppsService
{
    @Autowired
    private SuAppsMapper suAppsMapper;

    /**
     * 查询应用商店
     * 
     * @param appId 应用商店主键
     * @return 应用商店
     */
    @Override
    public SuApps selectSuAppsByAppId(Long appId)
    {
        return suAppsMapper.selectSuAppsByAppId(appId);
    }

    /**
     * 查询应用商店列表
     * 
     * @param suApps 应用商店
     * @return 应用商店
     */
    @Override
    public List<SuApps> selectSuAppsList(SuApps suApps)
    {
        return suAppsMapper.selectSuAppsList(suApps);
    }

    /**
     * 新增应用商店
     * 
     * @param suApps 应用商店
     * @return 结果
     */
    @Override
    public int insertSuApps(SuApps suApps)
    {
        return suAppsMapper.insertSuApps(suApps);
    }

    /**
     * 修改应用商店
     * 
     * @param suApps 应用商店
     * @return 结果
     */
    @Override
    public int updateSuApps(SuApps suApps)
    {
        suApps.setUpdateTime(DateUtils.getNowDate());
        return suAppsMapper.updateSuApps(suApps);
    }

    /**
     * 批量删除应用商店
     * 
     * @param appIds 需要删除的应用商店主键
     * @return 结果
     */
    @Override
    public int deleteSuAppsByAppIds(Long[] appIds)
    {
        return suAppsMapper.deleteSuAppsByAppIds(appIds);
    }

    /**
     * 删除应用商店信息
     * 
     * @param appId 应用商店主键
     * @return 结果
     */
    @Override
    public int deleteSuAppsByAppId(Long appId)
    {
        return suAppsMapper.deleteSuAppsByAppId(appId);
    }
}
