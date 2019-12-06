package com.weibang.videohome;

import com.weibang.videohome.ban.VideoComment;
import com.weibang.videohome.service.*;
import com.weibang.videohome.utils.DateTimeHelp;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class VideoHomeTest {
    @Autowired
    private VideoCommentService videoCommentService;
    @Resource
    private VideoListService videoListService;
    @Resource
    private VideoSharelogService videoSharelogService;
    @Resource
    private DateTimeHelp dateTimeHelp;
    @Resource
    private VideoViewlogService videoViewlogService;
    @Resource
    private VideoLikeLogService videoLikeLogService;
    @Test
    public  void findAll(){
        int vid=3;
        int page=0;
        int size=-52;
        List allComment = videoCommentService.findAllComment(vid,page, size);
        System.out.println(allComment);
       log.info(allComment);
    }
    @Test
    public void delete(){
        int i = videoCommentService.deleteCommentByOpenId(7,"oMci5uHXGWYIpGqJdp28_oP8PMso");
        log.info(i);
    }
    @Test
    public void add(){
        VideoComment videoComment = new VideoComment();
        videoComment.setVid(1);
        videoComment.setContent("后台代码测试2");
        videoComment.setCreatetime(System.currentTimeMillis()/1000);
        int i = videoCommentService.addCommentToVideo(videoComment.getOpenid(), videoComment.getContent(), videoComment.getImg(), videoComment.getVid());
        log.info(i);
    }
    @Test
    public void findVideo(){
        List allVideo = videoListService.findAllVideo(0, 10);
        System.out.println(allVideo);
    }
    @Test
    public void findSharelog(){
        int allSharelog = videoSharelogService.findAllSharelog(1);
        System.out.println(allSharelog);
    }
    @Test
    public void findViewShok(){
        int allViewLog = videoViewlogService.findAllViewLog(1);
        System.out.println(allViewLog);
    }
    @Test
    public void addShareLog(){
        int oMci5uHXGWYIpGqJdp28_oP8PMso1111 = videoSharelogService.addSharelog(1, "oMci5uHXGWYIpGqJdp28_1111", 111111111);
        System.out.println(oMci5uHXGWYIpGqJdp28_oP8PMso1111);
    }
    @Test
    public void time(){
        String todayStr = dateTimeHelp.getTodayStr();
        System.out.println(todayStr);
        System.out.println(System.currentTimeMillis()/1000);
    }
    @Test
    public void addviewLog(){
        int oMci5uHXGWYIpGqJdp28_1111 = videoViewlogService.addViewlog(1, "oMci5uHXGWYIpGqJdp28_1111", 111111111);
        System.out.println(oMci5uHXGWYIpGqJdp28_1111);
    }
    @Test
    public void numTest(){
        int i=0;
        i++;
        System.out.println(i);
    }
    @Test
    public void timeTest() throws IllegalAccessException, InstantiationException {
        System.out.println(Integer.parseInt(DateTimeHelp.class.newInstance().getTodayStr()));
    }
    @Test
    public void setVideoLikeLog(){
        int allVideoLikeLog = videoLikeLogService.findAllVideoLikeLog(1);

            System.out.println(allVideoLikeLog);
        }
    }

