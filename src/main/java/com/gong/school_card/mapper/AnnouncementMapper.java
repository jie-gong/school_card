package com.gong.school_card.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gong.school_card.pojo.Announcement;
import com.gong.school_card.pojo.Student;
import com.gong.school_card.pojo.vo.AnnouncementAndStudent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Property;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    Student SelectStudentName(int student);


    /**
     * 分页降序查询数据
     *
     * @param page
     * @return
     */
    IPage<AnnouncementAndStudent> listNewsDesc(Page<AnnouncementAndStudent> page, Integer studentid);

    /**
     * 分页降序查询数据
     *
     * @param page
     * @return
     */
    IPage<AnnouncementAndStudent> listNewsEsc(Page<AnnouncementAndStudent> page, Integer studentid);
}
