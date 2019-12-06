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
@ApiModel("分享量相关")
public class MemberShare {
    private long id;
    private int mastercode;
    private String openid;
    private int sharesum;
    private int time;
    private int status;
}
