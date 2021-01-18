import request from '@/utils/request_wende'

/**
 * 查询场地
 * @param params filedName pageNum*
 */
export function selectPlaceByFileName(params) {
  return request({
    url: '/place/selectPlaceByFileName',
    method: 'post',
    params
  })
}

/**
 * 添加场地
 */
export function insertPlace(params) {
  return request({
    url: '/place/insertPlace',
    method: 'post',
    params
  })
}

/**
 * 修改场地
 */
export function updatePlace(params) {
  return request({
    url: '/place/updatePlace',
    method: 'post',
    params
  })
}

/**
 * 删除场地
 */
export function deletePlace(params) {
  return request({
    url: '/place/deletePlace',
    method: 'post',
    params
  })
}

/**
 * 设置场地的特殊使用
 */
export function setPlaceEspecialUser(params) {
  return request({
    url: '/fieldRentInfo/setPlaceEspecialUser',
    method: 'post',
    params
  })
}

/**
 * 查询场地使用情况  条件输入
 * @param params fileName type pageNum*
 */
export function getAllFieldRentInfo(params) {
  return request({
    url: '/fieldRentInfo/getAllFieldRentInfo',
    method: 'post',
    params
  })
}

/**
 * 根据id删除使用详情
 * @param params id*
 */
export function deleteFieldRentInfo(params) {
  return request({
    url: '/fieldRentInfo/deleteFieldRentInfo',
    method: 'post',
    params
  })
}

