package com.linglan.syt.cmn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.linglan.syt.model.cmn.Dict;

import java.util.List;

public interface DictService extends IService<Dict> {

    List<Dict> findChildData(Long id);
}
