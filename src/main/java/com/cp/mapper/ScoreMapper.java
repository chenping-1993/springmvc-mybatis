package com.cp.mapper;

import com.cp.entity.Score;
import com.cp.entity.SysRole;
import com.cp.entity.response.ScoreResponse;
import com.cp.service.provider.ScoreProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @description
 * @author: chenping
 * @create: 2019-10-31
 **/
public interface ScoreMapper {

    @SelectProvider(type = ScoreProvider.class, method = "getListSql")
    public List<ScoreResponse> list(Score score);
}
