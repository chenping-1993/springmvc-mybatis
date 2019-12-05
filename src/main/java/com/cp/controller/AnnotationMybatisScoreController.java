package com.cp.controller;

import com.cp.entity.response.ScoreResponse;
import com.cp.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 通过注解查询操作数据
 * @Author: chenping
 * @Date: 2019-12-05
 */
@RestController
@RequestMapping("/annotation")
public class AnnotationMybatisScoreController {

    @Autowired
    ScoreMapper scoreMapper;

    @RequestMapping("/list")
    public List<ScoreResponse> getList() {
        return scoreMapper.list(null);
    }
}
