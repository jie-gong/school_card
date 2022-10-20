package com.gong.school_card.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gong.school_card.pojo.Record;
import com.gong.school_card.pojo.Student;
import com.gong.school_card.pojo.vo.RecordAndStudent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.mapper.RecordMapper
 * @Date: 2022年09月12日 07:59
 * @Description:
 */
@Mapper
@Repository
public interface RecordMapper extends BaseMapper<Record> {
    //多表查询 查询学生充值记录
    List<RecordAndStudent> selectLists();
    //通过姓名搜索充值记录
    List<RecordAndStudent> selectByName(String name);
    //时间升序
    List<RecordAndStudent>TimeAscending();
    //时间升序
    List<RecordAndStudent>NameAscending();
}
