package com.sandi.example.composite;

/**
 *   
 * <p>WINDOWS窗口 组件</p>
 *
 * @author: 三帝（sandi@maihaoche.com）
 * @date: 2020/6/15 12:14 上午
 * @since V1.0
 *  
 */
public class WinForm extends Container {

    public WinForm(String name) {
        super(name);
    }

    @Override
    public void printComponent() {
        System.out.println(String.format("print %s(%s)", this.getClass().getSimpleName(), this.getName()));
        super.printComponent();
    }
}
