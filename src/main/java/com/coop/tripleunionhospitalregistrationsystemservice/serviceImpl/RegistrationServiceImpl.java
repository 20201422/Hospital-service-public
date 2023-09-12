/**
 * @ClassName RegistrationServiceImpl
 * @Author 24
 * @Date 2023/7/1 18:42
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.RegistrationObject;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.CancelAppointment;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.NumberSourceDetail;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Registration;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.patient.NumberSourceInformation;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.patient.PatientShowRegistration;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.CancelAppointmentMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.NumberSourceMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.RegistrationMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.service.CancelAppointmentService;
import com.coop.tripleunionhospitalregistrationsystemservice.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class RegistrationServiceImpl implements RegistrationService<String>, CancelAppointmentService {
    
    private NumberSourceMapper numberSourceMapper;
    private RegistrationMapper registrationMapper;
    private CancelAppointmentMapper cancelAppointmentMapper;
    
    private BlocklistServiceImpl blocklistService;
    private NumberSourceDetailServiceImpl numberSourceDetailService;
    private RegistrationEmailServiceImpl registrationEmailService;
    
    public RegistrationServiceImpl() {
    }
    
    @Autowired
    public RegistrationServiceImpl(NumberSourceMapper numberSourceMapper, RegistrationMapper registrationMapper,
                                          CancelAppointmentMapper cancelAppointmentMapper,
                                          BlocklistServiceImpl blocklistService,
                                          NumberSourceDetailServiceImpl numberSourceDetailService,
                                          RegistrationEmailServiceImpl registrationEmailService) {
        this.numberSourceMapper = numberSourceMapper;
        this.registrationMapper = registrationMapper;
        this.cancelAppointmentMapper = cancelAppointmentMapper;
        this.blocklistService = blocklistService;
        this.numberSourceDetailService = numberSourceDetailService;
        this.registrationEmailService = registrationEmailService;
    }
    
    public NumberSourceMapper getNumberSourceMapper() {
        return numberSourceMapper;
    }
    
    public void setNumberSourceMapper(NumberSourceMapper numberSourceMapper) {
        this.numberSourceMapper = numberSourceMapper;
    }
    
    public RegistrationMapper getRegistrationMapper() {
        return registrationMapper;
    }
    
    public void setRegistrationMapper(RegistrationMapper registrationMapper) {
        this.registrationMapper = registrationMapper;
    }
    
    public CancelAppointmentMapper getCancelAppointmentMapper() {
        return cancelAppointmentMapper;
    }
    
    public void setCancelAppointmentMapper(CancelAppointmentMapper cancelAppointmentMapper) {
        this.cancelAppointmentMapper = cancelAppointmentMapper;
    }
    
    public BlocklistServiceImpl getBlocklistService() {
        return blocklistService;
    }
    
    public void setBlocklistService(BlocklistServiceImpl blocklistService) {
        this.blocklistService = blocklistService;
    }
    
    public NumberSourceDetailServiceImpl getNumberSourceDetailService() {
        return numberSourceDetailService;
    }
    
    public void setNumberSourceDetailService(NumberSourceDetailServiceImpl numberSourceDetailService) {
        this.numberSourceDetailService = numberSourceDetailService;
    }
    
    @Override
    public List<RegistrationObject> showRegistrationObjects() {
        return registrationMapper.getRegistrationObjectList();
    }
    
    public RegistrationEmailServiceImpl getRegistrationEmailService() {
        return registrationEmailService;
    }
    
    public void setRegistrationEmailService(RegistrationEmailServiceImpl registrationEmailService) {
        this.registrationEmailService = registrationEmailService;
    }
    
    @Override
    public Map<String, List<NumberSourceInformation>> showNumberSourceInformationList(String date, String departmentId) {   // 查看号源
        
        List<NumberSourceInformation> list = numberSourceMapper.patientGetSourceNumberInfo(date, departmentId);
        
        Map<String, List<NumberSourceInformation>> map = new HashMap<>();
        for (NumberSourceInformation numberSourceInformation: list) {
            String type = numberSourceInformation.getConsultingRoomType();
            List<NumberSourceInformation> numberSourceInformationsList = map.computeIfAbsent(type, k-> new ArrayList<>());
            numberSourceInformationsList.add(numberSourceInformation);
        }
        
        return map;
    }
    
    
    private boolean isCancelInOneHour(String time, String state) {  // 判断有没有1小时内同一科室的号的状态是已取消
        // 转换为时间
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTime = null;
        try {
            dateTime = dateFormat.parse(time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        //获取一小时前的时刻
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, -1);
        Date oneHourAgo = calendar.getTime();
        
        return  (dateTime.after(oneHourAgo)  // 在1小时之内
                && Objects.equals(state, "取消"));   // 并且状态为已取消
        
    }
    private boolean isNotPay(String time, String state) {   // 判断当天是否有号源存在未支付
        LocalDate currentDate = LocalDate.now();
        
        // 解析字符串为日期对象
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate registrationDate = LocalDate.parse(time, formatter);
        
        // 判断日期是否是今天
        return currentDate.isEqual(registrationDate)   // 有未支付的挂号单
                && Objects.equals(state, "未支付");
    }
    private boolean isRepeatNumberSource(String numberSourceDetailId, Map<String, String> map, String state) {    // 判断是否有重复号源
        NumberSourceDetail numberSourceDetail = numberSourceDetailService.getNumberSourceDetail(numberSourceDetailId);   // 获取对应号源明细
        
        return Objects.equals(map.get("doctorId"), numberSourceDetail.getDoctorId()) && // 医生id相同
                Objects.equals(map.get("numberSourceDate"), numberSourceDetail.getNumberSourceDate()) &&    // 日期相同
                Objects.equals(map.get("aMOrPm"), numberSourceDetail.getAMOrPM()) && // 午别相同
                Objects.equals(state, "成功");  // 挂号成功
    }
    
    
    @Override
    public int register(Object map) {   // 挂号
        
        HashMap<String, String> data = (HashMap<String, String>) map;
        // {departmentId=1001, doctorId=1001001, numberSourceDate=2023-06-30, aMOrPm=上午, recordsId=000000999988887776}
        // 判断是否在黑名单
        if (blocklistService.getBlocklistById(data.get("recordsId")) != null) {
            return 0;  // 在黑名单
        }
        
        List<Registration> list = getRegistrationListByRecordsId(data.get("recordsId"));
        
        // 挂号判断
        int notPayCount = 0;
        for(Registration registration: list) {
            String strDate = registration.getRegistrationTime();
            
            if (isRepeatNumberSource(String.valueOf(registration.getNumberSourceDetailId()), data,
                    registration.getRegistrationState())) {   // 判断是否有重复的挂号成功地挂号单
                return -4;
            }
            if (Objects.equals(registration.getRegistrationState(), "待支付")) {    // 判断是否有号源是待支付
                return -1;
            }
            if (isCancelInOneHour(strDate, registration.getRegistrationState())) { // 判断有没有1小时内同一科室的号的状态是已取消
                return -2;
            }
            if (isNotPay(strDate, registration.getRegistrationState())) {  // 判断当天是否有号源存在未支付
                notPayCount++;
            }
            if (notPayCount >= 3) {  // 未支付的号源超过三次
                return -3;
            }
        }
        
        // 获取号源明细id
        int numberSourceDetailId;
        try {
            numberSourceDetailId = numberSourceDetailService
                    .register(data.get("doctorId"), data.get("numberSourceDate"), data.get("aMOrPm"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        // 添加挂号单
        Registration registration = new Registration(0, data.get("recordsId"),
                numberSourceDetailId, "待支付", null);
        registrationMapper.insertRegistration(registration);
        
        // 更改号源明细状态
        numberSourceDetailService.updateState(numberSourceDetailId, "已锁定");
        
        
        int registrationId = getLastRegistrationId();   // 获取挂号单id
        // 发送邮件
        registrationEmailService.sendRegistrationEmail(getPatientShowRegistrationById(String.valueOf(registrationId)));
        
        // 判断10分钟后是否支付
        // 创建一个ScheduledExecutorService实例
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // 延迟10分钟后执行代码
        executor.schedule(() -> {   // 判断是否支付
            notPayment(registrationId);
        }, 11, TimeUnit.MINUTES);
        // 关闭执行器
        executor.shutdown();
        
        return registrationId;
    }
    
    @Override
    public int getLastRegistrationId() {    // 获得最后一个挂号单id
        return registrationMapper.getLastRegistrationId();
    }
    
    @Override
    public int notPayment(int registrationId) { // 未支付
        
        // 找到挂号单
        PatientShowRegistration patientShowRegistration =
                registrationMapper.getPatientShowRegistrationById(String.valueOf(registrationId));
        
        String registrationTime = patientShowRegistration.getRegistrationTime();
        
        // 将字符串时间解析为 LocalDateTime 对象
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse(registrationTime, formatter);
        // 获取当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        // 判断给定时间是否在当前时间的十分钟前
        LocalDateTime tenMinutesAgo = currentTime.minusMinutes(10);
        
        if (time.isBefore(tenMinutesAgo)
                && patientShowRegistration.getRegistrationState().equals("待支付")) { // 超时且未支付
            
            updateRegistrationState(registrationId, "未支付");// 更改挂号单状态为未支付
            
            // 将号源放回号源池
            numberSourceDetailService.updateState(((Registration)
                    showOneRegistration(registrationId)).getNumberSourceDetailId(), "未挂号");
            
            // 添加到取消挂号表
            insertCancelAppointment(new CancelAppointment(0, registrationId,
                    ((Registration) showOneRegistration(registrationId)).getRegistrationTime(), null));
            
            // 邮件通知
            registrationEmailService.sendNotPayEmail(getPatientShowRegistrationById(String.valueOf(registrationId)));
            
            return 1;
        }
        return 0;
    }
    
    @Override
    public int cancelRegistration(int registrationId) {  // 取消挂号
        
        updateRegistrationState(registrationId, "取消");  // 更改挂号单状态
        
        // 将号源放回号源池
        numberSourceDetailService.updateState(
                ((Registration) showOneRegistration(registrationId)).getNumberSourceDetailId(), "未挂号");
        
        // 添加到取消挂号表
        insertCancelAppointment(new CancelAppointment(0, registrationId,
                ((Registration) showOneRegistration(registrationId)).getRegistrationTime(), null));
        
        // 邮件通知
        registrationEmailService.sendCancelEmail(getPatientShowRegistrationById(String.valueOf(registrationId)));
        
        return 0;
    }
    
    @Override
    public int exitRegistration(int registrationId) {   // 退号
        
        updateRegistrationState(registrationId, "退号");  // 更改挂号单状态
        
        // 将号源放回号源池
        numberSourceDetailService.updateState(
                ((Registration) showOneRegistration(registrationId)).getNumberSourceDetailId(), "未挂号");
        
        // 添加到取消挂号表
        insertCancelAppointment(new CancelAppointment(0, registrationId,
                ((Registration) showOneRegistration(registrationId)).getRegistrationTime(), null));
        
        // 邮件通知
        registrationEmailService.sendExitEmail(getPatientShowRegistrationById(String.valueOf(registrationId)));
        
        return 0;
    }
    
    
    @Override
    public List<PatientShowRegistration> showRegistrations(String param) {   // 查看挂号列表
        
        List<PatientShowRegistration> list = registrationMapper.getRegistrationList(param);
        
        // 循环检查挂号单是否存在未支付且超过十分钟的，有的话就未支付
        for (PatientShowRegistration patientShowRegistration: list) {
            notPayment(Integer.parseInt(patientShowRegistration.getRegistrationId()));
        }
        
        return list;
    }
    
    @Override
    public List<Registration> getAllRegistrations() {   // 获取所有挂号单
        return registrationMapper.getAllRegistrations();
    }
    
    @Override
    public List<Registration> getRegistrationListByRecordsId(String recordsId) {    // 根据档案id查询挂号单
        return registrationMapper.getRegistrationListByRecordsId(recordsId);
    }
    
    @Override
    public PatientShowRegistration getPatientShowRegistrationById(String registrationId) {  // 根据id查看挂号单
        return registrationMapper.getPatientShowRegistrationById(registrationId);
    }
    
    @Override
    public Object showOneRegistration(int registrationId) {  // 查看一个挂号单
        return registrationMapper.getRegistrationById(registrationId);
    }
    
    @Override
    public int insertCancelAppointment(CancelAppointment cancelAppointment) {  // 添加取消预约
        return cancelAppointmentMapper.insertCancelAppointment(cancelAppointment);
    }
    
    public void updateRegistrationState(int registrationId, String state) {  // 更改挂号单状态
        registrationMapper.updateRegistrationState(registrationId, state);
    }
    
}


//    may the force be with you.
//    @ClassName   RegistrationServiceImpl
//    Created by 24 on 2023/7/1.
