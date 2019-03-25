<template>
  <div class="container">
    <el-row>
      <el-card shadow="always">
        <el-form>
          <el-row>
            <el-form-item :label="$t('humanCapital.performanceWarn.object')">
              <el-input
                style="width: auto"
                v-model="conditionValue"
                disabled
                :placeholder="$t('humanCapital.performanceWarn.object')"
                clearable>
              </el-input>
              &nbsp;&nbsp;
              <el-tooltip effect="dark" :content="$t('humanCapital.performanceWarn.search')">
                <el-button type="primary" icon="el-icon-more" @click="editorVisible=true"></el-button>
              </el-tooltip>
            </el-form-item>
          </el-row>
          <el-row>
            <el-form-item :label="$t('humanCapital.performanceWarn.month')">
              <el-date-picker
                v-model="baseMonth"
                type="month"
                format="yyyy / MM"
                :placeholder="$t('common.startDate')"
                :picker-options="pickerStartOptions">
              </el-date-picker>
            </el-form-item>
          </el-row>
          <el-row>
            <el-form-item :label="$t('humanCapital.performanceWarn.content')">
              <el-select style="width: 140px" v-model="project" :placeholder="$t('humanCapital.performanceWarn.project')">
                <el-option
                  v-for="item in filters.projects"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
              <el-select style="width: 120px" v-model="category" :placeholder="$t('humanCapital.performanceWarn.category')">
                <el-option
                  v-for="item in filters.categorys"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
              <el-select style="width: 120px" v-model="objRank" :placeholder="$t('humanCapital.performanceWarn.objRank')">
                <el-option
                  v-for="item in filters.ranks"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
              <el-select style="width: 120px" v-model="period" :placeholder="$t('humanCapital.performanceWarn.period')">
                <el-option
                  v-for="item in filters.periods"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
            </el-form-item>
          </el-row>
          <el-button type="primary"  @click="checkPreview">{{ $t('humanCapital.performanceWarn.preview') }}</el-button>
        </el-form>
      </el-card>
    </el-row>
    <el-dialog
      :title="$t('humanCapital.performanceWarn.checkObj')"
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
          <el-form-item :label="$t('humanCapital.performanceWarn.branch')">
            <el-select v-model="searchInfo.branch" :placeholder="$t('humanCapital.performanceWarn.branch')" multiple collapse-tags>
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
          <el-form-item :label="$t('humanCapital.performanceWarn.name')">
            <el-input
              v-model="searchInfo.name"
              :placeholder="$t('common.pleaseInput')">
            </el-input>
          </el-form-item>
          <el-form-item :label="$t('humanCapital.performanceWarn.number')">
            <el-input
              type="number"
              v-model="searchInfo.number"
              :placeholder="$t('common.pleaseInput')">
            </el-input>
          </el-form-item>
          <el-form-item :label="$t('humanCapital.performanceWarn.idCard')">
            <el-input
              v-model="searchInfo.idCard"
              :placeholder="$t('common.pleaseInput')">
            </el-input>
          </el-form-item>
        </el-row>
      </el-form>
      <el-row>
        <el-button type="primary"  @click="getObjList">{{ $t('humanCapital.performanceWarn.searchNow') }}</el-button>
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
              <el-table-column prop="number" width="140px" :label="$t('humanCapital.performanceWarn.number')" ></el-table-column>
              <el-table-column prop="name" width="140px" :label="$t('humanCapital.performanceWarn.name')" ></el-table-column>
              <el-table-column prop="idCard" width="140px" :label="$t('humanCapital.performanceWarn.idCard')" ></el-table-column>
              <el-table-column prop="branch" width="140px" :label="$t('humanCapital.performanceWarn.branch')" ></el-table-column>
              <el-table-column prop="dept" width="140px" :label="$t('humanCapital.performanceWarn.dept')" ></el-table-column>
              <el-table-column prop="rank" width="140px" :label="$t('humanCapital.performanceWarn.rank')" ></el-table-column>
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
  import { fetchPerformanceWarn } from '@/api/humanCapital/performanceWarn'
  export default {
    name: 'performanceWarn',
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
        fetchPerformanceWarn(searchJson).then(data => {
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
        baseMonth: '',
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
            return time.getTime() > Date.now()
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
