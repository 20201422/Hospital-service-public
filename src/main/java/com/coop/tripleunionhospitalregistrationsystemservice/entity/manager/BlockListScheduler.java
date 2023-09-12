package com.coop.tripleunionhospitalregistrationsystemservice.entity.manager;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Blocklist;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.BlocklistServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.PatientRegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class BlockListScheduler {

  private PatientRegistrationServiceImpl patientRegistrationService;
  private BlocklistServiceImpl blocklistService;
  @Autowired
  public BlockListScheduler(PatientRegistrationServiceImpl patientRegistrationService,BlocklistServiceImpl blocklistService){
    this.patientRegistrationService = patientRegistrationService;
    this.blocklistService = blocklistService;
  }
  @Scheduled(fixedDelay = 10800000)//三小时执行一次
  public void run() {
    // 定时任务内容

    //自动加入黑名单
    List<RegistrationObject> registrationObjects = patientRegistrationService.showRegistrationObjects();
    for (int i = 0;i<registrationObjects.size();i++){
      if(registrationObjects.get(i).getNum() >= 3){
        LocalDate nowDate = LocalDate.now(); //获取当前日期
        LocalDate sixMonthsLater = nowDate.plusMonths(6); //计算6个月后的日期
        blocklistService.insertBlockList(registrationObjects.get(i).getRecordsId(),nowDate.toString(),sixMonthsLater.toString());
      }
    }

    //自动移出黑名单
    List<Blocklist> blocklists = blocklistService.showBlockLists();
    for(int i = 0;i<blocklists.size();i++){
      LocalDate nowDate = LocalDate.now();
      if(!nowDate.isBefore(LocalDate.parse(blocklists.get(i).getRemoveTime()))){
        blocklistService.deleteBlockList(blocklists.get(i).getBlocklistId());
      }
    }

  }
}
