package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.arrangement.ArrangementInfo;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.arrangement.ArrangementProtoType;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.TimeFrameArrangementMaxAndMin;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Doctor;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.ArrangementMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.DoctorMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.NumberSourceDetailMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.NumberSourceMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.service.ArrangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArrangementServiceImpl implements ArrangementService {
    ArrangementMapper arrangementMapper;
    NumberSourceDetailMapper numberSourceDetailMapper;
    DoctorMapper doctorMapper;
    NumberSourceMapper numberSourceMapper;
    NumberSourceDetailServiceImpl numberSourceDetailService;

    @Autowired
    public ArrangementServiceImpl(ArrangementMapper arrangementMapper, NumberSourceDetailMapper numberSourceDetailMapper, DoctorMapper doctorMapper, NumberSourceMapper numberSourceMapper, NumberSourceDetailServiceImpl numberSourceDetailService) {
        this.arrangementMapper = arrangementMapper;
        this.numberSourceDetailMapper = numberSourceDetailMapper;
        this.doctorMapper = doctorMapper;
        this.numberSourceMapper = numberSourceMapper;
        this.numberSourceDetailService = numberSourceDetailService;
    }


    public ArrangementServiceImpl() {
    }

    @Override
    public int addArrangement(String doctorId, String consultingRoomId, String numberSourceId, int number) {

        String[] id = numberSourceId.split(",");  //将号源id分割
        //将所有号源尽可能均匀分配到每个时段
        int timeNum = id.length;
        for (int i = 0; i < timeNum; i++) {
            int min = number * i / timeNum;
            int max = number * (i + 1) / timeNum;
            int averageNum = max - min;
            arrangementMapper.addArrangement(doctorId, consultingRoomId, Integer.parseInt(id[i]), averageNum);
        }
        return 1;
    }

    @Override
    public int addArrangementInfo(String doctorId, String consultingRoomId, String departmentId, String numberSourceDate,
                                  String amOrPm, int number) {
        return arrangementMapper.addArrangementInfo(doctorId, consultingRoomId, departmentId, numberSourceDate,
                amOrPm, number);
    }

    @Override
    public List<ArrangementInfo> findArrangementByDepartmentId(String departmentId) {
        return arrangementMapper.findArrangementByDepartmentId(departmentId);
    }

    @Override
    public List<ArrangementInfo> findArrangementByDoctorId(String doctorId) {
        return arrangementMapper.findArrangementByDoctorId(doctorId);
    }


    @Override
    public int deleteArrangementInfo(String doctorId, String consultingRoomId, String numberSourceDate, String amOrPm) {
        return arrangementMapper.deleteArrangementInfo(doctorId, consultingRoomId, numberSourceDate, amOrPm);
    }

    @Override
    public int arrange(String doctorId, String consultingRoomId, String numberSourceDate, String numberSourceId,
                       String amOrPm, int number, String departmentId, String consultingRoomType) {
        System.out.println(doctorId + "," + consultingRoomId + "," + numberSourceDate + "," + numberSourceId + "," + amOrPm + "," + number + "," + departmentId + "," + consultingRoomType);
        Doctor doctor = doctorMapper.findDoctorById(doctorId);
        int goalNumber = numberSourceMapper.findRemainNumberSource(doctor.getDoctorLevel(), consultingRoomType,
                numberSourceDate, amOrPm, departmentId);
        if (arrangementMapper.dateDiff(numberSourceDate) < 7
                || arrangementMapper.dateDiff(numberSourceDate) > 20) {  //如果调班日期不在范围内
            return -1;
        }
        if (ifHaveDoctor(doctorId, numberSourceDate, amOrPm) > 0
                && !(numberSourceDate.equals(numberSourceDate) && amOrPm.equals(amOrPm))) {  //如果该医生在调班日期已经排班(但不算当前时间)
            return -2;
        }
        if (ifHaveConsultingRoom(consultingRoomId, numberSourceDate, amOrPm) > 0) {  //如果调班诊室已排
            return -3;
        }
        if (goalNumber < number) { //如果要调班的日期的号源不足
            return -4;
        }
        addArrangement(doctorId, consultingRoomId, numberSourceId, number);
        addArrangementInfo(doctorId, consultingRoomId, departmentId, numberSourceDate, amOrPm, number);
        return 1;
    }

    @Override
    public int quickArrange(String departmentId) {
        String[] dates = new String[14];
        LocalDate date = LocalDate.now();
        for (int i = 0; i < 14; i++) {    //得到在排班范围内的所有日期
            dates[i] = date.plusDays(i + 7).toString();
        }
        List<ArrangementProtoType> protoTypeList = new ArrayList<ArrangementProtoType>(); //排班原型list
        for (int i = 0; i < dates.length; i++) {
            //找到前七天的一天的排班（比如星期一，查找的是上个星期一的排班）
            List<ArrangementInfo> list = arrangementMapper.getInfoByTime(departmentId, dates[i]);

            for (ArrangementInfo arrangementInfo : list) {
                String doctorId = arrangementInfo.getDoctorId();
                String consultingRoomId = arrangementInfo.getConsultingRoomId();
                String numberSourceDate = dates[i];    //与七天前的排班比较，只有日期是不同的
                //String numberSourceDate = arrangementInfo.getNumberSourceDate();
                String amOrPm = arrangementInfo.getAmOrPm();
                int number = arrangementInfo.getNumber();
                String consultingRoomType = "";
                //根据医生职称获得对应医生的门诊类型
                Doctor doctor = doctorMapper.findDoctorById(doctorId);
                String level = doctor.getDoctorLevel();
                System.out.println(level);
                if (level.equals("主任医师")) {
                    consultingRoomType = "专家门诊";
                }
                if (level.equals("主治医师")) {
                    consultingRoomType = "特需门诊";
                }
                if (level.equals("医生")) {
                    consultingRoomType = "普通门诊";
                }
                List<Integer> numberSourceId = numberSourceMapper.findNumberSourceIdByDate(numberSourceDate, amOrPm,
                        consultingRoomType, departmentId); //得到号源id数组

                String id = "";
                for (Integer x : numberSourceId) {  //拼接号源id
                    id += x.toString() + ",";
                }
                ArrangementProtoType protoType = new ArrangementProtoType(doctorId,consultingRoomId,id,numberSourceDate,
                        amOrPm,number,consultingRoomType,departmentId);
                protoTypeList.add(protoType); //添加进排班原型列表
            }
            //遍历排班原型列表(一天的)
            for (int j = 0; j < protoTypeList.size(); j++) {
                //克隆排班
                ArrangementProtoType arrangement = (protoTypeList.get(j)).clone();
                String doctorId = arrangement.getDoctorId();
                String consultingRoomId = arrangement.getConsultingRoomId();
                String numberSourceDate = arrangement.getNumberSourceDate();
                String numberSourceId = arrangement.getNumberSourceId();
                String amOrPm = arrangement.getAmOrPm();
                int number = arrangement.getNumber();
                String consultingRoomType = arrangement.getConsultingRoomType();
                Thread thread = new Thread(new Runnable() {//多线程加快速度
                    @Override
                    public void run() {
                        int message = arrange(doctorId, consultingRoomId,
                                numberSourceDate,numberSourceId, amOrPm,
                                number, departmentId, consultingRoomType);
                        if (message == 1) {  //如果排班成功，就生成号源明细
                            numberSourceDetailService.addNumberSourceDetail(doctorId,numberSourceDate,amOrPm);
                        }

                    }
                });
                thread.start();
            }
            protoTypeList.clear();
        }
        return 1;
    }

    @Override
    public int deleteArrangement(String doctorId, String consultingRoomId, String numberSourceDate, String amOrPm) {
        arrangementMapper.deleteArrangementInfo(doctorId, consultingRoomId, numberSourceDate, amOrPm);   //删除排班明细
        numberSourceDetailMapper.deleteNumberSourceDetail(doctorId, numberSourceDate, amOrPm);   //删除号源明细
        arrangementMapper.deleteArrangement(doctorId, consultingRoomId, numberSourceDate, amOrPm);
        return 1;
    }

    @Override
    public int deleteAll(String departmentId) {
        String[] dates = new String[14];
        LocalDate date = LocalDate.now();
        for (int i = 0; i < 14; i++) {
            dates[i] = date.plusDays(i + 7).toString();
        }
        for (int i = 0; i < dates.length; i++) {
            int finalI = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    arrangementMapper.deleteNumberSourceDetailOneDay(departmentId,dates[finalI]);
                    arrangementMapper.deleteArrangementInfoOneDay(departmentId,dates[finalI]);
                    arrangementMapper.deleteArrangementOneDay(departmentId,dates[finalI]);
                }
            });
            thread.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }


    @Override
    public int updateArrangement(String doctorId, String consultingRoomId, String numberSourceDate,
                                 String amOrPm, String NewConsultingRoomId, String newNumberSourceId,
                                 int number, String departmentId, String newNumberSourceDate, String newAmOrPm, String consultingRoomType) {
        Doctor doctor = doctorMapper.findDoctorById(doctorId);
        int goalNumber = numberSourceMapper.findRemainNumberSource(doctor.getDoctorLevel(), consultingRoomType,
                newNumberSourceDate, newAmOrPm, departmentId);
        if (arrangementMapper.dateDiff(newNumberSourceDate) < 7
                || arrangementMapper.dateDiff(newNumberSourceDate) > 20) {  //如果调班日期不在范围内
            return -1;
        }
        if (ifHaveDoctor(doctorId, newNumberSourceDate, newAmOrPm) > 0
                && !(numberSourceDate.equals(newNumberSourceDate) && amOrPm.equals(newAmOrPm))) {  //如果该医生在调班日期已经排班(但不算当前时间)
            return -2;
        }
        if (ifHaveConsultingRoom(NewConsultingRoomId, newNumberSourceDate, newAmOrPm) > 0) {  //如果调班诊室已排
            return -3;
        }
        if (goalNumber < number) { //如果要调班的日期的号源不足
            return -4;
        }

        deleteArrangement(doctorId, consultingRoomId, numberSourceDate, amOrPm);
        addArrangement(doctorId, NewConsultingRoomId, newNumberSourceId, number);
        addArrangementInfo(doctorId, NewConsultingRoomId, departmentId, newNumberSourceDate, newAmOrPm, number);
        //numberSourceDetailService.addNumberSourceDetail(doctorId,newNumberSourceDate,newAmOrPm);
        return 1;
    }

    @Override
    public int ifHaveDoctor(String doctorId, String numberSourceDate, String amOrPm) {
        return arrangementMapper.ifHaveDoctor(doctorId, numberSourceDate, amOrPm);
    }

    @Override
    public int ifHaveConsultingRoom(String consultingRoomId, String numberSourceDate, String amOrPm) {
        return arrangementMapper.ifHaveConsultingRoom(consultingRoomId, numberSourceDate, amOrPm);
    }

    @Override
    public TimeFrameArrangementMaxAndMin getMaxAndMin(String departmentId, String timeFrameBeginTime, String timeFrameEndTime, String consultingRoomType) {
        return arrangementMapper.getMaxAndMin(departmentId, timeFrameBeginTime, timeFrameEndTime, consultingRoomType);
    }
}
