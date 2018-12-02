package com.changsheng.love.dao.pg;

import com.changsheng.love.model.SsopTSynArea;

import java.util.List;
public interface SsopTSynAreaMapper {
    int deleteByPrimaryKey(String code);

    int insert(SsopTSynArea record);

    int insertSelective(SsopTSynArea record);

    SsopTSynArea selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(SsopTSynArea record);

    int updateByPrimaryKey(SsopTSynArea record);
    List<SsopTSynArea> selectAll();
}