/**
 * @ClassName BlocklistServiceImpl
 * @Author 24
 * @Date 2023/6/21 22:48
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.BlockListObject;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Blocklist;
import com.coop.tripleunionhospitalregistrationsystemservice.mapper.BlocklistMapper;
import com.coop.tripleunionhospitalregistrationsystemservice.service.BlocklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocklistServiceImpl implements BlocklistService {

    private BlocklistMapper blocklistMapper;

    public BlocklistServiceImpl() {
    }

    @Autowired
    public BlocklistServiceImpl(BlocklistMapper blocklistMapper) {
        this.blocklistMapper = blocklistMapper;
    }

    public BlocklistMapper getBlocklistMapper() {
        return blocklistMapper;
    }

    public void setBlocklistMapper(BlocklistMapper blocklistMapper) {
        this.blocklistMapper = blocklistMapper;
    }

    @Override
    public Blocklist getBlocklistById(String recordsId) {
        return blocklistMapper.getBlocklistById(recordsId);
    }

    @Override
    public IPage<BlockListObject> showBlockListPage(Page<BlockListObject> page,String recordsName,String recordsPatientSex,String createTime,String removeTime) {

        if(recordsName == null || recordsName.length() == 0){
            recordsName = null;
        }

        if(recordsPatientSex == null || recordsPatientSex.length() == 0){
            recordsPatientSex = null;
        }

        if(createTime == null || createTime.length() == 0){
            createTime = null;
        }

        if(removeTime == null || removeTime.length() == 0){
            removeTime = null;
        }
        return blocklistMapper.findBlockListPage(page,recordsName,recordsPatientSex,createTime,removeTime);
    }


    @Override
    public void deleteBlockList(int blocklistId) {
        blocklistMapper.deleteOne(blocklistId);
    }

    @Override
    public void insertBlockList(String recordsId, String createTime, String removeTime) {
        blocklistMapper.insertOne(recordsId,createTime,removeTime);
    }

    @Override
    public List<Blocklist> showBlockLists() {
        return blocklistMapper.findAllBlockList();
    }

    @Override
    public List<BlockListObject> showBlockListObject() {
        return blocklistMapper.findBlockListObject();
    }
}

//    may the force be with you.
//    @ClassName   BlocklistServiceImpl
//    Created by 24 on 2023/6/21.
