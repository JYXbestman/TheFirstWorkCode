package com.weibang.videohome.controller;

import com.weibang.videohome.ban.VideoSharelog;
import com.weibang.videohome.ban.base.MyResponseBody;
import com.weibang.videohome.service.VideoSharelogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/video")
@Api(tags = "视频分享")
public class VideoSharelogController {
    @Resource
    private VideoSharelogService videoSharelogService;
    @GetMapping("/sharelog/{vid}")
    @ApiOperation("查看视频分享量")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "查看该视频的分享量"),
    })
    public MyResponseBody<Integer>findAllSharelog(@PathVariable int vid){
        int allSharelog = videoSharelogService.findAllSharelog(vid);
        return MyResponseBody.success(allSharelog);
    }
    @PostMapping("/sharelog")
    @ApiOperation("添加视频分享量")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "该视频的分享量，添加"),
            @ApiImplicitParam(value = "视频的vid"),
            @ApiImplicitParam(value = "站点code"),
            @ApiImplicitParam(value = "openId"),
    })
    public MyResponseBody<VideoSharelog>addShareLog(@RequestParam int vid ,@RequestParam String openId,@RequestParam
                                                    int mastercode){
        int i = videoSharelogService.addSharelog(vid, openId, mastercode);
        if (i > 0) {
            return MyResponseBody.success("提交成功", null);

        } else {
            return MyResponseBody.error("提交失败", null);
        }
    }
}
