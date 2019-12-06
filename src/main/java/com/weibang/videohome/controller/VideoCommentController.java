package com.weibang.videohome.controller;


import com.weibang.videohome.ban.VideoComment;
import com.weibang.videohome.ban.base.MyResponseBody;
import com.weibang.videohome.service.VideoCommentService;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/video")
@Api(tags = "一个视频对应的评论列表")
public class VideoCommentController {
    @Resource
    private VideoCommentService videoCommentService;
    @GetMapping("/comment/{vid}")
    @ApiOperation("查看评论")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "查看评论rest风格提交并接受该视频的vid", name = "page,size", example = "0,10"),
    })
    public MyResponseBody<List<VideoComment>> findAllComment(@PathVariable int vid, @RequestParam(required = false, defaultValue = "0") int page,
                                                             @RequestParam(required = false, defaultValue = "10") int size) {
        List allComment = videoCommentService.findAllComment(vid,page,size);
        return MyResponseBody.success(allComment);
    }
    @GetMapping("comment/delete")
    @ApiOperation("删除评论")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "需要删除的评论的id", name = "id", example = "1"),
    })
    public MyResponseBody<String> deleteComment(@RequestParam int id ,@RequestParam String openId) {
        int i = videoCommentService.deleteCommentByOpenId(id,openId);
        if (i > 0) {
            return MyResponseBody.success("删除成功", null);
        } else {
            return MyResponseBody.error("删除失败", null);
        }
    }
    @GetMapping("commment/deleteTo")
    @ApiOperation("删除给别人的评论")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "需要删除的评论的Id",name = "id",example = "1"),
    })
    public MyResponseBody<String> deleteCommentTo(@RequestParam int id,@RequestParam String toopenid){
        int i = videoCommentService.deleteCommentByToopenid(id, toopenid);
        if (i > 0) {
            return MyResponseBody.success("删除成功", null);
        } else {
            return MyResponseBody.error("删除失败", null);
        }
    }
    @PostMapping("comment/commit")
    @ApiOperation("给视频评论")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "评论的内容", name = "content", example = "这是我评论的内容"),
            @ApiImplicitParam(value = "评论的图片", name = "image"),
    })
    public MyResponseBody<String> commitComment(
            @RequestParam int vid,
            @RequestParam String content,
            @RequestParam String openId,
            @RequestParam(required = false) String image
    ) {
        int i = videoCommentService.addCommentToVideo(openId, content, image,vid);
        if (i > 0) {
            return MyResponseBody.success("提交成功", null);
        } else {
            return MyResponseBody.error("提交失败", null);
        }
    }

}
