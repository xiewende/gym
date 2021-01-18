<template>
  <div class="app-container">
    <div>
      <el-input v-model="searchKeyword" placeholder="请输入场地名称进行搜索" class="el-append-input">
        <el-button slot="append" icon="el-icon-search" @click="getDataByFieldName" />
      </el-input>
    </div>
    <el-table v-loading="listLoading" :data="list" border style="width: 100%;margin-top: 20px">
      <el-table-column label="序号" width="60" align="center">
        <template slot-scope="scope">{{ scope.$index + 1 }}</template>
      </el-table-column>
      <el-table-column prop="fieldName" label="场地名称" />
      <el-table-column prop="fieldLocale" label="场地地点" />
      <el-table-column prop="fieldTime" label="场地开放时间" />
      <el-table-column label="场地收费说明">
        <template slot-scope="scope">{{ scope.row.fieldCharge }} / 小时</template>
      </el-table-column>
      <el-table-column prop="fieldManagername" label="管理员姓名" />
      <el-table-column prop="fieldManegertel" label="管理员电话" />
      <el-table-column label="操作" width="80" fixed="right" align="center">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="openOrderDialog(scope.$index)">预约</el-button>
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
      <el-dialog title="预约场地" :visible.sync="orderDialogVisible" destroy-on-close top="10vh" width="622px">
        <v-order-field ref="orderField" @cancel="orderDialogVisible=false" />
      </el-dialog>
    </div>
  </div>
</template>

<script>
import { selectPlaceByFileName } from '@/api/field/main'

export default {
  name: 'Index',
  components: {
    'v-order-field': () => import('@/views/field/student/reserve/order')
  },
  data() {
    return {
      list: [],
      listLoading: true,
      searchKeyword: '',
      operatingIndex: 0,
      orderDialogVisible: false,
      pager: {
        total: 0,
        currentPage: 1,
        pageSize: 0
      }
    }
  },
  created() {
    this.getData({ pageNum: 1 })
  },
  methods: {
    openOrderDialog(index) {
      this.operatingIndex = index
      this.orderDialogVisible = true
      setTimeout(() => {
        this.$refs.orderField.setFormData(this.list[index])
      }, 200)
    },
    // 获取场地数据
    getData(param) {
      this.listLoading = true
      selectPlaceByFileName(param).then(response => {
        if (response.status === 200) {
          this.list = response.data.list
          this.pager.total = response.data.total
          this.pager.pageSize = response.data.pageSize
        } else {
          this.$message.error('获取场地数据出错：' + response.msg)
        }
        this.listLoading = false
      })
    },
    // 搜索
    getDataByFieldName() {
      this.getData({ fieldName: this.searchKeyword, pageNum: 1 })
    },
    // 页码改变
    pageChange() {
      this.getData({ pageNum: this.pager.currentPage })
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
