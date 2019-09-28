package com.ssm.service.impl;

import com.ssm.dao.ChengJiDao;
import com.ssm.pojo.ChengJi;
import com.ssm.service.ChengJiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 张齐 on 2019/9/25.
 */
@Service
public class CHnegJiServiceImpl implements ChengJiService {
    @Autowired
    private ChengJiDao chengJiDao;
    @Override
    public ChengJi selectOne(int id) {
        ChengJi chengJi = chengJiDao.selectOne(id);
        return chengJi;
    }

    @Override
    public int deleteOne(int id) {
        int i = chengJiDao.deleteOne(id);
        return i;
    }

    @Override
    public int updateOne(ChengJi chengJi) {
        int i = chengJiDao.updateOne(chengJi);
        return i;
    }
}
