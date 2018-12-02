package com.changsheng.love.service.impl;

import com.changsheng.love.dao.pg.SsopTSynAreaMapper;
import com.changsheng.love.dao.sqlite.SysMenuMapper;
import com.changsheng.love.model.SsopTSynArea;
import com.changsheng.love.model.SysMenu;
import com.changsheng.love.service.SsopTSynAreaService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class SsopTSynAreaServiceImpl implements SsopTSynAreaService {
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SsopTSynAreaMapper mapper;

    @Override
    public List<SsopTSynArea> selectAll(){
        return mapper.selectAll();
    }
    @Override
    public List<SysMenu> selectMenuAll(){
        return sysMenuMapper.selectAll();
    }

}
