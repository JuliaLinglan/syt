package com.linglan.syt.cmn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linglan.syt.cmn.mapper.DictMapper;
import com.linglan.syt.cmn.service.DictService;

import com.linglan.syt.model.cmn.Dict;
import org.springframework.stereotype.Service;

@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {
}
