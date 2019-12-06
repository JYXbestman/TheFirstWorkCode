package com.weibang.videohome.controller;

import com.weibang.videohome.ban.VideoList;
import com.weibang.videohome.ban.base.MyResponseBody;
import com.weibang.videohome.service.VideoListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/video")
@Api(tags = "视频列表")
public class VideoListController {
    @Resource
    private VideoListService videoListService;
    @GetMapping("/list")
    @ApiOperation("查看所有视频")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "查看所有视频", name = "page,size", example = "0,10"),
    })
    public MyResponseBody<List<VideoList>> findAllVideo(@RequestParam  int page,@RequestParam int size) {
        List allComment = videoListService.findAllVideo(page, size);
        return MyResponseBody.success(allComment);
    }

}
