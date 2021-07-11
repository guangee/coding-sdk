package com.coding.common;

import lombok.Data;

@Data
public class LedOrderUtil {


    /**
     * 生成功率设置命令
     *
     * @param power 功率 0～100
     * @return 功率命令
     */
    public static String powerOrder(int power) {
        return String.format("power_%s#", toHexString(power));
    }


    /**
     * 生成颜色设置命令
     *
     * @param color 颜色色值 #FF00EE
     * @return 颜色设置命令
     */
    public static String colorOrder(String color) {
        return String.format("color_%s#", color.replace("#", ""));
    }

    /**
     * 生成波长设置命令
     *
     * @param wave 波长
     * @return 波长设置命令
     */
    public static String waveOrder(Integer wave) {
        return String.format("wave_%s#", toHexString(wave));
    }


    public static String toHexString(int n) {
        return Integer.toHexString(n);
    }


    /**
     * 设置时间参数
     *
     * @param param 时间参数
     * @return 时间参数
     */
    public static String toTime(MyTimeParam param) {
        return String.format("%s/%s/%s/%s", toHexString(param.getHour()), toHexString(param.getMinutes()), toHexString(param.getSecond()), toHexString(param.getTimeMillis()));
    }

    /**
     * 设置工作时长命令
     *
     * @param work 工作时长
     * @return 工作时长命令
     */
    public static String workOrder(MyTimeParam work) {
        return String.format("work_%s#", toTime(work));
    }

    /**
     * 设置休息时长命令
     *
     * @param param 休息时长
     * @return 休息时长命令
     */
    public static String restOrder(MyTimeParam param) {
        return String.format("rest_%s#", toTime(param));
    }

    /**
     * 设置循环次数
     *
     * @param loop 循环次数命令
     * @return 循环次数命令
     */
    public static String loopOrder(Integer loop) {
        return String.format("loop_%s#", toHexString(loop));
    }


    @Data
    public static class MyTimeParam {

        /**
         * 小时
         */
        private Integer hour;

        /**
         * 分钟
         */
        private Integer minutes;

        /**
         * 秒
         */
        private Integer second;

        /**
         * 毫秒
         */
        private Integer timeMillis;


    }
}
