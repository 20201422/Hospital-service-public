package com.coop.tripleunionhospitalregistrationsystemservice.controller;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.ExcelObject;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.ExcelObjectServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.util.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelController {
  private ExcelObjectServiceImpl excelObjectService;

  @Autowired
  public ExcelController(ExcelObjectServiceImpl excelObjectService){
    this.excelObjectService = excelObjectService;
  }

  @PostMapping(value = "/export")
  public void exportXls(@RequestBody String id, HttpServletResponse response) throws Exception {
    // 这里的业务数据根据自己的业务场景去做查询
    List<ExcelObject> list = excelObjectService.getExcelList();
    try {
      ExcelUtils.exportExcel(response,list, ExcelObject.class,"信息","信息");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
