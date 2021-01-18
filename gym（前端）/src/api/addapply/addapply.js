import request from '@/utils/request_yusen'
// 获取新增申请
export function getAllApply(params) {
  return request({
    url: '/Equipment/apply/',
    method: 'get',
    params
  })
}
// 新增申请
export function addApply(params) {
  return request({
    url: '/Equipment/apply/',
    method: 'post',
    params
  })
}
// 修改申请
export function updateApply(params) {
  return request({
    url: '/Equipment/apply/' + params['id'],
    method: 'put',
    params
  })
}
// 查询申请信息
export function queryApply(params) {
  return request({
    url: '/Equipment/apply/' + params['id'],
    method: 'get',
    params
  })
}
// 删除申请
export function deleteApply(id) {
  return request({
    url: '/Equipment/apply/' + id,
    method: 'delete'
  })
}
// 根据用户获取列表
export function getApplyById(params) {
  return request({
    url: '/Equipment/apply/searchByUserId',
    method: 'get',
    params
  })
}
export function getApplyByName(params) {
  return request({
    url: '/Equipment/apply/searchByName',
    method: 'get',
    params
  })
}
