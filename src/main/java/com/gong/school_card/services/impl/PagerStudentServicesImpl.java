package com.gong.school_card.services.impl;

import com.gong.school_card.mapper.PagerStudentMapper;
import com.gong.school_card.pojo.PagerStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 公杰
 * @Project: JavaLaity

 * @Date: 2022年09月20日 12:10
 * @Description:
 */
@Service
public class PagerStudentServicesImpl  {
    @Autowired
    private PagerStudentMapper pagerStudentMapper;
}
