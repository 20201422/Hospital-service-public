/**
 * @ClassName ManagerMapper
 * @Author 24
 * @Date 2023/6/23 04:17
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.mapper;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ManagerMapper {

    @Select("select * from manager where manager_id = #{managerId}")
    Manager findManagerById(String managerId);

}

//    may the force be with you.
//    @ClassName   ManagerMapper
//    Created by 24 on 2023/6/23.
