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
public class VideoList {
    private int id;
    private String title;
    private String videourl;
    private String thumb;
    private String source;
    private long createtime;
    private int sharenum;
    private int viewnum;
}
