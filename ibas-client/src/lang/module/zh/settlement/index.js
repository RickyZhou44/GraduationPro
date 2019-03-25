import { performanceReorganization } from './performance_reorganization'
import { persistencyReorganization } from './persistency_reorganization'
import { automaticStandardSettlement } from './internalSettlement/automatic_standard_settlement'
import { VIStandardSettlement } from './internalSettlement/VI_standard_settlement'
import { settlementDocument } from './internalSettlement/settlement_document'

export const settlement = {
  performanceReorganization,
  persistencyReorganization,
  automaticStandardSettlement,
  VIStandardSettlement,
  settlementDocument
}
