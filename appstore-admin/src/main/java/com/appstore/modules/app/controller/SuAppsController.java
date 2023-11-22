package com.appstore.modules.app.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.appstore.modules.app.domain.SuApps;
import com.appstore.modules.app.service.ISuAppsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.appstore.common.annotation.Log;
import com.appstore.common.core.controller.BaseController;
import com.appstore.common.core.domain.AjaxResult;
import com.appstore.common.enums.BusinessType;
import com.appstore.common.utils.poi.ExcelUtil;
import com.appstore.common.core.page.TableDataInfo;

/**
 * 应用商店Controller
 * 
 * @author phoerain
 * @date 2023-11-22
 */
@RestController
@RequestMapping("/appstore/appstore")
public class SuAppsController extends BaseController
{
    @Autowired
    private ISuAppsService suAppsService;

    /**
     * 查询应用商店列表
     */
    @PreAuthorize("@ss.hasPermi('appstore:appstore:list')")
    @GetMapping("/list")
    public TableDataInfo list(SuApps suApps)
    {
        startPage();
        List<SuApps> list = suAppsService.selectSuAppsList(suApps);
        return getDataTable(list);
    }

    /**
     * 导出应用商店列表
     */
    @PreAuthorize("@ss.hasPermi('appstore:appstore:export')")
    @Log(title = "应用商店", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SuApps suApps)
    {
        List<SuApps> list = suAppsService.selectSuAppsList(suApps);
        ExcelUtil<SuApps> util = new ExcelUtil<SuApps>(SuApps.class);
        util.exportExcel(response, list, "应用商店数据");
    }

    /**
     * 获取应用商店详细信息
     */
    @PreAuthorize("@ss.hasPermi('appstore:appstore:query')")
    @GetMapping(value = "/{appId}")
    public AjaxResult getInfo(@PathVariable("appId") Long appId)
    {
        return success(suAppsService.selectSuAppsByAppId(appId));
    }

    /**
     * 新增应用商店
     */
    @PreAuthorize("@ss.hasPermi('appstore:appstore:add')")
    @Log(title = "应用商店", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SuApps suApps)
    {
        return toAjax(suAppsService.insertSuApps(suApps));
    }

    /**
     * 修改应用商店
     */
    @PreAuthorize("@ss.hasPermi('appstore:appstore:edit')")
    @Log(title = "应用商店", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SuApps suApps)
    {
        return toAjax(suAppsService.updateSuApps(suApps));
    }

    /**
     * 删除应用商店
     */
    @PreAuthorize("@ss.hasPermi('appstore:appstore:remove')")
    @Log(title = "应用商店", businessType = BusinessType.DELETE)
	@DeleteMapping("/{appIds}")
    public AjaxResult remove(@PathVariable Long[] appIds)
    {
        return toAjax(suAppsService.deleteSuAppsByAppIds(appIds));
    }
}
