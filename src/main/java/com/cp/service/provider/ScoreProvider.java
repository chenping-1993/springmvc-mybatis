package com.cp.service.provider;

import com.cp.entity.Score;

/**
 * @Author: chenping
 * @Date: 2019-12-05
 */
public class ScoreProvider {

    public String getListSql(Score score) {
        StringBuffer sqlList = new StringBuffer();
        sqlList.append(" select subject,score,stu_id as stuId  from score where 1= 1 ");
//        sqlList.append(" ioh.audit_time as auditing_time,ioh.update_time as update_time,ioh.pay_time as pay_time, ");
//        sqlList.append(" ioh.plate_no, ioh.order_status, ioh.plate_color, ioh.card_type, ioh.tw_order_no, ");
        return sqlList.toString();
    }
}
