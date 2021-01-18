import request from '@/utils/request_wende'

/**
 * 查询全部裁判
 * @param params pageNum*
 */
export function selectAllJudge(params) {
  return request({
    url: '/judge/selectAllJudge',
    method: 'post',
    params
  })
}

/**
 * 添加裁判
 */
export function insertJudge(params, data) {
  return request({
    url: '/judge/insertJudge',
    method: 'post',
    headers: { 'Content-Type': 'multipart/form-data' },
    params,
    data
  })
}

/**
 * 修改裁判
 */
export function updateJudge(params, data) {
  return request({
    url: '/judge/updateJudge',
    method: 'post',
    headers: { 'Content-Type': 'multipart/form-data' },
    params,
    data
  })
}

/**
 * 删除裁判
 */
export function deleteJudge(params) {
  return request({
    url: '/judge/deleteJudge',
    method: 'post',
    params
  })
}

