package taobao.dao;

import java.util.List;

import taobao.po.Business;
import taobao.po.Comment;


public interface CommentDao {


    public List<Comment> listCommentByCommentId(Integer commentId);
    public int saveComment(Comment comment);
    public Comment getCommentByUserId(Integer userId);
    public int updateComment(Comment comment);
    public int removeComment(Integer commentId);
    public int addLike(Integer commentId);
    public int deleteLike(Integer commentId);
    public List<Comment> ListComment(Integer commentId, Integer userId,String userComment);

}
