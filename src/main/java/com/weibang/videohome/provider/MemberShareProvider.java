package com.weibang.videohome.provider;

import com.weibang.videohome.ban.MemberShare;
import org.apache.ibatis.jdbc.SQL;

public class MemberShareProvider {
    public String save(MemberShare memberShare){
        return new SQL(){
            {
                INSERT_INTO("ims_cyyourbest_membershare");
                VALUES("mastercode","#{mastercode}");
                VALUES("openid","#{openid}");
                VALUES("sharesum","#{sharesum}");
                VALUES("time","#{time}");
                VALUES("status","#{status}");
            }
        }.toString();
    }
}
