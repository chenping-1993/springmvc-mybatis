package com.cp.mapper;

import com.cp.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: chenping
 * @Date: 2019/6/12
 */
@Repository
public interface StudentMapper {
    List<Student> selectListWithList(@Param("list") List<Student> student);

    void xmlBatchInsert(@Param("list") List<Student> list);

    List<Student> selectListWithLike(Student student);

    List<Student> selectListWithTime(Student student);
}
