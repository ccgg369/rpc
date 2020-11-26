package com.zhongyou.example;

import com.sun.javafx.charts.ChartLayoutAnimator;

/**
 * @author ccx
 * @date 2020/6/15 16:46
 */
public class ClacServcieImpl implements ClacServcie {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }
}
