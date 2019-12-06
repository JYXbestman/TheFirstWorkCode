package com.weibang.videohome.dao;

import com.weibang.videohome.ban.VideoSharelog;
import com.weibang.videohome.provider.VideoCommentProvider;
import com.weibang.videohome.provider.VideoSharelogProvider;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SharelogDao {
    @Select("select count(*) from ims_video_sharelog where vid=#{vid} ")
    int findAllSharelog(int vid);
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @InsertProvider(type = VideoSharelogProvider.class, method = "save")
    int addSharelog(VideoSharelog videoSharelog);
}
