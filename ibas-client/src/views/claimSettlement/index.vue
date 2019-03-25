<template>
  <div class="container">
    <el-row>
      <el-card shadow="always">
        <el-row :gutter="20">
          <el-col :span="22">
            <div class="search-bar">
              <el-input
                :placeholder="$t('claimSettlement.settlement.conditionalSearch')"
                v-model="search.content"
                class="input-with-select"
                clearable>
                <el-select v-model="search.select" slot="prepend" style="width: 135px">
                  <el-option :label="$t('claimSettlement.settlement.settlementName')" value="settlementName"></el-option>
                  <el-option :label="$t('claimSettlement.settlement.reportNum')" value="reportNum"></el-option>
                  <el-option :label="$t('claimSettlement.settlement.surveyLocation')" value="surveyLocation"></el-option>
                  <el-option :label="$t('claimSettlement.settlement.surveyor')" value="surveyor"></el-option>
                  <el-option :label="$t('claimSettlement.settlement.isFinished')" value="isFinished"></el-option>
                  <!--<el-option :label="$t('customer.relationship.clientName')" value="agent"></el-option>-->
                  <!--<el-option :label="$t('customer.relationship.clientName')" value="employee"></el-option>-->
                </el-select>
                <el-button slot="append" icon="el-icon-search"></el-button>
              </el-input>
            </div>
          </el-col>
          <el-col :span="2">
            <el-tooltip effect="dark" :content="$t('claimSettlement.settlement.addNew')" placement="top">
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
            <el-table-column prop="settlementName" width="140px" :label="$t('claimSettlement.settlement.settlementName')" ></el-table-column>
            <el-table-column width="120px" align="center">
              <!--eslint-disable-next-line-->
              <template slot="header" slot-scope="scope">
                <el-popover
                  placement="bottom"
                  trigger="click"
                  transition="el-zoom-in-top">
                  <el-date-picker
                    size="mini"
                    v-model="filters.reportTimeRange"
                    type="daterange"
                    align="left"
                    :range-separator="$t('common.rangeSeparator')"
                    :start-placeholder="$t('common.startDate')"
                    :end-placeholder="$t('common.endDate')">
                  </el-date-picker>
                  <span style="padding-left: 12px">
                    <el-button class="popover-button"  type="text" size="mini" :disabled="filters.reportTimeRange">{{ $t('common.filter') }}</el-button>
                    <el-button class="popover-button"  type="text" size="mini">{{ $t('common.reset') }}</el-button>
                  </span>

                  <span slot="reference">
                    {{ $t('claimSettlement.settlement.reportTime') }}
                    <span class="el-table__column-filter-trigger">
                      <i class="el-icon-arrow-down"></i>
                    </span>
                  </span>
                </el-popover>
              </template>
              <template slot-scope="scope">{{ scope.row.reportTime }}</template>
            </el-table-column>
            <el-table-column
              prop="reportNum"
              width="140px"
              align="center"
              :label="$t('claimSettlement.settlement.reportNum')">
            </el-table-column>
            <el-table-column prop="surveyLocation" width="120px" :label="$t('claimSettlement.settlement.surveyLocation')" ></el-table-column>
            <el-table-column prop="surveyor" width="120px" :label="$t('claimSettlement.settlement.surveyor')" ></el-table-column>
            <el-table-column prop="process" width="120px" :label="$t('claimSettlement.settlement.process')" ></el-table-column>
            <el-table-column prop="isFinished" width="120px" :label="$t('claimSettlement.settlement.isFinished')" ></el-table-column>
            <el-table-column
              prop="taskType"
              width="140px"
              align="center"
              :label="$t('claimSettlement.settlement.taskType')"
              :filters="filters.taskType"
              :filter-method="taskTypeFilters"
              filter-placement="bottom-end">
            </el-table-column>
            <el-table-column
              fixed="right"
              :label="$t('claimSettlement.settlement.operation')"
              align="center"
              width="120">
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
  import claimSettlement from '@/mock/templates/claimSettlement'

  export default {
    name: 'cliamSettlement',
    components: { Pagination, PopoverTip },
    created () {
      this.getList()
    },
    methods: {
      getList (): void {
        this.listLoading = false
        this.list = claimSettlement.data
        this.total = claimSettlement.data.length
        console.log(claimSettlement)
      },
      rowEdit (row: Object): void {

      },
      rowDel (row: Object): void {
        this.delTipVisible = false
        this.list.splice(row.$index, 1)
        // ...api
      },
      taskTypeFilters (value: string, row: Object): boolean {
        return row.taskType === value
      }
    },
    data () {
      return {
        list: [],
        tableKey: 0,
        listLoading: true,
        total: 0,
        listQuery: {
          page: 1,
          limit: 10,
          importance: undefined,
          title: undefined,
          type: undefined
        },
        search: {
          content: '',
          select: ''
        },
        filters: {
          taskType: ['查勘定损', '查勘', '单定损'].map(x => { return { text: x, value: x } }),
          reportTimeRange: ''
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
