package taobao.po;

public class Comment {

    private Integer commentId;
    private Integer userId;
    private Integer goodsId;
    private String userComment;
    private Integer userLike;


    @Override
    public String toString() {
        return "\n评论编号："+this.commentId+
                "\n用户编号："+this.userId+
                "\n商品编号："+this.goodsId+
                "\n用户评论："+this.userComment+
                "\n用户点赞数："+this.userLike;

    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public Integer getUserLike() {
        return userLike;
    }

    public void setUserLike(Integer userLike) {
        this.userLike = userLike;
    }
}
