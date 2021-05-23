package com.xyy.dao;

import com.xyy.po.Playlist;
import com.xyy.po.PlaylistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistMapper {
    long countByExample(PlaylistExample example);

    int deleteByExample(PlaylistExample example);

    int deleteByPrimaryKey(@Param("p_name") String p_name, @Param("u_id") Integer u_id);

    int insert(Playlist record);

    int insertSelective(Playlist record);

    List<Playlist> selectByExample(PlaylistExample example);

    Playlist selectByPrimaryKey(@Param("p_name") String p_name, @Param("u_id") Integer u_id);

    int updateByExampleSelective(@Param("record") Playlist record, @Param("example") PlaylistExample example);

    int updateByExample(@Param("record") Playlist record, @Param("example") PlaylistExample example);

    int updateByPrimaryKeySelective(Playlist record);

    int updateByPrimaryKey(Playlist record);
}