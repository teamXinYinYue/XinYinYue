package com.xyy.service.impl;

import com.xyy.dao.CategoryMapper;
import com.xyy.po.Category;
import com.xyy.po.CategoryExample;
import com.xyy.service.MusicCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("musicCategoryService")
public class MusicCategoryServiceImpl implements MusicCategoryService {
    @Autowired
    private CategoryMapper categoryMapper;




    @Override
    public Integer findMusicCategoryIDbyName(String cname) {
        CategoryExample example = new CategoryExample();
        example.createCriteria().andCa_nameLike('%'+cname+'%');
        List<Category> categoryList= this.categoryMapper.selectByExample(example);
        for(Category category:categoryList){
            return category.getCa_id();
        }
        return 0;
    }

    @Override
    public List<Category> findMusicCategory() {
        CategoryExample example = new CategoryExample();
        example.createCriteria().andCa_idIsNotNull();
        return this.categoryMapper.selectByExample(example);
    }

    @Override
    public Integer insertCategory(Category category) {
        this.categoryMapper.insertSelective(category);
        return category.getCa_id();
    }


    @Override
    public int deleteCategorys(Integer [] cids) {
        for (Integer cid : cids){
            if(this.categoryMapper.deleteByPrimaryKey(
                    cid
            )==0){
                throw new RuntimeException("未删除成功");
            }
        }
        return 1;
    }

    @Override
    public int updateMusicCategory(Category category) {
        CategoryExample example = new CategoryExample();
        example.createCriteria().andCa_idEqualTo(category.getCa_id());
        return this.categoryMapper.updateByExample(category,example);
    }
}
