package com.MusicShare.DAO;

import com.MusicShare.Model.Comment;

import java.util.List;

public interface CommentDAO {
    List<Comment> getCommentsByMusicId(int musicId); // 根据音乐ID获取评论
    boolean addComment(Comment comment);            // 添加评论
    boolean deleteComment(int commentId);           // 删除评论
    boolean updateComment(Comment comment);  // 更新评论内容
}
