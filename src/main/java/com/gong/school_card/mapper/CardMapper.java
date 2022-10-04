package com.gong.school_card.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gong.school_card.pojo.Card;
import com.gong.school_card.pojo.vo.CardAndStudent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.mapper.CardMapper
 * @Date: 2022年09月11日 09:42
 * @Description:
 */
@Mapper//这个注解表示了 这是一个mybatis的mapper类
@Repository//持久层框架
public interface CardMapper extends BaseMapper<Card> {
    Card ShowOne(int studentid);
    int addStudent(Card card);

    List<CardAndStudent>selectBalance(int studentid);
}
