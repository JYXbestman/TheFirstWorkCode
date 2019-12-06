package com.weibang.videohome.ban;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel("视频展示模块")
public class VideoLikeLog {
    private long id;
    private int vid;
    private int mastercode;
    private String openid;
    private long addtime;
    private int status;
}
