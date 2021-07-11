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
        System.out.println(LedOrderUtil.waveOrder(476));
    }
}
