package com.sandi.geekarch.util;

import java.util.List;

/**
 *   
 * <p>计算工具类</p>
 *
 * @author: 三帝（sandi@maihaoche.com）
 * @date: 2020/6/30 2:38 下午
 * @since V1.0
 *  
 */
public class MathUtil {
    /**
     * 计算方差
     * 方差s^2=[(x1-x)^2 +...(xn-x)^2]/n 或者s^2=[(x1-x)^2 +...(xn-x)^2]/(n-1)
     *
     * @param x
     * @return
     */
    public static double variance(double[] x) {
        int m=x.length;
        double sum=0;
        //求和
        for(int i=0;i<m;i++){
            sum+=x[i];
        }
        //求平均值
        double dAve=sum/m;
        double dVar=0;
        //求方差
        for(int i=0;i<m;i++){
            dVar+=(x[i]-dAve)*(x[i]-dAve);
        }
        return dVar/m;
    }

    /**
     * 计算标准差
     * 标准差σ=sqrt(s^2)
     *
     * @param x
     * @return
     */
    public static double standardDiviation(double[] x) {
        int m=x.length;
        double sum=0;
        //求和
        for(int i=0;i<m;i++){
            sum+=x[i];
        }
        //求平均值
        double dAve=sum/m;
        double dVar=0;
        //求方差
        for(int i=0;i<m;i++){
            dVar+=(x[i]-dAve)*(x[i]-dAve);
        }
        return Math.sqrt(dVar/m);
    }

}
