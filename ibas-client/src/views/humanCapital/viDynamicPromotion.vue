<template>
  <div class="container">
    <el-row>
      <el-card shadow="always">
        <el-form>
          <el-row>
            <el-form-item :label="$t('humanCapital.viDynamicPromotion.status')">
              <el-select v-model="status" :placeholder="$t('common.pleaseSelect')">
                <el-option
                  v-for="item in filters.statuses"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
            </el-form-item>
          </el-row>
          <el-row>
            <el-form-item :label="$t('humanCapital.viDynamicPromotion.month')">
              <el-date-picker
                v-model="startMonth"
                type="month"
                format="yyyy / MM"
                :placeholder="$t('common.startDate')"
                :picker-options="pickerStartOptions">
              </el-date-picker>
              <span class="to">-</span>
              <el-date-picker
                v-model="endMonth"
                type="month"
                format="yyyy / MM"
                :placeholder="$t('common.endDate')"
                :picker-options="pickerEndOptions">
              </el-date-picker>
            </el-form-item>
          </el-row>
          <el-row>
            <el-form-item :label="$t('humanCapital.viDynamicPromotion.checkRank')">
              <el-select v-model="branch" :placeholder="$t('humanCapital.viDynamicPromotion.branch')">
                <el-option
                  v-for="item in filters.branchs"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
              <el-select v-model="dept" :placeholder="$t('humanCapital.viDynamicPromotion.dept')">
                <el-option
                  v-for="item in filters.depts"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
              <el-select v-model="rank" :placeholder="$t('humanCapital.viDynamicPromotion.rank')" multiple collapse-tags>
                <el-option
                  v-for="item in filters.ranks"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
            </el-form-item>
          </el-row>
          <el-row>
            <el-form-item :label="$t('humanCapital.viDynamicPromotion.checkStandard')">
              <el-select style="width: 140px" v-model="project" :placeholder="$t('humanCapital.viDynamicPromotion.project')">
                <el-option
                  v-for="item in filters.projects"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
              <el-select style="width: 120px" v-model="category" :placeholder="$t('humanCapital.viDynamicPromotion.category')">
                <el-option
                  v-for="item in filters.categorys"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
              <el-select style="width: 120px" v-model="objRank" :placeholder="$t('humanCapital.viDynamicPromotion.objRank')">
                <el-option
                  v-for="item in filters.ranks"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
              <el-select style="width: 120px" v-model="period" :placeholder="$t('humanCapital.viDynamicPromotion.period')">
                <el-option
                  v-for="item in filters.periods"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
              <el-select style="width: 120px" v-model="condition" :placeholder="$t('humanCapital.viDynamicPromotion.condition')">
                <el-option
                  v-for="item in filters.conditions"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
              <el-input
                style="width: auto"
                :placeholder="$t('humanCapital.viDynamicPromotion.conditionValue')"
                clearable>
              </el-input>
            </el-form-item>
          </el-row>
          <el-button type="primary"  @click="getList">{{ $t('common.search') }}</el-button>
        </el-form>
      </el-card>
    </el-row>
    <el-row>
      <el-card shadow="always">
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
            <el-table-column prop="state" width="140px" :label="$t('humanCapital.viDynamicPromotion.state')" ></el-table-column>
            <el-table-column prop="num" width="140px" :label="$t('humanCapital.viDynamicPromotion.num')" ></el-table-column>
            <el-table-column prop="name" width="140px" :label="$t('humanCapital.viDynamicPromotion.name')" ></el-table-column>
            <el-table-column prop="work" width="140px" :label="$t('humanCapital.viDynamicPromotion.work')" ></el-table-column>
            <el-table-column prop="startDate" width="140px" :label="$t('humanCapital.viDynamicPromotion.startDate')" ></el-table-column>
            <el-table-column prop="endDate" width="140px" :label="$t('humanCapital.viDynamicPromotion.endDate')" ></el-table-column>
            <el-table-column prop="tableBranch" width="140px" :label="$t('humanCapital.viDynamicPromotion.tableBranch')" ></el-table-column>
            <el-table-column prop="tableDept" width="140px" :label="$t('humanCapital.viDynamicPromotion.tableDept')" ></el-table-column>
            <el-table-column prop="tableMonth" width="140px" :label="$t('humanCapital.viDynamicPromotion.tableMonth')" ></el-table-column>
            <el-table-column prop="change" width="140px" :label="$t('humanCapital.viDynamicPromotion.change')" ></el-table-column>
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
  import { Pagination } from '@/components'
  import viDynamicPromotion from '@/mock/templates/viDynamicPromotion'
  import { fetchList } from '@/api/humanCapital/viDynamicPromotion'

  export default {
    name: 'viDynamicPromotion',
    components: { Pagination },
    methods: {
      getList (): void {
        let searchJson = {
          status: this.status,
          baseMonth: this.baseMonth,
          branch: this.branch,
          dept: this.dept,
          rank: this.rank,
          project: this.project,
          category: this.category,
          objRank: this.objRank,
          period: this.period,
          condition: this.condition,
          conditionValue: this.conditionValue
        }
        fetchList(searchJson).then(data => {
          this.list = data
          this.total = data.length
          setTimeout(() => {
            this.listLoading = false
          }, 200)
          // eslint-disable-next-line
        }, error => {
          this.list = viDynamicPromotion.data
          this.total = viDynamicPromotion.data.length
          setTimeout(() => {
            this.listLoading = false
          }, 200)
        })
      }
    },
    created () {
      this.getList()
    },
    data () {
      return {
        total: 0,
        tableKey: 0,
        list: [],
        listLoading: true,
        listQuery: {
          page: 1,
          limit: 10,
          importance: undefined,
          title: undefined,
          type: undefined
        },
        status: '晋升(已达晋升标准)',
        startMonth: '',
        endMonth: '',
        branch: '',
        dept: '',
        rank: '',
        project: '',
        category: '',
        objRank: '',
        period: '',
        condition: '',
        filters: {
          statuses: ['晋升(已达晋升标准)', '考核(未达考核标准人员)'],
          branchs: ['安徽分公司', '恩施分公司', '福建分公司', '广西分公司', '海南分公司', '河南分公司',
                    '黑龙江分公司', '湖南分公司', '江苏分公司', '荆门分公司', '辽宁分公司', '宁夏分公司',
                    '陕西分公司', '十堰分公司', '天津分公司', '武昌分公司', '武汉分公司', '仙桃分公司',
                    '咸宁分公司', '襄阳分公司', '新疆分公司', '宜昌分公司', '云南分公司', '总部'],
          depts: ['运营部', '营销部'],
          ranks: ['内勤人员', '总经理', '部门经理', '培训管理', '车险出单员', '结算管理员'],
          projects: ['-FYC值'],
          categorys: ['个人', '团队'],
          periods: ['月', '季', '半年', '年', '自始'],
          conditions: ['>', '>=', '<', '<=', '=', '!=']
        },
        pickerStartOptions: {
          disabledDate: (time) => {
            if (this.endMonth !== '') {
              return time.getTime() > Date.now() || time.getTime() > this.endMonth
            } else {
              return time.getTime() > Date.now()
            }
          }
        },
        pickerEndOptions: {
          disabledDate: (time) => {
            return time.getTime() < this.startMonth || time.getTime() > Date.now()
          }
        }
      }
    }
  }
</script>
