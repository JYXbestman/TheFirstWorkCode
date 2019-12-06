package com.weibang.videohome.provider;

import com.weibang.videohome.ban.VideoLikeLog;
import org.apache.ibatis.jdbc.SQL;

public class VideoLikeLogProvider {
    public String save(VideoLikeLog videoLikeLog){
        return new SQL(){
            {
                INSERT_INTO("ims_video_likelog");
                VALUES("vid","#{vid}");
                VALUES("mastercode","#{mastercode}");
                VALUES("openid","#{openid}");
                VALUES("addtime","#{addtime}");
            }
        }.toString();
    }
}
