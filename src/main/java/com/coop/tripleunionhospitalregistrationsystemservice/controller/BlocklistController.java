/**
 * @ClassName BlocklistController
 * @Author 24
 * @Date 2023/6/22 01:01
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.ApiResult;
import com.coop.tripleunionhospitalregistrationsystemservice.entity.manager.BlockListObject;
import com.coop.tripleunionhospitalregistrationsystemservice.serviceImpl.BlocklistServiceImpl;
import com.coop.tripleunionhospitalregistrationsystemservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/blocklist")
public class BlocklistController {

    private BlocklistServiceImpl blocklistService;

    public BlocklistController() {
    }

    @Autowired
    public BlocklistController(BlocklistServiceImpl blocklistService) {
        this.blocklistService = blocklistService;
    }

    public BlocklistServiceImpl getBlocklistService() {
        return blocklistService;
    }

    public void setBlocklistService(BlocklistServiceImpl blocklistService) {
        this.blocklistService = blocklistService;
    }

    @PostMapping("/add")
    public ApiResult<?> addBlocklist(@RequestBody Map<String, String> map) {    // 加入黑名单
        return ApiResultHandler.success(blocklistService.getBlocklistById(map.get("recordsId")));
    }

    @PostMapping(value = "/showBlockListObject")
    public ApiResult<?> getBlockListObject() {
        return ApiResultHandler.success(blocklistService.showBlockListObject());
    }

    @GetMapping(value = "/blocklist")
    public ApiResult<?> getBlocklist(@RequestParam("page") Integer page,
                                     @RequestParam("size") Integer size,
                                     @RequestParam("recordsName") String recordsName,
                                     @RequestParam("recordsPatientSex") String recordsPatientSex,
                                     @RequestParam("createTime") String createTime,
                                     @RequestParam("removeTime") String removeTime){
        Page<BlockListObject> blocklist = new Page<>(page,size);
        return ApiResultHandler.success(blocklistService.showBlockListPage(blocklist,recordsName,recordsPatientSex,createTime,removeTime));
    }

}

//    may the force be with you.
//    @ClassName   BlocklistController
//    Created by 24 on 2023/6/22.
