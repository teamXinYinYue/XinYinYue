package com.xyy.service;

import com.xyy.po.Comment;

import java.util.List;
import java.util.Set;


public interface CommentService {
    List<Comment> findCommentByMusic(Integer m_id);

    List<Comment> findCommentByUid(Integer u_id);

    int insertComment(Comment comment);

    int deleteComments(Integer[] coids);

    int updateComment(Comment comment);

}
