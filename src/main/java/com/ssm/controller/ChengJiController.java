package com.ssm.controller;

import com.ssm.Common.Common;
import com.ssm.Common.RedisUtil;
import com.ssm.Common.SerializeUtil;
import com.ssm.pojo.ChengJi;
import com.ssm.service.ChengJiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;

/**
 * Created by 张齐 on 2019/9/25.
 */
@RestController
@RequestMapping("/ChengJi")
public class ChengJiController {
    @Autowired
    private ChengJiService chengJiService;

    @RequestMapping(value = "/selectOne",method = RequestMethod.POST)
    public Common selectOne(int id){
        //ChengJi chengJi = chengJiService.selectOne(id);
        Jedis jedis = RedisUtil.getJedis();
        //jedis.set("chengjidan".getBytes(), SerializeUtil.serialize(chengJi));
        ChengJi o = (ChengJi) SerializeUtil.unSerialize(jedis.get("chengjidan".getBytes()));
        //设置ip地址和端口
        /*Jedis jedis = new Jedis("127.0.0.1",6379);
        int id1 = chengJi.getId();
        String name = chengJi.getName();
        String kemu = chengJi.getKemu();
        int fenshu = chengJi.getFenshu();*/
       /* HashMap hashMap = new HashMap();
        hashMap.put("id",chengJi.getId());
        hashMap.put("name",chengJi.getName());
        hashMap.put("kemu",chengJi.getKemu());
        hashMap.put("fenshu",chengJi.getFenshu());*/
        //保存数据
        /*jedis.set("id","id1");
        jedis.set("name",name);
        jedis.set("kemu",kemu);
        jedis.set("fenshu",fenshu+"");*/
        //释放资源
        //jedis.close();
        return new Common(200,"aa",o);

    }
    @RequestMapping(value = "/deleteOne",method = RequestMethod.DELETE)
    public Common deleteOne(int id){
        int i = chengJiService.deleteOne(id);
        return new Common(200,"删除"+id+"号学生成功",i);

    }
    @RequestMapping(value = "/updateOne",method = RequestMethod.PUT)
    public Common deleteOne(ChengJi chengJi){
        Jedis jedis = RedisUtil.getJedis();
       //
        ChengJi o = (ChengJi) SerializeUtil.unSerialize(jedis.get("chengjidan".getBytes()));
        if (o != null) {
            int fenshu = o.getFenshu();
             int fenshu1=fenshu-1;
            o.setFenshu(fenshu1);
            jedis.set("chengjidan".getBytes(), SerializeUtil.serialize(o));
        }
        int i = chengJiService.updateOne(o);
        return new Common(200,"修改成功",i);

    }

}
