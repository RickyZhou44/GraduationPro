import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '../views/layout/Layout'

Vue.use(VueRouter)

/** note: Submenu only appear when children.length>=1
 *  detail see  https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 **/

/**
 * hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu, whatever its child routes length
 *                                if not set alwaysShow, only more than one route under the children
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noredirect           if `redirect:noredirect` will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    will control the page roles (you can set multiple roles)
    title: 'title'               the name show in submenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar
    noCache: true                if true, the page will no be cached(default is false)
    breadcrumb: false            if false, the item will hidden in breadcrumb(default is true)
  }
 **/

export const constantRouterMap = [
  {
    path: '',
    component: Layout,
    redirect: '/home',
    children: [
      {
        path: 'home',
        component: () => import('../views/home'),
        name: 'Home',
        meta: { title: 'home', icon: 'home', noCache: true }
      }
    ]
  },
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path*',
        component: () => import('../views/redirect')
      }
    ]
  },
  {
    path: '/start',
    component: () => import('../views/start'),
    hidden: true
  },
  {
    path: '/auth-redirect',
    component: () => import('@/views/start/authredirect'),
    hidden: true
  }
]

export default new VueRouter({
  mode: 'history',
  routes: constantRouterMap
})

export const asyncRouterMap = [
  {
    path: '/insurance-policy',
    component: Layout,
    redirect: '/insurance-policy/acceptance',
    name: 'InsurancePolicy',
    alwaysShow: true,
    meta: { title: 'insurancePolicy', icon: 'clipboard' },
    children: [
      {
        path: 'acceptance',
        name: 'IPAcceptance',
        component: () => import('@/views/insurancePolicy/acceptance'),
        meta: { title: 'ipAcceptance' }
      },
      {
        path: 'new-contract',
        name: 'IPNewContract',
        component: () => import('@/views/insurancePolicy/newContract'),
        meta: { title: 'ipNewContract' }
      },
      {
        path: 'payment',
        name: 'Payment',
        component: () => import('@/views/insurancePolicy/payment'),
        meta: { title: 'payment' }
      },
      {
        path: 'automation',
        name: 'Automation',
        component: () => import('@/views/insurancePolicy/automation'),
        meta: { title: 'automation' }
      },
      {
        path: 'import',
        name: 'IPImport',
        component: () => import('@/views/insurancePolicy/import'),
        meta: { title: 'ipImport' }
      }
    ]
  },
  {
    path: '/vehicleInsurance',
    component: Layout,
    redirect: '/vehicleInsurance/acceptance',
    name: 'VehicleInsurance',
    alwaysShow: true,
    meta: { title: 'vehicleInsurance', icon: 'truck' },
    children: [
      {
        path: 'acceptance',
        name: 'VIAcceptance',
        component: () => import('@/views/vehicleInsurance/acceptance'),
        meta: { title: 'viAcceptance' }
      },
      {
        path: 'new-contract',
        name: 'VINewContract',
        component: () => import('@/views/vehicleInsurance/newContract'),
        meta: { title: 'viNewContract' }
      },
      {
        path: 'import',
        name: 'VIImport',
        component: () => import('@/views/vehicleInsurance/import'),
        meta: { title: 'viImport' }
      }
    ]
  },
  {
    path: '/human-capital',
    component: Layout,
    redirect: '/human-capital/person-rank',
    name: 'HumanCapital',
    alwaysShow: true,
    meta: { title: 'humanCapital', icon: 'users' },
    children: [
      {
        path: 'person-rank',
        name: 'PersonRank',
        component: () => import('@/views/humanCapital/personRank'),
        meta: { title: 'person_rank' }
      },
      {
        path: 're-performance-data',
        name: 'RePerformanceData',
        component: () => import('@/views/humanCapital/rePerformanceData'),
        meta: { title: 're_performanceData' }
      },
      {
        path: 'dynamic-promotion',
        name: 'DynamicPromotion',
        component: () => import('@/views/humanCapital/dynamicPromotion'),
        meta: { title: 'dynamicPromotion' }
      },
      {
        path: 'performance-warn',
        name: 'PerformanceWarn',
        component: () => import('@/views/humanCapital/performanceWarn'),
        meta: { title: 'performanceWarn' }
      },
      // {
      //   path: 'vi-dynamic-promotion',
      //   name: 'VIDynamicPromotion',
      //   component: () => import('@/views/humanCapital/viDynamicPromotion'),
      //   meta: { title: 'viDynamicPromotion' }
      // },
      // {
      //   path: 'vi-performance',
      //   name: 'VIPerformance',
      //   component: () => import('@/views/humanCapital/viPerformance'),
      //   meta: { title: 'viPerformance' }
      // },
      {
        path: 'personnel-organization',
        name: 'PersonnelOrganization',
        component: () => import('@/views/humanCapital/personnelOrganization'),
        meta: { title: 'personnelOrganization' }
      }
    ]
  },
  {
    path: '/claim-settlement',
    component: Layout,
    redirect: '/claim-settlement/index',
    meta: { title: 'claimSettlement', icon: 'pocket' },
    children: [
      {
        path: 'index',
        name: 'ClaimSettlement',
        component: () => import('@/views/claimSettlement/index'),
        meta: { title: 'claimSettlement' }
      }
    ]
  },
  {
    path: '/customer',
    component: Layout,
    redirect: '/customer/index',
    meta: { title: 'customer', icon: 'user' },
    children: [
      {
        path: 'index',
        name: 'Customer',
        component: () => import('@/views/customer/index'),
        meta: { title: 'customer' }
      }
    ]
  },
  {
    path: '/settlement',
    component: Layout,
    redirect: '/settlement/performance-reorganization',
    name: 'Settlement',
    alwaysShow: true,
    meta: { title: 'settlement', icon: 'check-square' },
    children: [
      {
        path: 'performance-reorganization',
        name: 'PerformanceReorganization',
        component: () => import('@/views/settlement/performanceReorganization'),
        meta: { title: 'performance_reorganization' }
      },
      {
        path: 'persistency-reorganization',
        name: 'PersistencyReorganization',
        component: () => import('@/views/settlement/persistencyReorganization'),
        meta: { title: 'persistency_reorganization' }
      },
      {
        path: '/settlement/external-settlement',
        redirect: '/settlement/external-settlement/inspection-by-transaction',
        name: 'ExternalSettlement',
        alwaysShow: true,
        meta: { title: 'external_settlement' },
        children: [
          {
            path: 'inspection-by-transaction',
            name: 'InspectionByTransaction',
            component: () => import('@/views/settlement/externalSettlement/inspectionByTransaction'),
            meta: { title: 'inspection_by_transaction' }
          },
          {
            path: 'batch-inspection',
            name: 'BatchInspection',
            component: () => import('@/views/settlement/externalSettlement/batchInspection'),
            meta: { title: 'batch_inspection' }
          },
          {
            path: 'VI-inspection-by-transaction',
            name: 'VIInspectionByTransaction',
            component: () => import('@/views/settlement/externalSettlement/VIInspectionByTransaction'),
            meta: { title: 'VI_inspection_by_transaction' }
          },
          {
            path: 'VI-batch-inspection',
            name: 'VIBatchInspection',
            component: () => import('@/views/settlement/externalSettlement/VIBatchInspection'),
            meta: { title: 'VI_batch_inspection' }
          },
          {
            path: 'IP-inspection-before-settlement',
            name: 'IPInspectionBeforeSettlement',
            component: () => import('@/views/settlement/externalSettlement/IPInspectionBeforeSettlement'),
            meta: { title: 'IP_inspection_before_settlement' }
          }
        ]
      },
      {
        path: '/settlement/internal-settlement',
        redirect: '/settlement/internal-settlement/automatic-standard-settlement',
        name: 'InternalSettlement',
        component: () => import('@/views/settlement/internalSettlement/home'),
        alwaysShow: true,
        meta: { title: 'internal_settlement' },
        children: [
          {
            path: 'automatic-standard-settlement',
            name: 'AutomaticStandardSettlement',
            component: () => import('@/views/settlement/internalSettlement/automaticStandardSettlement'),
            meta: { title: 'automatic_standard_settlement' }
          },
          {
            path: 'settlement-document',
            name: 'SettlementDocument',
            component: () => import('@/views/settlement/internalSettlement/settlementDocument'),
            meta: { title: 'settlement_document' }
          },
          {
            path: 'VI-standard-settlement',
            name: 'VIStandardSettlement',
            component: () => import('@/views/settlement/internalSettlement/VIStandardSettlement'),
            meta: { title: 'VI_standard_settlement' }
          }
        ]
      }
    ]
  },
  {
    path: '/authority',
    component: Layout,
    redirect: '/authority/system-account-management',
    name: 'Authority',
    alwaysShow: true,
    meta: { title: 'authority', icon: 'lock' },
    children: [
      {
        path: 'system-account-management',
        name: 'SystemAccountManagement',
        component: () => import('@/views/authority/systemAccountManagement'),
        meta: { title: 'system_account_management' }
      },
      {
        path: 'group-authority-management',
        name: 'GroupAuthorityManagement',
        component: () => import('@/views/authority/groupAuthorityManagement'),
        meta: { title: 'group_authority_management' }
      },
      {
        path: 'authority-model-define',
        name: 'AuthorityModelDefine',
        component: () => import('@/views/authority/authorityModelDefine'),
        meta: { title: 'authority_model_define' }
      },
      {
        path: 'change-passport',
        name: 'ChangePassport',
        component: () => import('@/views/authority/changePassport'),
        meta: { title: 'change_passport' }
      }
    ]
  },
  {
    path: '/rate',
    component: Layout,
    redirect: '/rate/insurance-form-rate-management',
    name: 'Rate',
    alwaysShow: true,
    meta: { title: 'rate', icon: 'percent' },
    children: [
      {
        path: 'insurance-form-rate-management',
        name: 'InsuranceFormRateManagement',
        component: () => import('@/views/rate/insuranceFormRateManagement'),
        meta: { title: 'insurance_form_rate_management' }
      },
      {
        path: 'underwriting-rule-management',
        name: 'UnderwritingRuleManagement',
        component: () => import('@/views/rate/underwritingRuleManagement'),
        meta: { title: 'underwriting_rule_management' }
      },
      {
        path: 'VI-rate-management',
        name: 'VIRateManagement',
        component: () => import('@/views/rate/VIRateManagement'),
        meta: { title: 'VI_rate_management' }
      },
      {
        path: 'settlement-rate-param',
        name: 'SettlementRateParam',
        component: () => import('@/views/rate/settlementRateParam'),
        meta: { title: 'settlement_rate_param' }
      },
      {
        path: 'insurance-form-rate-query-and-import',
        name: 'InsuranceFormRateQueryAndImport',
        component: () => import('@/views/rate/insuranceFormRateQueryAndImport'),
        meta: { title: 'insurance_form_rate_query_and_import' }
      }
    ]
  },
  {
    path: '/Continuation-rate',
    component: Layout,
    redirect: '/Continuation-rate/continuity-rate-query-statistics',
    name: 'Continuation Rate',
    alwaysShow: true,
    meta: { title: 'continuation_rate', icon: 'percent' },
    children: [
      {
        path: 'continuity-rate-query-statistics',
        name: 'CR query statistics',
        component: () => import('@/views/rate/insuranceFormRateManagement'),
        meta: { title: 'continuity_rate_query_statistics' }
      },
      {
        path: 'insurance-com-query-statistics',
        name: 'Insurance com CR query statistics',
        component: () => import('@/views/rate/insuranceFormRateManagement'),
        meta: { title: 'insurance_com_query_statistics' }
      }
    ]
  }
]
