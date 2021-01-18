<template>
  <div class="app-container">
    <el-table v-loading="listLoading" :data="list" border>
      <el-table-column label="序号" width="60" align="center">
        <template slot-scope="scope">{{ scope.$index + 1 }}</template>
      </el-table-column>
      <el-table-column prop="fieldName" label="场地名称" />
      <el-table-column prop="fieldLocale" label="场地地点" />
      <el-table-column label="场地收费说明" width="130">
        <template slot-scope="scope">{{ scope.row.rentCharge }} / 小时</template>
      </el-table-column>
      <el-table-column label="预约时间" width="320">
        <template slot-scope="scope">{{ scope.row.orderBegin }} - {{ scope.row.orderEnd }}</template>
      </el-table-column>
      <el-table-column prop="orderTime" label="预约申请时间" width="160" />
      <el-table-column prop="status" label="预约状态" align="center" width="120" />
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
  </div>
</template>

<script>
import { selectPersonOrder } from '@/api/field/order'
import { mapGetters } from 'vuex'
export default {
  name: 'Index',
  data() {
    return {
      list: [],
      listLoading: true,
      operatingIndex: 0,
      pager: {
        total: 0,
        currentPage: 1,
        pageSize: 0
      }
    }
  },
  computed: {
    ...mapGetters([
      'userId'
    ])
  },
  created() {
    this.getData({ userId: this.userId })
  },
  methods: {
    getData(params) {
      this.listLoading = true
      selectPersonOrder(params).then(response => {
        if (response.status === 200) {
          this.list = response.data
          this.pager.total = response.data.length
          this.pager.pageSize = 10
        } else {
          this.$message.error('获取场地数据出错：' + response.msg)
        }
        this.listLoading = false
      })
    },
    // 页码改变
    pageChange() {
      this.getData({ userId: this.userId })
    }
  }
}
</script>

<style scoped lang="scss">

</style>
