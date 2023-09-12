/**
 * @ClassName PatientRegistrationServiceImpl
 * @Author 24
 * @Date 2023/6/20 08:08
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import com.coop.tripleunionhospitalregistrationsystemservice.mapper.CancelAppointmentMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.NumberSourceMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.RegistrationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientRegistrationServiceImpl extends RegistrationServiceImpl {
    
    public PatientRegistrationServiceImpl() {
    }
    
    @Autowired
    public PatientRegistrationServiceImpl(NumberSourceMapper numberSourceMapper, RegistrationMapper registrationMapper,
                                          CancelAppointmentMapper cancelAppointmentMapper,
                                          BlocklistServiceImpl blocklistService,
                                          NumberSourceDetailServiceImpl numberSourceDetailService,
                                          RegistrationEmailServiceImpl registrationEmailService) {
        super(numberSourceMapper, registrationMapper, cancelAppointmentMapper, blocklistService,
                numberSourceDetailService, registrationEmailService);
    }
    
    
}

//    may the force be with you.
//    @ClassName   PatientRegistrationServiceImpl
//    Created by 24 on 2023/6/20.
