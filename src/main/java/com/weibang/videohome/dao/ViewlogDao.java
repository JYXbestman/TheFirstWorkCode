package com.weibang.videohome.dao;

import com.weibang.videohome.ban.VideoViewlog;
import com.weibang.videohome.provider.VideoSharelogProvider;
import com.weibang.videohome.provider.VideoViewlogProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ViewlogDao {
    @Select("select count(*) from ims_video_viewlog where vid=#{vid} ")
       int findAllViewLog(int vid);
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @InsertProvider(type = VideoViewlogProvider.class, method = "save")
    int addViewLog(VideoViewlog videoViewlog);
}
