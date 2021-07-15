package com.coding.common;

import org.junit.Test;

import static org.junit.Assert.*;

public class LedOrderUtilTest {

    @Test
    public void colorOrder() {
        System.out.println(LedOrderUtil.colorOrder("#ff00ee"));
    }

    @Test
    public void waveOrder() {
        System.out.printf("设置功率:%s\n", LedOrderUtil.powerOrder(30));
        System.out.printf("生成波长设置命令:%s\n", LedOrderUtil.waveOrder(476));
        LedOrderUtil.MyTimeParam work = new LedOrderUtil.MyTimeParam(99,59,59,33);
        System.out.printf("设置工作时长命令:%s\n", LedOrderUtil.workOrder(work));
        System.out.printf("设置休息时长命令:%s\n", LedOrderUtil.restOrder(work));
        System.out.printf("设置循环次数:%s\n", LedOrderUtil.loopOrder(5));
        System.out.printf("设置启动命令:%s\n", LedOrderUtil.startOrder());
        System.out.printf("设置停止命令:%s\n", LedOrderUtil.stopOrder());
        System.out.printf("设置暂停命令:%s\n", LedOrderUtil.reseOrder());
        System.out.printf("修改波特率命令1:%s\n", LedOrderUtil.baudOrder(1));
        System.out.printf("修改波特率命令2:%s\n", LedOrderUtil.baudOrder(2));
        System.out.printf("修改波特率命令3:%s\n", LedOrderUtil.baudOrder(3));
    }
}
