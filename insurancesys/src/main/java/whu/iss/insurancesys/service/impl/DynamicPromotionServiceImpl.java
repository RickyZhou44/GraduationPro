package whu.iss.insurancesys.service.impl;

import org.springframework.stereotype.Service;
import whu.iss.insurancesys.dao.DynamicPromotionDao;
import whu.iss.insurancesys.entity.DynamicPromotionQueryResult;
import whu.iss.insurancesys.service.DynamicPromotionService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DynamicPromotionServiceImpl implements DynamicPromotionService {

    @Resource
    private DynamicPromotionDao dynamicPromotionDao;

    @Override
    public List<DynamicPromotionQueryResult> query(String status, Date baseMonth, String branch, String dept, String[] rank, String project, String insuranceKind, String category, String period, String condition, Double conditionValue) {
        if (insuranceKind.equals("寿险")) {
            return dynamicPromotionDao.queryLifeInsurance(status, baseMonth, branch, dept, rank, project, category, period, condition, conditionValue);
        } else if (insuranceKind.equals("车险")) {
            return dynamicPromotionDao.queryCarInsurance(status, baseMonth, branch, dept, rank, project, category, period, condition, conditionValue);
        } else if (insuranceKind.equals("全部")) {
            List<DynamicPromotionQueryResult> list1 = dynamicPromotionDao.queryLifeInsurance(status, baseMonth, branch, dept, rank, project, category, period, condition, conditionValue);
            List<DynamicPromotionQueryResult> list2 = dynamicPromotionDao.queryCarInsurance(status, baseMonth, branch, dept, rank, project, category, period, condition, conditionValue);
            list1.addAll(list2);
            return list1;
        } else {
            return null;
        }
    }
}
