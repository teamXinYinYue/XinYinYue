package com.xyy.service.impl;

import com.xyy.dao.CommentMapper;
import com.xyy.po.Comment;
import com.xyy.po.CommentExample;
import com.xyy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<Comment> findCommentByMusic(Integer m_id) {
        CommentExample example = new CommentExample();
        example.createCriteria().andM_idEqualTo(m_id);
        return this.commentMapper.selectByExample(example);
    }

    @Override
    public List<Comment> findCommentByUid(Integer u_id) {
        CommentExample example = new CommentExample();
        example.createCriteria().andU_idEqualTo(u_id);
        return this.commentMapper.selectByExample(example);
    }

    @Override
    public int insertComment(Comment comment) {
        return this.commentMapper.insert(comment);
    }

    @Override
    public int deleteComments(List<Comment> comments) {
        for (Comment comment : comments){
            if(this.commentMapper.deleteByPrimaryKey(
                    comment.getId()
            )==0){
                throw new RuntimeException("未删除成功");
            }
        }
        return 1;
    }

    @Override
    public int updateComment(Comment comment) {
        CommentExample example = new CommentExample();
        example.createCriteria().andIdEqualTo(comment.getId());
        return this.commentMapper.updateByExample(comment,example);
    }
}
