package com.xyy.service.impl;

import com.xyy.dao.PlmusicMapper;
import com.xyy.po.Plmusic;
import com.xyy.po.PlmusicExample;
import com.xyy.service.PlmusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("plmusicService")
public class PlmusicServiceImpl implements PlmusicService {

    @Autowired
    private PlmusicMapper plmusicMapper;

    @Override
    public int insertPlmusic(List<Plmusic> plmusics) {
        for (Plmusic plmusic : plmusics){
            System.out.println(plmusic.getU_id());
            if(this.plmusicMapper.insert(plmusic)==0){
                throw new RuntimeException("未添加成功");
            }
        }
        return 1;
    }

    @Override
    public int deletePlmusic(List<Plmusic> plmusics) {
        for (Plmusic plmusic : plmusics){
            if(this.plmusicMapper.deleteByPrimaryKey(plmusic.getM_id()
                    ,plmusic.getU_id()
                    ,plmusic.getP_name()
            )==0){
                throw new RuntimeException("未删除成功");
            }
        }
        return 1;
    }


    @Override
    public List<Plmusic> findPlmusic(Integer u_id,String p_name) {

        PlmusicExample example = new PlmusicExample();
        example.createCriteria().andU_idEqualTo(u_id).andP_nameEqualTo(p_name);
        return this.plmusicMapper.selectByExample(example);
    }
}
