import request from '@/utils/request_wende'

/**
 * 查询场地预约情况 管理员
 * @param params filedName
 */
export function listAllOrderField(params) {
  return request({
    url: '/fieldOrder/listAllOrderField',
    method: 'post',
    params
  })
}

/**
 * 普通用户查询自己的预约情况
 * @param params userId
 */
export function selectPersonOrder(params) {
  return request({
    url: '/fieldOrder/selectPersonOeder',
    method: 'post',
    params
  })
}

/**
 * 同意预约 管理员
 * @param params filedName
 */
export function agreeFieldOrder(params) {
  return request({
    url: '/fieldOrder/agreefileOrder',
    method: 'post',
    params
  })
}

/**
 * 同意预约 管理员
 * @param params filedName
 */
export function disagreeFieldOrder(params) {
  return request({
    url: '/fieldOrder/disagreefileOrder',
    method: 'post',
    params
  })
}

/**
 * 预约场地
 * @param params filedName
 */
export function orderField(params) {
  return request({
    url: '/fieldOrder/fileOrder',
    method: 'post',
    params
  })
}

