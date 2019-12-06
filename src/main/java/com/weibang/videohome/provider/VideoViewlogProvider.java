package com.weibang.videohome.provider;

import com.weibang.videohome.ban.VideoViewlog;
import org.apache.ibatis.jdbc.SQL;

public class VideoViewlogProvider {
    public String save(VideoViewlog videoViewlog){
        return new SQL(){
            {
                INSERT_INTO("ims_video_viewlog");
                if (videoViewlog.getMastercode() != 0) {
                    VALUES("mastercode", "#{mastercode}");
                }
                VALUES("openid","#{openid}");
                    VALUES("viewsum","#{viewsum}");
                if(videoViewlog.getAddtime()!=0){
                    VALUES("addtime","#{addtime}");
                }
                if(videoViewlog.getStatus()!=0){
                    VALUES("status","#{status}");
                }
              VALUES("vid","#{vid}");
            }
        }.toString();
    }
}
