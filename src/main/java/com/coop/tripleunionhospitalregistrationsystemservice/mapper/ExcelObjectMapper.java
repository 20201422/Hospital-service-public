package com.coop.tripleunionhospitalregistrationsystemservice.mapper;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.ExcelObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExcelObjectMapper {
  @Select("SELECT *\n" +
          "FROM number_source_detail\n" +
          "WHERE number_source_date BETWEEN DATE_SUB(DATE_SUB(DATE_FORMAT(DATE_SUB(CURRENT_DATE, INTERVAL WEEKDAY(CURRENT_DATE) DAY), '%Y-%m-%d'), INTERVAL 7 DAY), INTERVAL 1 DAY) \n" +
          "AND  DATE_SUB(DATE_FORMAT(DATE_ADD(CURRENT_DATE, INTERVAL 6 - WEEKDAY(CURRENT_DATE) DAY), '%Y-%m-%d'), INTERVAL 7 DAY)\n" +
          "\n" +
          "UNION ALL\n" +
          "\n" +
          "SELECT *\n" +
          "FROM number_source_detail\n" +
          "WHERE number_source_date BETWEEN DATE_FORMAT(DATE_SUB(CURRENT_DATE, INTERVAL WEEKDAY(CURRENT_DATE) DAY), '%Y-%m-%d') \n" +
          "AND DATE_FORMAT(DATE_ADD(CURRENT_DATE, INTERVAL 6 - WEEKDAY(CURRENT_DATE) DAY), '%Y-%m-%d')\n" +
          "\n" +
          "UNION ALL\n" +
          "\n" +
          "SELECT *\n" +
          "FROM number_source_detail\n" +
          "WHERE number_source_date BETWEEN DATE_ADD(DATE_FORMAT(DATE_SUB(CURRENT_DATE, INTERVAL WEEKDAY(CURRENT_DATE) DAY), '%Y-%m-%d'), INTERVAL 7 DAY) \n" +
          "AND DATE_ADD( DATE_ADD( DATE_FORMAT(DATE_ADD(CURRENT_DATE, INTERVAL 6 - WEEKDAY(CURRENT_DATE) DAY), '%Y-%m-%d'), INTERVAL 7 DAY), INTERVAL 1 DAY);")
  List<ExcelObject> findAll();
}
