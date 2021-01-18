
import request from '@/utils/request_wende'

/**
 * 查询全部公告,管理员
 * @param params pageNum*
 */
export function listAllAnnouncement(params) {
  return request({
    url: '/announcement/listAllAnnouncement',
    method: 'post',
    params
  })
}

/**
 * 添加公告,管理员
 * @param params announcementAuthor* announcementTitle* announcementConten*
 */
export function insertAnnouncement(params) {
  return request({
    url: '/announcement/insertAnnouncement',
    method: 'post',
    params
  })
}

/**
 * 删除公告,管理员
 * @param params id*
 */
export function deleteAnnouncement(params) {
  return request({
    url: '/announcement/deleteAnnouncement',
    method: 'post',
    params
  })
}

/**
 * 学生端查询展示最近的一个公告
 */
export function selectByRencent() {
  return request({
    url: '/announcement/selectByRencent',
    method: 'post'
  })
}

