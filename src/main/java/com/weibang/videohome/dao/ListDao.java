package com.weibang.videohome.dao;

import com.weibang.videohome.ban.VideoComment;
import com.weibang.videohome.ban.VideoList;
import com.weibang.videohome.ban.VideoSharelog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ListDao {
    @Select("select * from ims_video_list")
    List<VideoList> findAllVideo(int limit, int offset);
    @Select("select * from ims_video_list where id=#{vid}")
    VideoComment findByVid(int vid);
    @Update("update ims_video_list set viewnum=#{viewnum} where id =#{vid}")
    void updateViewNum(int viewnum,int vid);
    @Update("update ims_video_list set sharenum=#{sharenum} where id=#{vid}")
    void updateShareNum(int sharenum,int vid);
}
