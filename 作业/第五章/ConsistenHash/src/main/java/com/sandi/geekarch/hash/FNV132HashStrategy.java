package com.sandi.geekarch.hash;

/**
 *   
 * FNV1_32_HASH 算法 实现</p>
 *
 * @author: 三帝（sandi@maihaoche.com）
 * @date: 2020/6/30 2:03 下午
 * @since V1.0
 *  
 */
public class FNV132HashStrategy implements HashStrategy {

    /**
     * 使用FNV1_32_HASH算法计算服务器的Hash值
     *
     * @param key
     * @return int
     */
    @Override
    public int hash(String key) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash ^ key.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }
}
