<template>
  <div class="app-container">
    <div class="clearfix">
      <el-select v-model="searchOptionValue" placeholder="请选择场地使用类型" style="margin-right: 10px">
        <el-option label="全部" value="" />
        <el-option label="普通申请" value="普通申请" />
        <el-option label="上课用地" value="上课用地" />
        <el-option label="校队用地" value="校队用地" />
      </el-select>
      <el-input v-model="searchKeyword" placeholder="请输入场地名称进行搜索" class="el-append-input">
        <el-button slot="append" icon="el-icon-search" @click="search" />
      </el-input>
      <el-button type="primary" icon="el-icon-document" style="float: right" :disabled="exportExcelDisable" @click="exportExcel">生成报表</el-button>
    </div>
    <el-table id="table" v-loading="listLoading" :data="list" border style="width: 100%;margin-top: 20px">
      <el-table-column label="序号" width="60" align="center">
        <template slot-scope="scope">{{ scope.$index + 1 }}</template>
      </el-table-column>
      <el-table-column prop="fieldName" label="场地名称" />
      <el-table-column prop="fieldLocale" label="场地地点" />
      <el-table-column prop="fieldTime" label="场地开放时间" />
      <el-table-column label="场地使用时间" width="350px">
        <template slot-scope="scope">{{ scope.row.rentBegin }} - {{ scope.row.rentEnd }}</template>
      </el-table-column>
      <el-table-column label="场地收费说明">
        <template slot-scope="scope">{{ scope.row.rentCharge }} / 小时</template>
      </el-table-column>
      <el-table-column prop="fieldStatus" label="场地状态" align="center" />
      <el-table-column prop="rentTypeString" label="场地使用类型" align="center" />
      <el-table-column label="操作" width="120" fixed="right" align="center">
        <template slot-scope="scope">
          <el-tooltip effect="dark" content="场地使用情况" placement="top">
            <el-button type="primary" size="mini" icon="el-icon-tickets" circle @click="openUsageDialog(scope.$index)" />
          </el-tooltip>
          <el-tooltip effect="dark" content="删除该场地使用" placement="top">
            <el-button type="danger" size="mini" icon="el-icon-delete" circle @click="openDelDialog(scope.$index)" />
          </el-tooltip>
        </template>
      </el-table-column>
    </el-table>
    <div style="text-align: center;margin: 20px 0">
      <el-pagination
        background
        layout="prev, pager, next"
        :page-size.sync="pager.pageSize"
        :current-page.sync="pager.currentPage"
        :total="pager.total"
        @current-change="pageChange"
      />
    </div>
    <div>
      <el-dialog title="提示" :visible.sync="delDialogVisible" width="400px">
        <div style="text-align: center">
          <span style="font-size: 28px">
            <i class="el-icon-warning" style="color: red;margin-right: 7px" />
            您要删除该场地使用吗?
          </span>
          <el-button-group style="margin-top: 40px">
            <el-button type="primary" style="width: 130px" @click="delFieldUsage">确定</el-button>
            <el-button type="info" style="width: 130px" @click="delDialogVisible=false">取消</el-button>
          </el-button-group>
        </div>
      </el-dialog>
      <el-dialog title="场地使用情况" :visible.sync="usageDialogVisible" width="550px">
        <v-usage-detail ref="usageDetail" />
      </el-dialog>
    </div>
  </div>
</template>

<script>
import { getAllFieldRentInfo, deleteFieldRentInfo } from '@/api/field/main'
import { createExcelFromTable } from '@/utils/common'
export default {
  name: 'Index',
  components: {
    'v-usage-detail': () => import('@/views/field/admin/usage/usage-detail')
  },
  data() {
    return {
      list: [],
      listLoading: true,
      delDialogVisible: false,
      usageDialogVisible: false,
      searchOptionValue: '',
      searchKeyword: '',
      operatingIndex: 0,
      pager: {
        total: 0,
        currentPage: 1,
        pageSize: 0
      }
    }
  },
  computed: {
    exportExcelDisable() {
      return this.listLoading || this.list.length === 0
    }
  },
  created() {
    this.getData({ pageNum: 1 })
  },
  methods: {
    openUsageDialog(index) {
      this.operatingIndex = index
      this.usageDialogVisible = true
      setTimeout(() => {
        this.$refs.usageDetail.setFormData(this.list[index])
      }, 200)
    },
    openDelDialog(index) {
      this.operatingIndex = index
      this.delDialogVisible = true
    },
    getData(params) {
      this.listLoading = true
      getAllFieldRentInfo(params).then(response => {
        this.list = response.data.list
        this.pager.total = response.data.total
        this.pager.pageSize = response.data.pageSize
        this.listLoading = false
      })
    },
    delFieldUsage() {
      this.delDialogVisible = false
      deleteFieldRentInfo({ id: this.list[this.operatingIndex].id }).then(response => {
        if (response.status === 200) {
          this.$message.success('场地使用删除成功！')
          this.list.splice(this.operatingIndex, 1)
        } else {
          this.$message.error('场地使用删除失败：' + response.msg)
        }
      })
    },
    // 搜索
    search() {
      let type = { }
      if (this.searchOptionValue !== '') {
        type = { type: this.searchOptionValue }
      }
      this.getData({ fileName: this.searchKeyword, ...type, pageNum: 1 })
    },
    // 页码改变
    pageChange() {
      this.getData({ pageNum: this.pager.currentPage })
    },
    // 生成报表
    exportExcel() {
      createExcelFromTable('#table', 'FiledRentDetail')
    }
  }
}
</script>

<style lang="scss">
  .el-append-input {
    width: 300px;

    .el-input-group__append {
      background-color: #409EFF;
      border-color: #409EFF;
      color: white;
      font-size: 18px;
    }
  }
</style>
