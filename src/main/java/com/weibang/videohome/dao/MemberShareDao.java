package com.weibang.videohome.dao;

import com.weibang.videohome.ban.MemberShare;
import com.weibang.videohome.provider.MemberShareProvider;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MemberShareDao {
 @InsertProvider(type = MemberShareProvider.class,method = "save")
 public int addMemberShare(MemberShare memberShare);
@Select("select count(*) from ims_cyyourbest_membershare where openid=#{openid} and time=#{time}")
 int findOPenIdAndTime(String openId, int time);
@Update("update ims_cyyourbest_membershare set sharesum=#{sharesum}")
 void updateMenberShare(MemberShare memberShare);
}
