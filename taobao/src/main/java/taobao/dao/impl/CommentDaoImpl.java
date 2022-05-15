package taobao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import taobao.dao.CommentDao;
import taobao.po.Business;
import taobao.po.Comment;
import taobao.util.DBUtil;

public class CommentDaoImpl implements CommentDao {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public List<Comment> listCommentByCommentId(Integer commentId) {
        List<Comment> list = new ArrayList<>();
        String sql = "select * from comment where commentId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, commentId);
            rs = pst.executeQuery();
            while(rs.next()) {
                Comment comment = new Comment();
                comment.setCommentId(rs.getInt("commentId"));
                comment.setUserId(rs.getInt("userId"));
                comment.setGoodsId(rs.getInt("goodsId"));
                comment.setUserComment(rs.getString("userComment"));
                comment.setUserLike(rs.getInt("userLike"));
                list.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return list;
    }

    @Override
    public int saveComment(Comment comment) {
        int result = 0;
        String sql = "insert into comment values(null,?,?,?,0)";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, comment.getUserId());
            pst.setInt(2, comment.getGoodsId());
            pst.setString(3, comment.getUserComment());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pst, con);
        }
        return result;
    }

    @Override
    public Comment getCommentByUserId(Integer commentId) {
        Comment comment = null;
        String sql = "select * from comment where commentId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, commentId);
            rs = pst.executeQuery();
            while(rs.next()) {
                comment = new Comment();
                comment.setCommentId(rs.getInt("commentId"));
                comment.setUserId(rs.getInt("userId"));
                comment.setGoodsId(rs.getInt("goodsId"));
                comment.setUserComment(rs.getString("userComment"));
                comment.setUserLike(rs.getInt("userLike"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return comment;
    }

    @Override
    public int updateComment(Comment comment) {
        int result = 0;
        String sql = "update comment set userId=?,goodsId=?,userComment=? where commentId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, comment.getUserId());
            pst.setInt(2, comment.getGoodsId());
            pst.setString(3, comment.getUserComment());
            pst.setInt(4, comment.getCommentId());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pst, con);
        }
        return result;
    }

    @Override
    public int removeComment(Integer commentId) {
        int result = 0;
        String sql = "delete from comment where commentId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, commentId);
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pst, con);
        }
        return result;
    }

    @Override
    public int addLike(Integer commentId) {
        int result = 0;
        String sql = "update comment set userLike=userLike+1 where commentId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, commentId);
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pst, con);
        }
        return result;
    }

    @Override
    public int deleteLike(Integer commentId) {
        int result = 0;
        String sql = "update comment set userLike=0 where commentId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, commentId);
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pst, con);
        }
        return result;
    }

    @Override
    public List<Comment> ListComment(Integer commentId, Integer userId,String userComment) {
        List<Comment> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from comment where 1=1 ");
        if(commentId!=null&&commentId!=0) {
            sql.append(" and commentId = "+commentId);
        }
        if(userId!=null&&userId!=0) {
            sql.append(" and userId ='"+userId+"'");
        }if(userComment!=null&&!userComment.equals("")) {
            sql.append(" and userComment like '%"+userComment+"%'");
        }
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql.toString());
            rs = pst.executeQuery();
            while(rs.next()) {
                Comment comment = new Comment();
                comment.setCommentId(rs.getInt("commentId"));
                comment.setUserId(rs.getInt("userId"));
                comment.setGoodsId(rs.getInt("goodsId"));
                comment.setUserComment(rs.getString("userComment"));
                comment.setUserLike(rs.getInt("userLike"));

                list.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return list;
    }
}

