import request from '@/utils/request_yusen'

// 获取所有器材组
export function getAllEquipmentGroup(params) {
  return request({
    url: '/equipment/group/',
    method: 'get',
    params
  })
}

// 添加器材组
export function addEquipmentGroup(params) {
  return request({
    url: '/equipment/group/',
    method: 'post',
    params
  })
}
// 修改
export function updateEquipmentGroup(params) {
  return request({
    url: '/equipment/group/' + params['id'],
    method: 'put',
    params
  })
}
// 删除
export function deleteEquipmentGroup(id) {
  return request({
    url: '/equipment/group/' + id,
    method: 'delete'
  })
}
// 查询
export function queryEquipmentGroup(params) {
  return request({
    url: '/equipment/group/searchByName',
    method: 'get',
    params
  })
}
// 获取器材组下的所有器材
export function getEquipments(params) {
  return request({
    url: '/equipment/group/' + params.id + '/equipments',
    method: 'get',
    params
  })
}
