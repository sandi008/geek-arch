package com.sandi.example.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *   
 * <p>容器抽象类：特殊的组件，可以包含其它组件的组件</p>
 *
 * @author: 三帝（sandi@maihaoche.com）
 * @date: 2020/6/15 4:25 下午
 * @since V1.0
 *  
 */
public abstract class Container extends Component {
    protected List<Component> componentList;

    public Container(String name) {
        this.name = name;
        this.componentList = new ArrayList<>();
    }

    /**
     * 添加组件
     *
     * @param component
     */
    public void addComponent(Component component) {
        this.componentList.add(component);
    }

    /**
     * 移除组件
     *
     * @param component
     */
    public void removeComponent(Component component) {
        this.componentList.remove(component);
    }

    @Override
    public void printComponent() {
        componentList.forEach(Component::printComponent);
    }
}
