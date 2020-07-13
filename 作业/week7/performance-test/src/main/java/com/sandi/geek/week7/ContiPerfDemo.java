package com.sandi.geek.week7;

import lombok.extern.slf4j.Slf4j;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;

import java.net.URL;
import java.net.URLConnection;

/**
 *   
 * <p>Contiperf 可以指定在线程数量和执行次数，通过限制最大时间和平均执行时间来进行效率测试</p>
 *
 * @author: 三帝（sandi@maihaoche.com）
 * @date: 2020/7/10 4:02 下午
 * @since V1.0
 *  
 */
@Slf4j
public class ContiPerfDemo {

    /**
     * 引入 ContiPerf 进行性能测试
     */
    @Rule
    public ContiPerfRule rule = new ContiPerfRule();

    /**
     * @PerfTest & @Required 注解可以放在类 面，代表类中所有方法共用配置
     * 主要参数介绍
     *   1）PerfTest参数
     *       @PerfTest(invocations = 300)：执行300次，和线程数量无关，默认值为1，表示执行1次；
     *       @PerfTest(threads=30)：并发执行30个线程，默认值为1个线程；
     *       @PerfTest(duration = 20000)：重复地执行测试至少执行20s。
     *   2）Required参数
     *       @Required(throughput = 20)：要求每秒至少执行20个测试；
     *       @Required(average = 50)：要求平均执行时间不超过50ms；
     *       @Required(median = 45)：要求所有执行的50%不超过45ms；
     *       @Required(max = 2000)：要求没有测试超过2s；
     *       @Required(totalTime = 5000)：要求总的执行时间不超过5s；
     *       @Required(percentile90 = 3000)：要求90%的测试不超过3s；
     *       @Required(percentile95 = 5000)：要求95%的测试不超过5s；
     *       @Required(percentile99 = 10000)：要求99%的测试不超过10s;
     *       @Required(percentiles = "66:200,96:500")：要求66%的测试不超过200ms，96%的测试不超过500ms。
     */
    @Test
//    @PerfTest(invocations = 1000, threads = 10)
    @PerfTest(invocations = 2000, threads = 10)
//    @Required(max = 1200, average = 250, totalTime = 60000)
    @Required(percentile95 = 5000,max = 10000)
    public void test() {
        try {
            connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void connect() throws Exception {
        final String urlStr = "https://www.baidu.com/";
        URL url = new URL(urlStr);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        urlConnection.connect();
        log.info(urlConnection.getInputStream().toString());
    }
}
