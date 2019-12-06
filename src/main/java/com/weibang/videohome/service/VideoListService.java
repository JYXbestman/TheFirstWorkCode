package com.weibang.videohome.service;



import com.weibang.videohome.ban.VideoComment;
import com.weibang.videohome.ban.VideoList;
import com.weibang.videohome.config.ApiPath;
import com.weibang.videohome.dao.ListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VideoListService {
@Autowired
private ListDao listDao;
    public List findAllVideo(int page, int size) {
        int offset = page <= 0 ? 0 : page * size;
        int limit = size <= 0 ? ApiPath.DEFAULT_PAGE_SIZE : size;
        List<VideoList> allList = listDao.findAllVideo(limit, offset);
        return allList;
    }

}

