package com.weibang.videohome.service;

import com.weibang.videohome.ban.MemberShare;
import com.weibang.videohome.ban.VideoComment;
import com.weibang.videohome.ban.VideoSharelog;
import com.weibang.videohome.dao.ListDao;
import com.weibang.videohome.dao.MemberShareDao;
import com.weibang.videohome.dao.SharelogDao;
import com.weibang.videohome.exception.EntityErrorException;
import com.weibang.videohome.utils.DateTimeHelp;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Log4j2
public class VideoSharelogService {
    @Resource
    private SharelogDao sharelogDao;
    @Resource
    private MemberShareDao memberShareDao;
    @Resource
    private DateTimeHelp dateTimeHelp;
    @Resource
    private ListDao listDao;


    public int findAllSharelog(int vid) {
        return sharelogDao.findAllSharelog(vid);
    }

    public int addSharelog(int vid,String openId,int mastercode) {
        int i=0;
        if(vid!=0 && openId != null && mastercode !=0) {
            VideoSharelog videoSharelog = new VideoSharelog();
            videoSharelog.setAddtime(System.currentTimeMillis() / 1000);
            videoSharelog.setMastercode(mastercode);
            videoSharelog.setOpenid(openId);
            videoSharelog.setVid(vid);
            i =sharelogDao.addSharelog(videoSharelog);
            //用于同步到“分享记录的表以上线，所以先注释掉”
//            MemberShare memberShare = new MemberShare();
//            memberShare.setMastercode(mastercode);
//            memberShare.setOpenid(openId);
//            memberShare.setSharesum(sharelogDao.findAllSharelog(vid));
//            memberShare.setTime(Integer.parseInt(dateTimeHelp.getTodayStr()));
            int oPenIdAndTime = memberShareDao.findOPenIdAndTime(openId, Integer.parseInt(dateTimeHelp.getTodayStr()));
//            if(oPenIdAndTime==0){
//                memberShareDao.addMemberShare(memberShare);
//            }else {
//                memberShareDao.updateMenberShare(memberShare);
//            }
            VideoComment byVid = listDao.findByVid(vid);
            if(byVid!=null){
                listDao.updateShareNum(sharelogDao.findAllSharelog(vid),vid);
            }else {
                throw  new EntityErrorException("你分享的视频并不存在");
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
