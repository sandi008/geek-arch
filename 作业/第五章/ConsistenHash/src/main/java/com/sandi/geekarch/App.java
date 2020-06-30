package com.sandi.geekarch;

import com.sandi.geekarch.hash.ConsistentHash;
import com.sandi.geekarch.hash.FNV132HashStrategy;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *   
 * 测试类</p>
 *
 * @author: 三帝（sandi@maihaoche.com）
 * @date: 2020/6/30 12:10 下午
 * @since V1.0
 *  
 */
@Slf4j
public class App {

    public static void main(String[] args) {
        int virtualNodes = 1024;
        List<String> servers = Arrays.asList("192.168.10.1",
                "192.168.10.2",
                "192.168.10.3",
                "192.168.10.4",
                "192.168.10.5",
                "192.168.10.6",
                "192.168.10.7",
                "192.168.10.8",
                "192.168.10.9",
                "192.168.10.10");

        ConsistentHash consistentHash = new ConsistentHash(servers, virtualNodes, new FNV132HashStrategy());

        log.info("begin add data from 0 —— 1000000 >>>");
        for (int i = 0; i < 10000000; i++) {
            consistentHash.put(i + "", i);
        }
        log.info("end add data <<<");

        consistentHash.statistics();
    }
}
