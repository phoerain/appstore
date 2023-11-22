import request from '@/utils/request'

// 查询应用商店列表
export function listAppstore(query) {
  return request({
    url: '/appstore/appstore/list',
    method: 'get',
    params: query
  })
}

// 查询应用商店详细
export function getAppstore(appId) {
  return request({
    url: '/appstore/appstore/' + appId,
    method: 'get'
  })
}

// 新增应用商店
export function addAppstore(data) {
  return request({
    url: '/appstore/appstore',
    method: 'post',
    data: data
  })
}

// 修改应用商店
export function updateAppstore(data) {
  return request({
    url: '/appstore/appstore',
    method: 'put',
    data: data
  })
}

// 删除应用商店
export function delAppstore(appId) {
  return request({
    url: '/appstore/appstore/' + appId,
    method: 'delete'
  })
}
