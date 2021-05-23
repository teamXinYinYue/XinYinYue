package com.xyy.dao;

import com.xyy.po.Plmusic;
import com.xyy.po.PlmusicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlmusicMapper {
    long countByExample(PlmusicExample example);

    int deleteByExample(PlmusicExample example);

    int deleteByPrimaryKey(@Param("m_id") Integer m_id, @Param("u_id") Integer u_id, @Param("p_name") String p_name);

    int insert(Plmusic record);

    int insertSelective(Plmusic record);

    List<Plmusic> selectByExample(PlmusicExample example);

    int updateByExampleSelective(@Param("record") Plmusic record, @Param("example") PlmusicExample example);

    int updateByExample(@Param("record") Plmusic record, @Param("example") PlmusicExample example);
}