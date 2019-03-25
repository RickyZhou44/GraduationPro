<template>
  <div class="container">
    <el-row>
      <el-card shadow="always">
        <el-row :gutter="20">
          <el-col :span="22">
            <div class="search-bar">
              <el-input :placeholder="$t('rate.rateManagement.conditionalSearch')" v-model="search.content" class="input-with-select" clearable>
                <el-select v-model="search.select" slot="prepend" style="width: 135px">
                  <el-option :label="$t('rate.rateManagement.insuranceCom')" value="insuranceCom"></el-option>
                  <el-option :label="$t('rate.rateManagement.insuranceCode')" value="insuranceCode"></el-option>
                  <el-option :label="$t('rate.rateManagement.insuranceName')" value="insuranceName"></el-option>
                  <el-option :label="$t('rate.rateManagement.insuranceSname')" value="insuranceSname"></el-option>
                  <el-option :label="$t('rate.rateManagement.mainContract')" value="mainContract"></el-option>
                  <el-option :label="$t('rate.rateManagement.insuranceType')" value="insuranceType"></el-option>
                </el-select>
                <el-button slot="append" icon="el-icon-search"></el-button>
              </el-input>
            </div>
          </el-col>
          <el-col :span="2">
            <el-tooltip effect="dark" :content="$t('rate.rateManagement.addNew')" placement="top">
              <el-button type="primary" icon="el-icon-plus" circle></el-button>
            </el-tooltip>
          </el-col>
        </el-row>
        <el-row>
          <el-table
            v-loading="listLoading"
            :key="tableKey"
            :data="list"
            :header-cell-style="{ backgroundColor: '#f8f8f9', color: '#2c2c2c' }"
            max-height="750"
            fit
            border>
            <el-table-column type="index" width="50" align="center"></el-table-column>
            <el-table-column
              prop="insuranceCom"
              width="120px"
              :label="$t('rate.rateManagement.insuranceCom')"
              align="center"
              :filters="filters.coms"
              :filter-method="comFilters"
              filter-placement="bottom-end">
            </el-table-column>
            <el-table-column prop="insuranceCode" width="120px" :label="$t('rate.rateManagement.insuranceCode')" ></el-table-column>
            <el-table-column prop="insuranceName" width="120px" :label="$t('rate.rateManagement.insuranceName')" ></el-table-column>
            <el-table-column prop="insuranceSname" width="120px" :label="$t('rate.rateManagement.insuranceSname')" ></el-table-column>
            <el-table-column
              prop="mainContract"
              width="120px"
              :label="$t('rate.rateManagement.mainContract')"
              :filters="filters.contracts"
              :filter-method="contractFilters"
              filter-placement="bottom-end"
            >
            </el-table-column>
            <el-table-column
              prop="insuranceType"
              width="120px"
              :label="$t('rate.rateManagement.insuranceType')"
              :filters="filters.types"
              :filter-method="typeFilters"
              filter-placement="bottom-end">
            </el-table-column>
            <el-table-column prop="startDate" width="120px" :label="$t('rate.rateManagement.startDate')" ></el-table-column>
            <el-table-column prop="endDate" width="120px" :label="$t('rate.rateManagement.endDate')" ></el-table-column>
            <el-table-column
              fixed="right"
              :label="$t('rate.rateManagement.operation')"
              align="center"
              width="100">
              <template slot-scope="scope">
                <el-button @click="rowEdit(scope.row)" type="text" size="mini">{{ $t('common.edit') }}</el-button>
                <popover-tip
                  :message="$t('common.delConfirm')"
                  :confirm-text="$t('common.confirm')"
                  :cancel-text="$t('common.cancel')"
                  @popover-tip-confirm="rowDel(scope.row)">
                  <el-button type="text" size="mini" style="color: #f56c6c;margin-left: 5px;">{{ $t('common.delete') }}</el-button>
                </popover-tip>
              </template>
            </el-table-column>
          </el-table>
        </el-row>
        <el-row>
          <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />
        </el-row>
      </el-card>
    </el-row>
  </div>
</template>

<script>
  import { Pagination, PopoverTip } from '@/components'

  export default {
    name: 'insuranceFormRateManagement',
    components: { Pagination, PopoverTip },
    created () {
      this.getList()
      this.getComs()
      this.getContracts()
    },
    methods: {
      getList (): void {
        this.listLoading = false
      },
      getComs (): void {
        let data = ['光大永明(寿)']
        this.filters.coms = data.map(x => { return { text: x, value: x } })
      },
      getContracts (): void {
        let data = ['主约', '附约']
        this.filters.contracts = data.map(x => { return { text: x, value: x } })
      },
      comFilters (value: string, row: Object): boolean {
        return row.insuranceCom === value
      },
      contractFilters (value: string, row: Object): boolean {
        return row.mainContract === value
      },
      typeFilters (value: string, row: Object): boolean {
        return row.insuranceType === value
      }
    },
    data () {
      return {
        tableKey: 0,
        list: [],
        total: 0,
        listLoading: true,
        listQuery: {
          page: 1,
          limit: 10,
          importance: undefined,
          title: undefined,
          type: undefined
        },
        search: {
          content: '',
          select: 'insuranceCom'
        },
        filters: {
          coms: [],
          contracts: [],
          types: []
        }
      }
    }
  }
</script>

<style lang="scss">
  .container {
    padding: 15px;

    .search-bar {
      padding: 0 0 20px;
    }
  }
  .input-with-select .el-input-group__prepend {
    background-color: #fff;
  }

  .popover-button {
    background: transparent;
    border: none;
    color: #606266;
    cursor: pointer;
    font-size: 13px;
    padding: 0 3px;

    &:hover{
      color: $--color-primary;
    }
  }
</style>
