/**
 * @ClassName BlocklistMapper
 * @Author 24
 * @Date 2023/6/21 21:52
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.BlockListObject;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Blocklist;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlocklistMapper {

    @Select("select * from blocklist where records_id = #{recordsId}")
    Blocklist getBlocklistById(String recordsId);   // 获取黑名单

    @Select("select records_name,records_patient_phone_number,records_patient_sex,create_time,remove_time\n" +
            "from blocklist,medical_records\n" +
            "where blocklist.records_id = medical_records.records_id and records_name = IFNULL(#{recordsName}, records_name) " +
            "and records_patient_sex = IFNULL(#{recordsPatientSex}, records_patient_sex) and create_time = IFNULL(#{createTime}, create_time) and remove_time = IFNULL(#{removeTime}, remove_time)")
    IPage<BlockListObject> findBlockListPage(Page page, String recordsName,String recordsPatientSex,String createTime,String removeTime);

    @Select("select * from blocklist")
    List<Blocklist> findAllBlockList();

    @Select("select records_name,records_patient_phone_number,records_patient_sex,create_time,remove_time\n" +
            "from blocklist,medical_records\n" +
            "where blocklist.records_id = medical_records.records_id")
    List<BlockListObject> findBlockListObject();

    @Delete("delete from blocklist where blocklist_id = #{blocklistId}")
    void deleteOne(int blocklistId);

    @Insert("insert ignore into blocklist(blocklist_id,records_id,create_time,remove_time) values(null,#{recordsId},#{createTime},#{removeTime})")
    void insertOne(String recordsId,String createTime,String removeTime);


}

//    may the force be with you.
//    @ClassName   BlocklistMapper
//    Created by 24 on 2023/6/21.
