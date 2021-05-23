package com.xyy.service;

import com.xyy.po.Category;

import java.util.List;


public interface MusicCategoryService {


    Integer findMusicCategoryIDbyName(String cname);

    List<Category> findMusicCategory();

    Integer insertCategory(Category category);

    int deleteCategorys(Integer [] cids);

    int updateMusicCategory(Category category);
}
