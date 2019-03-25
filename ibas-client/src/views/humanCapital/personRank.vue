<template>
  <div class="container">
    <el-row>
      <el-card shadow="always">
        <el-row :gutter="20">
          <el-col :span="22">
            <div class="search-bar">
              <el-input
                :placeholder="$t('common.conditionalSearch')"
                v-model="search.content"
                class="input-with-select"
                clearable>
                <el-select v-model="search.select" slot="prepend" style="width: 135px">
                  <el-option :label="$t('humanCapital.personRank.status')" value="status"></el-option>
                  <el-option :label="$t('humanCapital.personRank.staffNo')" value="staffNo"></el-option>
                  <el-option :label="$t('humanCapital.personRank.staffName')" value="staffName"></el-option>
                  <el-option :label="$t('humanCapital.personRank.branch')" value="branch"></el-option>
                  <el-option :label="$t('humanCapital.personRank.dept')" value="dept"></el-option>
                  <el-option :label="$t('humanCapital.personRank.tel')" value="tel"></el-option>
                  <el-option :label="$t('humanCapital.personRank.rank')" value="rank"></el-option>
                </el-select>
                <el-button slot="append" icon="el-icon-search"></el-button>
              </el-input>
            </div>
          </el-col>
          <el-col :span="2">
            <el-tooltip effect="dark" :content="$t('common.addNew')" placement="top">
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
              prop="status"
              width="120px"
              align="center"
              :label="$t('humanCapital.personRank.status')"
              :filters="filters.status"
              :filter-method="statusFilters"
              filter-placement="bottom-end"
            >
            </el-table-column>
            <el-table-column
              prop="staffNo"
              width="120px"
              align="center"
              :label="$t('humanCapital.personRank.staffNo')">
            </el-table-column>
            <el-table-column prop="staffName" width="120px" :label="$t('humanCapital.personRank.staffName')" ></el-table-column>
            <el-table-column prop="staffSex" width="120px" :label="$t('humanCapital.personRank.staffSex')" ></el-table-column>
            <el-table-column prop="branch" width="120px" :label="$t('humanCapital.personRank.branch')" ></el-table-column>
            <el-table-column prop="dept" width="120px" :label="$t('humanCapital.personRank.dept')" ></el-table-column>
            <el-table-column prop="rank" width="120px" :label="$t('humanCapital.personRank.rank')" ></el-table-column>
            <el-table-column  width="120px" align="center">
              <!--eslint-disable-next-line-->
              <template slot="header" slot-scope="scope">
                <el-popover
                  placement="bottom"
                  trigger="click"
                  transition="el-zoom-in-top">
                  <el-date-picker
                    size="mini"
                    v-model="filters.joinDateRange"
                    type="daterange"
                    align="left"
                    :range-separator="$t('common.rangeSeparator')"
                    :start-placeholder="$t('common.startDate')"
                    :end-placeholder="$t('common.endDate')">
                  </el-date-picker>
                  <span style="padding-left: 12px">
                    <el-button class="popover-button"  type="text" size="mini" :disabled="filters.joinDateRange">{{ $t('common.filter') }}</el-button>
                    <el-button class="popover-button"  type="text" size="mini">{{ $t('common.reset') }}</el-button>
                  </span>

                  <span slot="reference">
                    {{ $t('humanCapital.personRank.joinDate') }}
                    <span class="el-table__column-filter-trigger">
                      <i class="el-icon-arrow-down"></i>
                    </span>
                  </span>
                </el-popover>
              </template>
              <template slot-scope="scope">{{ scope.row.joinDate }}</template>
            </el-table-column>
            <el-table-column   width="120px" align="center">
              <!--eslint-disable-next-line-->
              <template slot="header" slot-scope="scope">
                <el-popover
                  placement="bottom"
                  trigger="click"
                  transition="el-zoom-in-top">
                  <el-date-picker
                    size="mini"
                    v-model="filters.validDateRange"
                    type="daterange"
                    align="left"
                    :range-separator="$t('common.rangeSeparator')"
                    :start-placeholder="$t('common.startDate')"
                    :end-placeholder="$t('common.endDate')">
                  </el-date-picker>
                  <span style="padding-left: 12px">
                    <el-button class="popover-button"  type="text" size="mini" :disabled="filters.validDateRange">{{ $t('common.filter') }}</el-button>
                    <el-button class="popover-button"  type="text" size="mini">{{ $t('common.reset') }}</el-button>
                  </span>

                  <span slot="reference">
                    {{ $t('humanCapital.personRank.joinDate') }}
                    <span class="el-table__column-filter-trigger">
                      <i class="el-icon-arrow-down"></i>
                    </span>
                  </span>
                </el-popover>
              </template>
              <template slot-scope="scope">{{ scope.row.validDate }}</template>
            </el-table-column>
            <el-table-column    width="120px" align="center">
              <!--eslint-disable-next-line-->
              <template slot="header" slot-scope="scope">
                <el-popover
                  placement="bottom"
                  trigger="click"
                  transition="el-zoom-in-top">
                  <el-date-picker
                    size="mini"
                    v-model="filters.birthdayRange"
                    type="daterange"
                    align="left"
                    :range-separator="$t('common.rangeSeparator')"
                    :start-placeholder="$t('common.startDate')"
                    :end-placeholder="$t('common.endDate')">
                  </el-date-picker>
                  <span style="padding-left: 12px">
                    <el-button class="popover-button"  type="text" size="mini" :disabled="filters.birthdayRange">{{ $t('common.filter') }}</el-button>
                    <el-button class="popover-button"  type="text" size="mini">{{ $t('common.reset') }}</el-button>
                  </span>

                  <span slot="reference">
                    {{ $t('humanCapital.personRank.joinDate') }}
                    <span class="el-table__column-filter-trigger">
                      <i class="el-icon-arrow-down"></i>
                    </span>
                  </span>
                </el-popover>
              </template>
              <template slot-scope="scope">{{ scope.row.birthday }}</template>
            </el-table-column>
            <el-table-column prop="tel" width="120px" :label="$t('humanCapital.personRank.tel')" ></el-table-column>
            <el-table-column
              fixed="right"
              :label="$t('common.operation')"
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
  import personRank from '@/mock/templates/personRank'
  export default {
    name: 'personRank',
    components: { Pagination, PopoverTip },
    created () {
      this.getList()
    },
    methods: {
      getList (): void {
        this.listLoading = false
        this.list = personRank.data
        this.total = personRank.data.length
        console.log(personRank)
      },
      rowEdit (row: Object): void {

      },
      rowDel (row: Object): void {
        this.delTipVisible = false
        this.list.splice(row.$index, 1)
        // ...api
      },
      statusFilters (value: string, row: Object): boolean {
        return row.status === value
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
          status: ['在职', '离职', '回收站'].map(x => { return { text: x, value: x } }),
          joinDateRange: '',
          validDateRange: '',
          birthdayRange: ''
        }
      }
    }
  }
</script>
