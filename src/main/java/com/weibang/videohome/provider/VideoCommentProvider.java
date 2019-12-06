package com.weibang.videohome.provider;

import com.weibang.videohome.ban.VideoComment;
import org.apache.ibatis.jdbc.SQL;

public class VideoCommentProvider {
    public String save(VideoComment videoComment) {
        return new SQL() {
            {
                INSERT_INTO("ims_video_comment");
                if (videoComment.getOpenid() != null) {
                    VALUES("openid", "#{openid}");
                }
                if (videoComment.getToopenid() != null) {
                    VALUES("toopenid", "#{toopenid}");
                }
                if (videoComment.getVid() != 0) {
                    VALUES("vid", "#{vid}");
                }
                VALUES("level", "#{level}");
                VALUES("content", "#{content}");
                if (videoComment.getImg() != null) {
                    VALUES("img", "#{img}");
                }
                if (videoComment.getCreatetime() != 0) {
                    VALUES("createtime", "#{createtime}");
                }
                if (videoComment.getState() != 0) {
                    VALUES("state", "#{state}");
                }
            }
        }.toString();
    }
}
