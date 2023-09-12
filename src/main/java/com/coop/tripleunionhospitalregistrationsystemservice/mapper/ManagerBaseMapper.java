package com.coop.tripleunionhospitalregistrationsystemservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerBaseMapper<T> extends BaseMapper<T> {
  // 批量插入
  void insertBatchSomeColumn(@Param("list") List<T> batchList);
}
