package com.sandi.geekarch.hash;

/**
 *   
 * <p>Hash Strategy接口</p>
 *
 * @author: 三帝（sandi@maihaoche.com）
 * @date: 2020/6/30 2:00 下午
 * @since V1.0
 *  
 */
public interface HashStrategy {
    /**
     * 计算Hash 值
     *
     * @param key
     * @return int
     */
    int hash(String key);
}
