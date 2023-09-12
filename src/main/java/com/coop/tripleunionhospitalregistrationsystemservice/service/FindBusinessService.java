package com.coop.tripleunionhospitalregistrationsystemservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.BusinessDetail;

public interface FindBusinessService {
  IPage<BusinessDetail> showBusiness(Page<BusinessDetail> page, String departmentName, String consultingRoom, String timeFrameBeginTime, String timeFrameEndTime);
}
