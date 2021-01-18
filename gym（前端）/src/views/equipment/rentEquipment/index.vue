<template>
  <div class="app-container">
    <!-- 搜索与添加区域 -->
    <div class="clearfix">
      <div style="float: left;">
        <el-input v-model="searchKeyword" placeholder="请输入器材组名" clearable class="el-append-input">
          <el-button slot="append" icon="el-icon-search" @click="search" />
        </el-input>
      </div>
    </div>
    <!-- 器材组列表 -->
    <el-table v-loading="listLoading" :data="list" border stripe style="margin-top: 20px">
      <el-table-column type="index" align="center" />
      <!--<el-table-column label="id" prop="group.id" />-->
      <el-table-column label="器材组名" prop="group.name" />
      <el-table-column label="数量" prop="total" />
      <el-table-column label="可租借数量" prop="available" />
      <el-table-column label="操作" width="100px" align="center">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="showRentDialog(scope.$index)">租借</el-button>
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
      <el-dialog title="租借器材" :visible.sync="rentDialogVisible" destroy-on-close width="40vw">
        <v-detail ref="detail" rent-succeed="rentSucceed" @cancel="rentDialogVisible=false" />
      </el-dialog>
    </div>
  </div>

</template>

<script>
import { getAllEquipmentGroup, queryEquipmentGroup } from '@/api/equipment/equipment-group'

export default {
  name: 'EquipmentGrouplist',
  components: {
    'v-detail': () => import('@/views/equipment/rentEquipment/detail')
  },
  data() {
    return {
      searchKeyword: '',
      rentDialogVisible: false,
      list: [],
      listLoading: true,
      pager: {
        total: 0,
        currentPage: 1,
        pageSize: 0
      }
    }
  },
  created() {
    this.getData({
      page: 1
    })
  },
  methods: {
    showRentDialog(index) {
      this.operatingIndex = index
      this.rentDialogVisible = true
      setTimeout(() => {
        this.$refs.detail.setId(this.list[index].group.id)
      }, 200)
    },
    getData(params) {
      this.listLoading = true
      if (this.searchKeyword) {
        queryEquipmentGroup(params).then(response => {
          if (response.status === 200) {
            this.list = response.data
          } else {
            this.$message.error('获取用户数据出错：' + response.msg)
          }
          this.listLoading = false
        })
      } else {
        getAllEquipmentGroup(params).then(response => {
          if (response.status === 200) {
            this.list = response.data.currentList
            this.pager.total = response.data.count
            this.pager.pageSize = response.data.pageSize
          } else {
            this.$message.error('获取器材组数据出错：' + response.msg)
          }
          this.listLoading = false
        })
      }
    },
    // 搜索分组
    search() {
      this.getData({
        name: this.searchKeyword
      })
    },
    pageChange() {
      this.getData({
        page: this.pager.currentPage
      })
    },
    rentSucceed() {
      this.pageChange()
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

  .dashboard {
    &-container {
      margin: 30px;
    }

    &-text {
      font-size: 30px;
      line-height: 46px;
    }
  }
</style>
