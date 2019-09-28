package com.ssm.service;

import com.ssm.pojo.ChengJi;

/**
 * Created by 张齐 on 2019/9/25.
 */
public interface ChengJiService {
    ChengJi selectOne(int id);
    int deleteOne(int id);
    int updateOne(ChengJi chengJi);
}
