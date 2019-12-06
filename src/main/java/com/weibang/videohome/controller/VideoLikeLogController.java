package com.weibang.videohome.controller;

import com.weibang.videohome.ban.base.MyResponseBody;
import com.weibang.videohome.service.VideoLikeLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/likeLog")
@Api(tags = "收藏")
public class VideoLikeLogController {
    @Resource
    private VideoLikeLogService videoLikeLogService;
    @PostMapping
    @ApiOperation("新添收藏")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "新添收藏"),
    })
    public MyResponseBody<String> addLikeLog(@RequestParam int vid,@RequestParam int mastercode,@RequestParam String openid){
        int i = videoLikeLogService.addLikeLog(vid, mastercode, openid);
        if (i > 0) {
            return MyResponseBody.success("提交成功", null);
        } else {
            return MyResponseBody.error("提交失败", null);
        }
    }
    @GetMapping("/video/{vid}")
    @ApiOperation("查看该视频的收藏量")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "查看该视频的藏量"),
    })
    public MyResponseBody<Integer> findAllLikeLog(@PathVariable int vid){
        int allVideoLikeLog = videoLikeLogService.findAllVideoLikeLog(vid);
        return MyResponseBody.success(allVideoLikeLog);
    }
}
