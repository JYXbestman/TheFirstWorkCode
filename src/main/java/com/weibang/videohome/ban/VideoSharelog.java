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
@ApiModel("视频分享模块")
public class VideoSharelog {
    private long id;
    private int vid;
    private int mastercode;
    private String openid;
    private int sharenum;
    private long addtime;
    private int status;

}
