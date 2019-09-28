package com.ssm.Common;

import com.ssm.service.ChengJiService;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import java.util.HashMap;

/**
 * Created by 张齐 on 2019/9/26.
 */
public class RedisTest {
    public static void main(String[] args) {

           //设置ip地址和端口
        Jedis jedis = new Jedis("127.0.0.1",6379);
        /*HashMap hashMap = new HashMap();
        hashMap.put("id",chengJi.getId());
        hashMap.put("name",chengJi.getName());
        hashMap.put("kemu",chengJi.getKemu());
        hashMap.put("fenshu",chengJi.getFenshu());*/
        //保存数据
        jedis.set("chengji","100");
        //获得数据
        String chengji = jedis.get("chengji");
        System.out.println(chengji);
        //释放资源
        jedis.close();
    }
}
