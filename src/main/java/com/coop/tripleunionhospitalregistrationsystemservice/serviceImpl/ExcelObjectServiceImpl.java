package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.ExcelObject;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.ExcelObjectMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.service.ExcelObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcelObjectServiceImpl implements ExcelObjectService {

  @Autowired
  private ExcelObjectMapper excelObjectMapper;

  @Override
  public List<ExcelObject> getExcelList() {
    return excelObjectMapper.findAll();
  }
}
