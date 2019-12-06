package com.weibang.videohome.dao;

import com.weibang.videohome.ban.VideoLikeLog;
import com.weibang.videohome.provider.VideoLikeLogProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LikeLogDao {
    @InsertProvider(type = VideoLikeLogProvider.class,method = "save")
    int addLikeLog(VideoLikeLog videoLikeLog);
@Select("select count(*) from ims_video_likelog where vid =#{vid}")
    int findAllLikeLog(int vid);

}
