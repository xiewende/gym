import request from '@/utils/request_yusen'

// 获取所有器材组
export function getAllEquipment(params) {
  return request({
    url: '/equipment/',
    method: 'get',
    params
  })
}

// 添加器材
export function addEquipment(params) {
  return request({
    url: '/equipment/',
    method: 'post',
    params
  })
}
// 修改
export function updateEquipment(params) {
  return request({
    url: '/equipment/' + params['id'],
    method: 'put',
    params
  })
}

// 删除
export function deleteEquipment(id) {
  return request({
    url: '/equipment/' + id,
    method: 'delete'
  })
}
// 查询
export function queryEquipment(params) {
  return request({
    url: '/equipment/searchByName',
    method: 'get',
    params
  })
}
// 器材报废列表
export function getAllScrapEquipment(params) {
  return request({
    url: '/equipment/scrap/',
    method: 'get',
    params
  })
}
// 新增器材报废
export function scrapEquipment(params) {
  return request({
    url: '/equipment/scrap/',
    method: 'post',
    params
  })
}
// 器材报废记录查询
export function queryScrapEquipment(params) {
  return request({
    url: '/equipment/scrap/' + params['id'],
    method: 'get',
    params
  })
}
// 器材报废记录删除
export function deleteScrapEquipment(id) {
  return request({
    url: '/equipment/scrap/' + id,
    method: 'delete',
    params: {
      id: id
    }
  })
}

// 器材新增申请
export function applyEquipment(params) {
  return request({
    url: '/equipment/apply/',
    method: 'post',
    params
  })
}
// 器材维修申请
export function reportEquipment(params) {
  return request({
    url: '/equipment/damageReport/',
    method: 'post',
    params
  })
}
// 器材维修申请列表
export function getAllReportEquipment(params) {
  return request({
    url: '/equipment/damageReport/',
    method: 'get',
    params
  })
}
// 根据用户Id获取维修申请列表
export function getReportEquipmentById(params) {
  return request({
    url: '/equipment/damageReport/searchByUserId',
    method: 'get',
    params
  })
}
// 查询器材维修申请
export function queryReportEquipment(params) {
  return request({
    url: '/equipment/damageReport/' + params['id'],
    method: 'get',
    params
  })
}
// 删除器材维修申请
export function deleteReportEquipment(id) {
  return request({
    url: '/equipment/damageReport/' + id,
    method: 'delete'

  })
}
// 设置器材损坏
export function setBreakdown(id) {
  return request({
    url: '/equipment/damageReport/' + id + '/breakdown',
    method: 'post'
  })
}
// 设置器材修好
export function setRepair(id) {
  return request({
    url: '/equipment/damageReport/' + id + '/repair',
    method: 'post'
  })
}
// 设置器材报废
export function setScrap(params) {
  return request({
    url: '/equipment/damageReport/' + params['id'] + '/scrap',
    method: 'post',
    params
  })
}
