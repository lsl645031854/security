package com.jetty.homolo.security.entity;

/**
 * @Author: lsl
 * @Description:
 * @Date: Created on 21:19 2020/1/6
 */
public class Shoe {
    private String color;
    private int size;

    public Shoe() {
    }

    public Shoe(String color, int size) {
        this.color = color;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Shoe{" + "color='" + color + '\'' + ", size=" + size + '}';
    }
}
