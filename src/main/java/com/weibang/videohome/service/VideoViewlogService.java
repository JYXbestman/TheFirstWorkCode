package com.weibang.videohome.service;

import com.weibang.videohome.ban.VideoComment;
import com.weibang.videohome.ban.VideoViewlog;
import com.weibang.videohome.dao.ListDao;
import com.weibang.videohome.dao.ViewlogDao;
import com.weibang.videohome.exception.EntityErrorException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
@Log4j2
public class VideoViewlogService {
    @Resource
    private ViewlogDao viewlogDao;
    @Resource
    private ListDao listDao;

    public  int findAllViewLog(int vid) {
        int allViewLog = viewlogDao.findAllViewLog(vid);
        return allViewLog;
    }
    public int addViewlog(int vid, String openId, int mastercode) {
        int i=0;
        if(vid!=0 && openId != null && mastercode !=0) {
            VideoViewlog videoViewlog = new VideoViewlog();
            videoViewlog.setAddtime(System.currentTimeMillis() / 1000);
            videoViewlog.setMastercode(mastercode);
            videoViewlog.setOpenid(openId);
            videoViewlog.setVid(vid);
             i = viewlogDao.addViewLog(videoViewlog);
            VideoComment byVid = listDao.findByVid(vid);
            if(byVid!=null){
                listDao.updateViewNum(viewlogDao.findAllViewLog(vid),vid);
            }else {
                throw new EntityErrorException("您浏览的视频不存在");
            }
        }else {
            throw new EntityErrorException("浏览记录插入数据失败");
        }
        if(i>=0){
            return i;
        }else {
            throw new EntityErrorException("浏览记录插入数据失败");
        }
    }
    
}
