package com.gong.school_card.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gong.school_card.pojo.Resul;
import com.gong.school_card.pojo.vo.ResulAndStudent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.mapper.ResulMapper
 * @Date: 2022年09月21日 15:32
 * @Description:
 */
@Mapper
@Repository//持久化框架
public interface ResulMapper extends BaseMapper<Resul> {
    List<ResulAndStudent>selectResultInput();
}
