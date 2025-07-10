package com.sun.mianshi.blackfilter;

import cn.hutool.bloomfilter.BitMapBloomFilter;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.util.List;
import java.util.Map;

@Slf4j
public class BlackIpUtils {
    //使用布隆过滤器存储黑名单
    private static BitMapBloomFilter bitMapBloomFilter;
    //判断ip是否在黑名单中
    public static boolean isBlackIp(String ip) {
        return bitMapBloomFilter.contains(ip);
    }
    //重建ip黑名单
    public static void rebuildBlackIp(String configInfo) {
        //判断nacos配置中心中的配置configInfo是否为空
        if(StrUtil.isBlank(configInfo)){
            configInfo = "{}";
        }
        //configInfo是一个yaml的配置，解析nacos配置中心中yaml文件
        Yaml yaml = new Yaml();
        Map map = yaml.loadAs(configInfo, Map.class);
        List<String> blackIpList = (List<String>) map.get("blackIpList");//获取blackIpList配置项
        //加锁防止并发
        synchronized (BlackIpUtils.class) {
            if(CollUtil.isNotEmpty(blackIpList)){
                //注意构造参数的设置
                bitMapBloomFilter = new BitMapBloomFilter(958506);
                //将黑名单添加到布隆过滤器中
                for (String ip : blackIpList) {
                    bitMapBloomFilter.add(ip);
                }
            }else{
                bitMapBloomFilter = new BitMapBloomFilter(100);
            }
        }
    }
}
