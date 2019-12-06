package com.weibang.videohome.provider;

import com.weibang.videohome.ban.VideoSharelog;
import org.apache.ibatis.jdbc.SQL;

public class VideoSharelogProvider {
    public String save(VideoSharelog videoSharelog){
        return new SQL(){
            {
                INSERT_INTO("ims_video_sharelog");
                if (videoSharelog.getMastercode() != 0) {
                    VALUES("mastercode", "#{mastercode}");
                }
                VALUES("openid","#{openid}");
                if(videoSharelog.getSharenum()!=0){
                    VALUES("sharesum","#{sharesum}");
                }
                if(videoSharelog.getAddtime()!=0){
                    VALUES("addtime","#{addtime}");
                }
                    VALUES("status","#{status}");
                VALUES("vid","#{vid}");
            }
        }.toString();
    }
}
