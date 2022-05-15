package taobao.view;

import java.util.List;

import taobao.po.Comment;

public interface CommentView {

    public List<Comment> showCommentList(Integer userId);
    public void saveComment(Integer userId);
    public void updateComment(Integer userId);
    public void removeComment(Integer userId);
    public void ListCommentAll();
    public void ListComment();
}
