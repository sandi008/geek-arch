package com.sandi.geekarch.hash;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 *   
 * <p>服务器节点</p>
 *
 * @author: 三帝（sandi@maihaoche.com）
 * @date: 2020/6/30 4:25 下午
 * @since V1.0
 *  
 */
@Data
public class Node<T> {
    private String nodeName;
    private String ip;
    private Map<String, T> data;

    public Node(String nodeName, String ip) {
        this.nodeName = nodeName;
        this.ip = ip;
        data = new HashMap<String, T>();
    }

    public void add(String key, T value) {
        data.put(key, value);
    }

    public void remove(String key) {
        data.remove(key);
    }

    public T get(String key) {
        return data.get(key);
    }
}
