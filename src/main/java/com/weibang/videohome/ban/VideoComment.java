package com.weibang.videohome.ban;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("视频评论相关模块")
public class VideoComment {
    private int id;
    private String openid;
    private String toopenid;
    private int vid;
    private int level;
    private String content;
    private String img;
    private long createtime;
    private int state;

}
