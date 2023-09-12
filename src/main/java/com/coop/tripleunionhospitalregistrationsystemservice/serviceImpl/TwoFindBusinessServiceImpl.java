package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.BusinessDetail;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.BusinessMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.service.FindBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwoFindBusinessServiceImpl implements FindBusinessService {
    private BusinessMapper businessMapper;
    
    
    @Autowired
    public TwoFindBusinessServiceImpl(BusinessMapper businessMapper){
        this.businessMapper = businessMapper;
    }
    @Override
    public IPage<BusinessDetail> showBusiness(Page<BusinessDetail> page, String departmentName, String consultingRoom, String timeFrameBeginTime, String timeFrameEndTime) {
        return businessMapper.findBusiness(page,departmentName,consultingRoom);
    }
}
