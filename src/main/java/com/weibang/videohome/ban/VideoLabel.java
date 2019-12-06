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
@ApiModel("视频状态相关模块")
public class VideoLabel {
    private int id;
    private int vid;
    private int lab_id;
    private int status;
}
