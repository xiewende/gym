<template>
  <div class="app-container">
    <div>
      <el-input v-model="searchKeyword" placeholder="请输入场地名称进行搜索" class="el-append-input">
        <el-button slot="append" icon="el-icon-search" @click="getByFieldName" />
      </el-input>
    </div>
    <el-table v-loading="listLoading" :data="list" border style="width: 100%;margin-top: 20px">
      <el-table-column label="序号" width="60" align="center">
        <template slot-scope="scope">{{ scope.$index + 1 }}</template>
      </el-table-column>
      <el-table-column prop="fieldName" label="场地名称" />
      <el-table-column prop="fieldLocale" label="场地地点" />
      <el-table-column prop="userName" label="预约人" />
      <el-table-column prop="userTel" label="预约电话" />
      <el-table-column prop="orderTime" label="预约时间" />
      <el-table-column label="预约时间段" width="320">
        <template slot-scope="scope">{{ scope.row.orderBegin }} - {{ scope.row.orderEnd }}</template>
      </el-table-column>
      <el-table-column prop="rentCharge" label="付费金额" width="100" align="center" />
      <el-table-column label="操作" width="160" fixed="right" align="center">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="agreeFieldOrder(scope.$index)">同意</el-button>
          <el-button type="danger" size="mini" @click="disagreeFieldOrder(scope.$index)">驳回</el-button>
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
  </div>
</template>

<script>
import { listAllOrderField, agreeFieldOrder, disagreeFieldOrder } from '@/api/field/order'

export default {
  name: 'Index',
  data() {
    return {
      list: [],
      listLoading: true,
      searchKeyword: '',
      operatingIndex: 0,
      pager: {
        total: 0,
        currentPage: 1,
        pageSize: 0
      }
    }
  },
  created() {
    this.getData()
  },
  methods: {
    getData(params) {
      this.listLoading = true
      listAllOrderField(params).then(response => {
        this.list = response.data
        this.listLoading = false
      })
    },
    // 搜索
    getByFieldName() {
      this.getData({ fieldName: this.searchKeyword })
    },
    // 同意预约
    agreeFieldOrder(index) {
      this.operatingIndex = index
      agreeFieldOrder({ id: this.list[index].id }).then(response => {
        if (response.status === 200) {
          this.$message.success('已同意改场地预约！')
          this.operateSucceed()
        } else {
          this.$message.error('同意改场地预约出错：' + response.msg)
        }
      })
    },
    // 驳回预约
    disagreeFieldOrder(index) {
      this.operatingIndex = index
      disagreeFieldOrder({ id: this.list[index].id }).then(response => {
        if (response.status === 200) {
          this.$message.success('已驳回改场地预约！')
          this.operateSucceed()
        } else {
          this.$message.error('驳回改场地预约出错：' + response.msg)
        }
      })
    },
    // 同意/驳回预约,成功后的操作
    operateSucceed() {
      if (this.list.length > 0) {
        this.list.splice(this.operatingIndex, 1)
      } else {
        this.getData()
      }
    },
    // 页码改变
    pageChange() {
      this.getData()
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
