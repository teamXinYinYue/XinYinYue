package com.xyy.service;

import com.xyy.po.Category;
import com.xyy.po.Comment;

import java.util.List;


public interface MusicCategoryService {

    String findMusicCategoryNamebyID(Integer cid);

    int findMusicCategoryIDbyname(String cname);

    List<Category> findMusicCategory();

    int insertCategory(Category category);

    int deleteCategorys(Integer [] cids);

    int updateMusicCategory(Category category);
}
