package com.weibang.videohome.dao;

import com.weibang.videohome.ban.VideoComment;
import com.weibang.videohome.provider.VideoCommentProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentDao {
    @Select("select * from ims_video_comment where vid=#{vid} order by id desc limit #{limit} offset #{offset}")
    List<VideoComment> findAllComment(int vid,int limit, int offset );

    @Delete("delete from ims_video_comment where id=#{id} or openid=#{openid}")
    int deleteCommentByOpenId(int id);

    @Delete("delete from ims_video_comment where id=#{id} or toopenid=#{id}")
    int deleteCommentByToOpenId(int id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @InsertProvider(type = VideoCommentProvider.class, method = "save")
    int addComment(VideoComment videoComment);

    @Select("select * from ims_video_comment where id = #{id}")
    VideoComment findById(int id);
    @Select("select * from ims_video_comment where openid=#{openid}")
    VideoComment findByOpenId(String openId);
}
