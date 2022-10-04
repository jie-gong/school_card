package com.gong.school_card.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gong.school_card.pojo.Announcement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Property;
import org.springframework.stereotype.Repository;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.mapper.AnnouncementMapper
 * @Date: 2022年09月19日 10:33
 * @Description:
 */
@Mapper
@Repository
public interface AnnouncementMapper extends BaseMapper<Announcement> {
}
