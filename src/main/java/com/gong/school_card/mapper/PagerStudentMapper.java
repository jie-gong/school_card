package com.gong.school_card.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gong.school_card.pojo.PagerStudent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.mapper.PagerStudentMapper
 * @Date: 2022年09月20日 10:44
 * @Description:
 */
@Mapper
@Repository
public interface PagerStudentMapper extends BaseMapper<PagerStudent> {
}
