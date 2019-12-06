package com.weibang.videohome.service;

import com.weibang.videohome.ban.VideoLikeLog;
import com.weibang.videohome.dao.LikeLogDao;
import com.weibang.videohome.exception.EntityErrorException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VideoLikeLogService {
    @Resource
    private LikeLogDao likeLogDao;

    public int  addLikeLog(int vid, int mastercode, String openid) {
        VideoLikeLog videoLikeLog = new VideoLikeLog();
        if(vid !=0 && mastercode!=0&&openid!=null) {
            videoLikeLog.setAddtime(System.currentTimeMillis() / 1000);
            videoLikeLog.setMastercode(mastercode);
            videoLikeLog.setOpenid(openid);
            videoLikeLog.setVid(vid);
        }else {
            throw new EntityErrorException("缺少vid,或者mastercode，或者openid");
        }
        int i = likeLogDao.addLikeLog(videoLikeLog);
        if (i <= 0) {
            throw new EntityErrorException("收藏失败");
        }
            return i;
    }

    public int findAllVideoLikeLog(int vid) {
       return likeLogDao.findAllLikeLog(vid);
    }
}

