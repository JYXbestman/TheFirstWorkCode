package com.weibang.videohome.service;

import com.weibang.videohome.ban.VideoComment;
import com.weibang.videohome.config.ApiPath;
import com.weibang.videohome.dao.CommentDao;
import com.weibang.videohome.exception.EntityErrorException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Log4j2
public class VideoCommentService {
    @Resource
    private CommentDao commentDao;

    public List findAllComment(int vid,int page, int size) {
        int offset = page <= 0 ? 0 : page * size;
        int limit = size <= 0 ? ApiPath.DEFAULT_PAGE_SIZE : size;
        List<VideoComment> allComment = commentDao.findAllComment(vid,limit, offset);
        return allComment;
    }

    public int deleteCommentByOpenId(int id, String openId) {
        VideoComment comment = commentDao.findById(id);
        if (comment == null) {
            throw new EntityErrorException("没有找到对应的评论");
        }
        if (!openId.equals(comment.getOpenid())) {
            throw new EntityErrorException("您只能删除自己的评论");
        }
        int i = commentDao.deleteCommentByOpenId(id);
        return i;
    }
    @Transactional(rollbackFor = Exception.class)
    public int addCommentToVideo(String openId,String content,String image,int vid){
        VideoComment comment = new VideoComment();
        comment.setOpenid(openId);
        comment.setCreatetime(System.currentTimeMillis() / 1000);
        comment.setContent(content);
        comment.setState(1);
        comment.setImg(image);
        comment.setVid(vid);
        int ret = commentDao.addComment(comment);
        if (ret <= 0) {
            throw new EntityErrorException("评论插入数据失败");
        }
        return ret;
    }

    public int deleteCommentByToopenid(int id, String toopenid) {
        VideoComment comment = commentDao.findById(id);
        if (comment == null) {
            throw new EntityErrorException("没有找到对应的评论");
        }
        if (!toopenid.equals(comment.getToopenid())) {
            throw new EntityErrorException("您只能删除自己的评论");
        }
        int i = commentDao.deleteCommentByToOpenId(id);
        return i;
    }
    }
//    @Transactional(rollbackFor = Exception.class)
//    public int addCommentToPeople(String openId,  String content, String image, int vid) {
////        if (openId != null) {
////            VideoComment comment = commentDao.findByOpenId(openId);
////            if (comment == null) {
////                throw new EntityNotFoundException("您要回复的评论不存在");
////            }
////            if (openId.equals(comment.getOpenid())) {
////                throw new EntityNotFoundException("不能回复自己的评论");
////            }
////        } else {
////            //添加评论
////            VideoComment comment = new VideoComment();
////            comment.setOpenid(openId);
////            comment.setCreatetime(System.currentTimeMillis() / 1000);
////            comment.setContent(content);
////            comment.setState(1);
////            comment.setToopenid(String.valueOf(Math.max(id, 0)));
////            comment.setImg(image);
////            comment.setVid(vid);
////            int ret = commentDao.addComment(comment);
////            if (ret <= 0) {
////                throw new EntityErrorException("评论插入数据失败");
////            }
////            return ret;
////        }
////    }


