package com.sandi.example.composite;

/**
 *   
 * <p>Lable 组件</p>
 *
 * @author: 三帝（sandi@maihaoche.com）
 * @date: 2020/6/15 12:41 上午
 * @since V1.0
 *  
 */
public class Lable extends Component {

    public Lable(String name) {
        this.name = name;
    }

    @Override
    public void printComponent() {
        System.out.println(String.format("print %s(%s)", this.getClass().getSimpleName(), this.getName()));
    }
}
