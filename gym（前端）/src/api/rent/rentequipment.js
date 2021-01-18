import request from '@/utils/request_yusen'

// 获取所有订单
export function getAllRentlist(params) {
  return request({
    url: '/equipment/rent/',
    method: 'get',
    params
  })
}
// 器材租借
export function rentEquipment(params) {
  return request({
    url: '/equipment/rent/',
    method: 'post',
    params
  })
}
// 查询订单
export function queryRentOrder(params) {
  return request({
    url: '/equipment/rent/' + params['id'],
    method: 'get',
    params
  })
}
// 删除订单记录
export function deleteRentOrder(id) {
  return request({
    url: '/equipment/rent/' + id,
    method: 'delete'
  })
}
// 归还器材
export function returnEquipment(id) {
  return request({
    url: '/equipment/rent/' + id + '/return',
    method: 'post'
  })
}
// 根据用户Id获取列表
export function getrentOrderById(params) {
  return request({
    url: '/equipment/rent/searchByUserId',
    method: 'get',
    params
  })
}
// 查询订单
export function getrentOrderByCardNo(params) {
  return request({
    url: '/equipment/rent/searchByCardNo',
    method: 'get',
    params
  })
}
