package com.weibang.videohome.controller;


import com.weibang.videohome.ban.VideoViewlog;
import com.weibang.videohome.ban.base.MyResponseBody;
import com.weibang.videohome.service.VideoViewlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/video")
@Api(tags = "视频浏览")
public class VideoViewlogController {
    @Resource
    private VideoViewlogService videoViewlogService;
    @GetMapping("/viewlog/{vid}")
    @ApiOperation("查看视频浏览量")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "查看该视频的浏览量"),
    })
    public MyResponseBody<Integer> findAllViewLog(@PathVariable int vid){
        int allViewLog = videoViewlogService.findAllViewLog(vid);
        return MyResponseBody.success(allViewLog);
    }
    @PostMapping("/viewlog")
    @ApiOperation("添加视频浏览量")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "该视频的浏览量，添加"),
            @ApiImplicitParam(value = "视频的vid"),
            @ApiImplicitParam(value = "站点code"),
            @ApiImplicitParam(value = "openId"),
    })
    public MyResponseBody<VideoViewlog>addShareLog(@RequestParam int vid , @RequestParam String openId, @RequestParam
            int mastercode){
        int i = videoViewlogService.addViewlog(vid, openId, mastercode);
        if (i > 0) {
            return MyResponseBody.success("提交成功", null);
        } else {
            return MyResponseBody.error("提交失败", null);
        }
    }
}
