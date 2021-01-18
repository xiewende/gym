import request_wende from '@/utils/request_wende'
import request_yusen from '@/utils/request_yusen'

/**
 * 查询赛事项目
 * @param params  pageNum*
 */
export function seleEventItemsAll(params) {
  return request_wende({
    url: '/eventItems/seleEventItemsAll',
    method: 'post',
    params
  })
}

/**
 * 根据比赛名称和状态条件查询赛事
 * @param params competionname status pageNum*
 */
export function selectAllByCompetitionName(params) {
  return request_wende({
    url: '/competition/selectAllByCompetitionName',
    method: 'post',
    params
  })
}

/**
 * 创建赛事
 */
export function creatCompetition(params) {
  return request_wende({
    url: '/competition/creatCompetition',
    method: 'post',
    params
  })
}

/**
 * 更新赛事
 */
export function upsateCompetition(params) {
  return request_wende({
    url: '/competition/upsateCompetition',
    method: 'post',
    params
  })
}

/**
 * 取消赛事
 */
export function quxiaoConpetition(params) {
  return request_wende({
    url: '/competition/quxiaoConpetition',
    method: 'post',
    params
  })
}

/**
 * 删除赛事
 */
export function deleteConpetition(params) {
  return request_wende({
    url: '/competition/deleteConpetition',
    method: 'post',
    params
  })
}

/**
 * 获得所有的器材，当damageStatus=1（器材完好）且rentStatus=1（未租用）为可租用
 * @params page
 */
export function getAllEquipment(params) {
  return request_yusen({
    url: '/equipment/',
    method: 'get',
    params
  })
}

/**
 * 新建器材租用记录，只有器材没有损坏、未出租的情况下可以提交
 * @params equipmentId* studentId*
 */
export function rentEquipment(params) {
  return request_yusen({
    url: '/equipment/rent/',
    method: 'post',
    params
  })
}
