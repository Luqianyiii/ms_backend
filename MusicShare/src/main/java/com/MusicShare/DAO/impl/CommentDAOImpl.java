package com.MusicShare.DAO.impl;

import com.MusicShare.DAO.CommentDAO;
import com.MusicShare.Model.Comment;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CommentDAOImpl implements CommentDAO {
    private SqlSession sqlSession;

    @Override
    public List<Comment> getCommentsByMusicId(int musicId) {
        CommentDAO commentDAO = sqlSession.getMapper(CommentDAO.class);
        return commentDAO.getCommentsByMusicId(musicId);
    }


    @Override
    public boolean addComment(Comment comment) {
        int rows = sqlSession.insert("CommentMapper.addComment", comment);
        return rows > 0;
    }

    @Override
    public boolean deleteComment(int commentId) {
        int rows = sqlSession.delete("CommentMapper.deleteComment", commentId);
        return rows > 0;
    }

    @Override
    public boolean updateComment(Comment comment) {
        int rows = sqlSession.update("CommentMapper.updateComment", comment);
        return rows > 0;
    }
}
