package com.gong.school_card.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gong.school_card.pojo.Testlogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.mapper.TestMapper
 * @Date: 2022年09月20日 16:50
 * @Description:
 */
@Repository
@Mapper
public interface TestLoginMapper extends BaseMapper<Testlogin> {
}
