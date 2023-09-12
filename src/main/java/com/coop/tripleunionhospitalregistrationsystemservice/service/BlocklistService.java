/**
 * @ClassName BlocklistService
 * @Author 24
 * @Date 2023/6/21 21:54
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.BlockListObject;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.Blocklist;

import java.util.List;

public interface BlocklistService {

    Blocklist getBlocklistById(String recordsId);   // 获取黑名单
    IPage<BlockListObject> showBlockListPage(Page<BlockListObject> page,String recordsName,String recordsPatientSex,String createTime,String removeTime);
    void deleteBlockList(int blocklistId);
    void insertBlockList(String recordsId,String createTime,String removeTime);
    List<Blocklist> showBlockLists();
    List<BlockListObject> showBlockListObject();

}

//    may the force be with you.
//    @ClassName   BlocklistService
//    Created by 24 on 2023/6/21.
