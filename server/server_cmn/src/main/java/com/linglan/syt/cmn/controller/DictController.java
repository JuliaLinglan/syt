package com.linglan.syt.cmn.controller;


import com.linglan.syt.cmn.service.DictService;
import com.linglan.syt.model.cmn.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.linglan.syt.common.result.Response;

import java.util.List;


@Api(description = "数据字典接口")
@RestController
@RequestMapping("/admin/cmn/dict")
@CrossOrigin
public class DictController {

    @Autowired
    DictService dictService;


    //根据数据id查询子数据列表
    @ApiOperation(value = "根据数据id查询子数据列表")
    @GetMapping("findChildData/{id}")
    public Response findChildData(@PathVariable Long id) {
        List<Dict> list = dictService.findChildData(id);
        return Response.success(list);
    }

}
