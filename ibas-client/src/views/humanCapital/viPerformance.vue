<template>
  <div class="container">
    <el-row>
      <el-card shadow="always">
        <el-form>
          <el-row>
            <el-form-item :label="$t('humanCapital.viPerformance.object')">
              <el-input
                style="width: auto"
                v-model="conditionValue"
                disabled
                :placeholder="$t('humanCapital.viPerformance.object')"
                clearable>
              </el-input>
              &nbsp;&nbsp;
              <el-tooltip effect="dark" :content="$t('humanCapital.viPerformance.search')">
                <el-button type="primary" icon="el-icon-more" @click="editorVisible=true"></el-button>
              </el-tooltip>
            </el-form-item>
          </el-row>
          <el-row>
            <el-form-item :label="$t('humanCapital.viPerformance.month')">
              <el-date-picker
                v-model="startDate"
                format="yyyy / MM"
                :placeholder="$t('common.startDate')"
                :picker-options="pickerStartOptions">
              </el-date-picker>
              <span class="to">-</span>
              <el-date-picker
                v-model="endDate"
                format="yyyy / MM"
                :placeholder="$t('common.endDate')"
                :picker-options="pickerEndOptions">
              </el-date-picker>
            </el-form-item>
          </el-row>
          <el-row>
            <el-form-item :label="$t('humanCapital.viPerformance.content')">
              <el-select style="width: 140px" v-model="project" :placeholder="$t('humanCapital.viPerformance.project')">
                <el-option
                  v-for="item in filters.projects"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
              <el-select style="width: 120px" v-model="category" :placeholder="$t('humanCapital.viPerformance.category')">
                <el-option
                  v-for="item in filters.categorys"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
              <el-select style="width: 120px" v-model="objRank" :placeholder="$t('humanCapital.viPerformance.objRank')">
                <el-option
                  v-for="item in filters.ranks"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
              <el-select style="width: 120px" v-model="period" :placeholder="$t('humanCapital.viPerformance.period')">
                <el-option
                  v-for="item in filters.periods"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
            </el-form-item>
          </el-row>
          <el-button type="primary"  @click="checkPreview">{{ $t('humanCapital.viPerformance.preview') }}</el-button>
        </el-form>
      </el-card>
    </el-row>
    <el-dialog
      :title="$t('humanCapital.viPerformance.checkObj')"
      width="55%"
      :visible.sync="editorVisible">
      <el-form
        label-position="top"
        size="mini"
        ref="searchInfo"
        :model="searchInfo"
        label-width="150"
        :inline="true">
        <el-row>
          <el-form-item :label="$t('humanCapital.viPerformance.branch')">
            <el-select v-model="searchInfo.branch" :placeholder="$t('humanCapital.viPerformance.branch')" multiple collapse-tags>
              <el-option
                v-for="item in filters.branchs"
                :key="item"
                :label="item"
                :value="item">
              </el-option>
            </el-select>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item :label="$t('humanCapital.viPerformance.name')">
            <el-input
              v-model="searchInfo.name"
              :placeholder="$t('common.pleaseInput')">
            </el-input>
          </el-form-item>
          <el-form-item :label="$t('humanCapital.viPerformance.number')">
            <el-input
              type="number"
              v-model="searchInfo.number"
              :placeholder="$t('common.pleaseInput')">
            </el-input>
          </el-form-item>
          <el-form-item :label="$t('humanCapital.viPerformance.idCard')">
            <el-input
              v-model="searchInfo.idCard"
              :placeholder="$t('common.pleaseInput')">
            </el-input>
          </el-form-item>
        </el-row>
      </el-form>
      <el-row>
        <el-button type="primary"  @click="getObjList">{{ $t('humanCapital.viPerformance.searchNow') }}</el-button>
      </el-row>
      <el-row></el-row>
      <el-row>
        <el-card shadow="always">
          <el-row>
            <el-table
              v-loading="listLoading"
              :key="tableKey"
              :data="list"
              :header-cell-style="{ backgroundColor: '#f8f8f9', color: '#2c2c2c' }"
              max-height="350"
              highlight-current-row
              @current-change="handleCurrentChange"
              fit
              border>
              <el-table-column prop="number" width="140px" :label="$t('humanCapital.viPerformance.number')" ></el-table-column>
              <el-table-column prop="name" width="140px" :label="$t('humanCapital.viPerformance.name')" ></el-table-column>
              <el-table-column prop="idCard" width="140px" :label="$t('humanCapital.viPerformance.idCard')" ></el-table-column>
              <el-table-column prop="branch" width="140px" :label="$t('humanCapital.viPerformance.branch')" ></el-table-column>
              <el-table-column prop="dept" width="140px" :label="$t('humanCapital.viPerformance.dept')" ></el-table-column>
              <el-table-column prop="rank" width="140px" :label="$t('humanCapital.viPerformance.rank')" ></el-table-column>
            </el-table>
          </el-row>
        </el-card>
      </el-row>
    </el-dialog>
  </div>
</template>

<script>
  import performanceWarnDialog from '@/mock/templates/performanceWarnDialog'
  import { fetchPeopleList } from '@/api/humanCapital/performanceWarnDialog'
  import { fetchViPerformance } from '@/api/humanCapital/viPerformance'
  export default {
    name: 'viPerformance',
    methods: {
      insurerNameQuerySearch (queryString?: string, callback: Function): void {
        console.log(queryString)
        // callback(queryString ? this.filters.insurers.filter(item => item.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0) : this.filters.insurers)
      },
      getObjList (): void {
        this.listLoading = true
        fetchPeopleList(this.searchInfo).then(data => {
          this.list = data
          // eslint-disable-next-line
        }, error => {
          this.list = performanceWarnDialog.data
        })
        setTimeout(() => {
          this.listLoading = false
        }, 200)
      },
      checkPreview (): void {
        let searchJson = {
          name: this.name,
          number: this.number,
          idCard: this.idCard,
          baseMonth: this.baseMonth,
          project: this.project,
          category: this.category,
          objRank: this.objRank,
          period: this.period
        }
        fetchViPerformance(searchJson).then(data => {
          //
        })
      },
      handleCurrentChange (val) {
        this.name = val.name
        this.number = val.number
        this.idCard = val.idCard
        this.conditionValue = val.name + '\t' + val.number
        this.listLoading = false
        this.editorVisible = false
      }
    },
    data () {
      return {
        name: '',
        number: '',
        idCard: '',
        editorVisible: false,
        conditionValue: '',
        startDate: '',
        endDate: '',
        project: '',
        category: '',
        objRank: '',
        period: '',
        branch: '',
        listLoading: false,
        tableKey: 0,
        list: [],
        filters: {
          ranks: ['内勤人员', '总经理', '部门经理', '培训管理', '出单员', '结算管理员'],
          projects: ['-FYC值'],
          categorys: ['个人', '团队'],
          periods: ['月', '季', '半年', '年', '自始'],
          branchs: ['安徽分公司', '恩施分公司', '福建分公司', '广西分公司', '海南分公司', '河南分公司',
                    '黑龙江分公司', '湖南分公司', '江苏分公司', '荆门分公司', '辽宁分公司', '宁夏分公司',
                    '陕西分公司', '十堰分公司', '天津分公司', '武昌分公司', '武汉分公司', '仙桃分公司',
                    '咸宁分公司', '襄阳分公司', '新疆分公司', '宜昌分公司', '云南分公司', '总部']
        },
        pickerStartOptions: {
          disabledDate: (time) => {
            if (this.endDate !== '') {
              return time.getTime() > Date.now() || time.getTime() > this.endDate
            } else {
              return time.getTime() > Date.now()
            }
          }
        },
        pickerEndOptions: {
          disabledDate: (time) => {
            return time.getTime() < this.startDate || time.getTime() > Date.now()
          }
        },
        searchInfo: {
          name: '',
          number: '',
          idCard: '',
          branch: ''
        }
      }
    }
  }
</script>
