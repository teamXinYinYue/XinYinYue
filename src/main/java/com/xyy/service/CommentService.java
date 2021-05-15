package com.xyy.service;

import com.xyy.po.Comment;

import java.util.List;


public interface CommentService {
    List<Comment> findCommentByMusic(Integer m_id);

    List<Comment> findCommentByUid(Integer u_id);

    Integer insertComment(Comment comment);

    int deleteComments(Integer[] coids);

    int updateComment(Comment comment);

}
