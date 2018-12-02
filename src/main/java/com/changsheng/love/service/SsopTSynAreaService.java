package com.changsheng.love.service;

import com.changsheng.love.model.SsopTSynArea;
import com.changsheng.love.model.SysMenu;

import java.util.List;

public interface SsopTSynAreaService {
     List<SsopTSynArea> selectAll();

    List<SysMenu> selectMenuAll();
}
