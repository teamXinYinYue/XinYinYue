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
    public List<Category> findMusicCategory() {
        CategoryExample example = new CategoryExample();
        example.createCriteria().andCa_idIsNotNull();
        return this.categoryMapper.selectByExample(example);
    }

    @Override
    public int insertCategory(Category category) {
        return this.categoryMapper.insert(category);
    }


    @Override
    public int deleteCategorys(List<Category> categorys) {
        for (Category category : categorys){
            if(this.categoryMapper.deleteByPrimaryKey(
                    category.getCa_id()
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
