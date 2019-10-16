package com.jetty.homolo.security.entity;

/**
 * @Author: lsl
 * @Description:
 * @Date: Created on 14:31 2019/10/16
 */
public class Dash {
    private String name; // 菜名
    private Double price; // 价格
    private Integer calories; // 卡路里

    public Dash() {
    }

    public Dash(String name, Double price, Integer calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Dash{" + "name='" + name + '\'' + ", price=" + price + ", calories=" + calories + '}';
    }
}
