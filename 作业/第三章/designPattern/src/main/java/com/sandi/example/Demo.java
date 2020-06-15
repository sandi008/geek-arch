package com.sandi.example;

import com.sandi.example.composite.*;

/**
 *   
 * <p>示例测试类</p>
 *
 * @author: 三帝（sandi@maihaoche.com）
 * @date: 2020/6/15 12:33 上午
 * @since V1.0
 *  
 */
public class Demo {
    public static void main(String[] args) {
        Container winForm = new WinForm("WINDOWS窗口");
        Component picture = new Picture("LOGO图片");
        Component btn1 = new Button("登录");
        Component btn2 = new Button("注册");

        winForm.addComponent(picture);
        winForm.addComponent(btn1);
        winForm.addComponent(btn2);

        Container frame = new Frame("FRAME1");
        Component lable1 = new Lable("用户名");
        Component textBox1 = new TextBox("文本框");
        Component lable2 = new Lable("密码");
        Component passwordBox = new PasswordBox("密码框");
        Component checkBox = new CheckBox("复选框");
        Component textBox2 = new TextBox("记住用户名");
        Component linkLable = new LinkLable("忘记密码");

        frame.addComponent(lable1);
        frame.addComponent(textBox1);
        frame.addComponent(lable2);
        frame.addComponent(passwordBox);
        frame.addComponent(checkBox);
        frame.addComponent(textBox2);
        frame.addComponent(linkLable);

        winForm.addComponent(frame);

        winForm.printComponent();
    }
}
