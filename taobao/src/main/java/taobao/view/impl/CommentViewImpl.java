package taobao.view.impl;

import java.util.List;
import java.util.Scanner;

import taobao.dao.CommentDao;
import taobao.dao.impl.CommentDaoImpl;
import taobao.po.Comment;
import taobao.view.CommentView;

public class CommentViewImpl implements CommentView{

    private Scanner input = new Scanner(System.in);

    @Override
    public List<Comment> showCommentList(Integer userId) {
        CommentDao dao = new CommentDaoImpl();
        List<Comment> list = dao.listCommentByCommentId(userId);
        System.out.println("评论编号\t用户编号\t商品编号\t用户评论\t点赞数");
        for(Comment comment : list) {
            System.out.println(comment.getCommentId()+"\t"+comment.getUserId()+"\t"+comment.getGoodsId()+"\t"+comment.getUserComment()+"\t"+comment.getUserLike());
        }
        return list;
    }

    @Override
    public void saveComment(Integer userId) {
        Comment comment = new Comment();
        System.out.println("请输入商品编号：");
        comment.setGoodsId(input.nextInt());
        System.out.println("请输入评论：");
        comment.setUserComment(input.next());
        comment.setUserId(userId);

        CommentDao dao = new CommentDaoImpl();
        int result = dao.saveComment(comment);
        if(result>0) {
            System.out.println("\n新增评论成功！\n");
        }else {
            System.out.println("\n新增评论失败！\n");
        }
    }

    @Override
    public void updateComment(Integer userId) {
        CommentDao dao = new CommentDaoImpl();
        List<Comment> list = showCommentList(userId);

        if(list.size()==0) {
            System.out.println("没有任何评论！");
        }else {
            System.out.println("请选择要更新的评论编号：");
            int commentId = input.nextInt();
            Comment comment = dao.getCommentByUserId(commentId);
            System.out.println(comment);

            System.out.println("请更新评论:");
            comment.setUserComment(input.next());
            int result = dao.updateComment(comment);
            if(result>0) {
                System.out.println("\n修改评论成功！\n");
            }else {
                System.out.println("\n修改评论失败！\n");
            }
        }
    }

    @Override
    public void removeComment(Integer userId) {
        CommentDao dao = new CommentDaoImpl();
        List<Comment> list = showCommentList(userId);

        if(list.size()==0) {
            System.out.println("没有任何评论！");
        }else {
            System.out.println("请选择要删除的评论编号：");
            int commentId = input.nextInt();

            System.out.println("确认要删除吗(y/n)：");
            if(input.next().equals("y")) {
                int result = dao.removeComment(commentId);
                if(result>0) {
                    System.out.println("\n删除评论成功！\n");
                }else {
                    System.out.println("\n删除评论失败！\n");
                }
            }
        }
    }

    @Override
    public void ListCommentAll() {
        CommentDao dao = new CommentDaoImpl();
        List<Comment> list = dao.ListComment(null,null,null);
        System.out.println("评论编号\t用户编号\t商品编号\t用户评论\t点赞数");
        for(Comment c : list) {
            System.out.println(c.getCommentId()+"\t"+c.getUserId()+"\t"+c.getGoodsId()+"\t"+c.getUserComment()+"\t"+c.getUserLike());
        }
        Integer commentId =0;

        String inputStr = "";
        System.out.println("如果有喜欢的评论，点个赞吧(y/n)");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请选择点赞的评论编号：");
            commentId = input.nextInt();
        }
        int result = dao.addLike(commentId);
        if(result>0) {
            System.out.println("\n点赞成功！\n");
        }else {
            System.out.println("\n点赞失败！\n");
        }
    }

    @Override
    public void ListComment() {
        Integer commentId =0;
        Integer userId =0;
        String userComment="";

        String inputStr = "";
        System.out.println("是否需要输入评论编号(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入评论编号：");
            commentId = input.nextInt();
        }

        System.out.println("是否需要输入用户编号(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入用户编号：");
            userId = input.nextInt();
        }

        System.out.println("是否需要输入评论内容(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入评论内容：");
            userComment = input.next();
        }

        CommentDao dao = new CommentDaoImpl();
        List<Comment> list = dao.ListComment(commentId,userId,userComment);
        System.out.println("评论编号\t用户编号\t商品编号\t用户评论\t点赞数");
        for(Comment c : list) {
            System.out.println(c.getCommentId()+"\t"+c.getUserId()+"\t"+c.getGoodsId()+"\t"+c.getUserComment()+"\t"+c.getUserLike());
        }
    }
}