import FileSaver from 'file-saver'
import XLSX from 'xlsx'

/**
 * 生成报表（Excel表格）
 * @param tableSelector 表格css选择器
 * @param fileName 文件名
 * @returns {any}
 */
export function createExcelFromTable(tableSelector, fileName) {
  const wb = XLSX.utils.table_to_book(document.querySelector(tableSelector))
  const wbout = XLSX.write(wb, {
    bookType: 'xlsx',
    bookSST: true,
    type: 'array'
  })
  try {
    FileSaver.saveAs(
      // Blob 对象表示一个不可变、原始数据的类文件对象。
      // Blob 表示的不一定是JavaScript原生格式的数据。
      // File 接口基于Blob，继承了 blob 的功能并将其扩展使其支持用户系统上的文件。
      // 返回一个新创建的 Blob 对象，其内容由参数中给定的数组串联组成。
      new Blob([wbout], { type: 'application/octet-stream' }),
      // 设置导出文件名称
      fileName + '.xlsx'
    )
  } catch (e) {
    if (typeof console !== 'undefined') console.log(e, wbout)
  }
  return wbout
}

