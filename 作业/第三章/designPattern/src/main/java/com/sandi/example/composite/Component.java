package com.sandi.example.composite;

import java.util.List;

/**
 *   
 * <p>组件抽象类</p>
 *
 * @author: 三帝（sandi@maihaoche.com）
 * @date: 2020/6/14 11:55 下午
 * @since V1.0
 *  
 */
public abstract class Component {
    /**
     * 组件名称
     */
    protected String name;

    protected String getName() {
        return name;
    }

    /**
     * 打印组件
     */
    public abstract void printComponent();

}
