package com.cp.service.provider;

import com.cp.entity.Score;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

/**
 * @Author: chenping
 * @Date: 2019-12-05
 */
public class ScoreProvider {

    public String getListSql(Score score) {
        SQL sql = new SQL();

        StringBuffer selectColumns = new StringBuffer();
        selectColumns.append(" subject,score,stu_id as stuId");

        sql.SELECT(selectColumns.toString());
        sql.FROM(" score ");
        if (!StringUtils.isEmpty(score.getSubject())) {
            sql.WHERE(" subject = #{subject}");
        }
        if (null != score.getScore()) {
            sql.WHERE(" score = #{score}");
        }
        return sql.toString();
    }
}
