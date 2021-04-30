package com.xyy.service;

import com.xyy.po.Category;
import com.xyy.po.Comment;

import java.util.List;


public interface MusicCategoryService {

    List<Category> findMusicCategory();

    int insertCategory(Category category);

    int deleteCategorys(List<Category> categorys);

    int updateMusicCategory(Category category);
}
