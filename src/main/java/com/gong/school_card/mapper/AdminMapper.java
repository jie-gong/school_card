package com.gong.school_card.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gong.school_card.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.mapper.AdminMapper
 * @Date: 2022年09月13日 20:06
 * @Description:
 */
@Mapper
@Repository//持久层框架
public interface AdminMapper extends BaseMapper<Admin> {
}
