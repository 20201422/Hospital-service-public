/**
 * @ClassName RegistrationMapper
 * @Author 24
 * @Date 2023/6/21 21:13
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.mapper;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.RegistrationObject;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Registration;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.patient.PatientShowRegistration;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RegistrationMapper {

    @Select("SELECT r.registration_id, mr.records_id, mr.records_name, mr.records_patient_sex, \n" +
            "\t   nsd.doctor_id, nsd.doctor_name, b.department_id,\n" +
            "       nsd.department_name, nsd.number_source_date, nsd.consulting_room_type, \n" +
            "       nsd.AM_or_PM, nsd.consultation_period, nsd.number_source_fee, \n" +
            "       r.registration_state, r.registration_time\n" +
            "FROM medical_records mr\n" +
            "    JOIN registration r ON mr.records_id = r.records_id\n" +
            "    JOIN number_source_detail nsd ON r.number_source_detail_id = nsd.number_source_detail_id\n" +
            "    JOIN number_source ns ON nsd.number_source_id = ns.number_source_id\n" +
            "    JOIN business b ON ns.business_id = b.business_id\n" +
            "WHERE mr.patient_id = #{patientId};")
    List<PatientShowRegistration> getRegistrationList(String patientId);    // 获取挂号单列表

    @Select("select * from registration")
    List<Registration> getAllRegistrations();   // 获取所有挂号单

    @Select("SELECT r.registration_id, mr.records_id, mr.records_name, mr.records_patient_sex, \n" +
            "\t   nsd.doctor_id, nsd.doctor_name, b.department_id,\n" +
            "       nsd.department_name, nsd.number_source_date, nsd.consulting_room_type, \n" +
            "       nsd.AM_or_PM, nsd.consultation_period, nsd.number_source_fee, \n" +
            "       r.registration_state, r.registration_time\n" +
            "FROM medical_records mr\n" +
            "    JOIN registration r ON mr.records_id = r.records_id\n" +
            "    JOIN number_source_detail nsd ON r.number_source_detail_id = nsd.number_source_detail_id\n" +
            "    JOIN number_source ns ON nsd.number_source_id = ns.number_source_id\n" +
            "    JOIN business b ON ns.business_id = b.business_id\n" +
            "WHERE r.registration_id = #{registrationId};")
    PatientShowRegistration getPatientShowRegistrationById(String registrationId);  // 根据id查看挂号单

    @Select("select * from registration where records_id = #{recordsId};")
    List<Registration> getRegistrationListByRecordsId(String recordsId);   // 根据档案id查询挂号单

    @Select("select * from registration where registration_id = #{registrationId};")
    Registration getRegistrationById(int registrationId);   // 获取一个挂号单
    @Insert("insert into registration(registration_id, records_id, number_source_detail_id, registration_state, registration_time) \n" +
            "values (0, #{recordsId}, #{numberSourceDetailId}, #{registrationState}, CURRENT_TIMESTAMP());")
    void insertRegistration(Registration registration);// 添加挂号单

    @Select("SELECT LAST_INSERT_ID();\n")
    int getLastRegistrationId();    // 获取最后一个挂号单id

    @Update("update Registration\n" +
            "set registration_state = #{registrationState}\n" +
            "where registration_id = #{registrationId};\n")
    void updateRegistrationState(int registrationId, String registrationState);// 更新挂号单状态

    @Select("select records_id,count(*) as num FROM registration where registration_time >= NOW() - INTERVAL 3 MONTH and registration_state = '退号' order by records_id")
    List<RegistrationObject> getRegistrationObjectList();

}

//    may the force be with you.
//    @ClassName   RegistrationMapper
//    Created by 24 on 2023/6/21.
