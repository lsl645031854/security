package com.jetty.homolo.security.lambda;

import com.jetty.homolo.security.entity.Dash;
import javafx.collections.transformation.FilteredList;
import org.junit.Test;

import java.util.*;

/**
 * @Author: lsl
 * @Description:
 * @Date: Created on 14:23 2019/10/16
 */
public class LambdaTest {

    @Test
    public void test() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }

    @Test
    public void test1() {
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }

    private List<Dash> dashes = Arrays.asList(
            new Dash("番茄鸡蛋", 12.3, 400),
            new Dash("青椒鸡蛋", 10.8, 550),
            new Dash("苦瓜鸡蛋", 15.3, 510),
            new Dash("黄瓜鸡蛋", 18.3, 600)
    );

    // 需求：获取卡路里大于500卡的菜单

    @Test
    public void test2() {
        // 方法一
        List<Dash> dashList = filterDash(dashes);
        println(dashList);
    }

    @Test
    public void test3() {
        // 方法二
        List<Dash> dashList = filterDashByFilter(dashes, new FilterDashCalories());
        println(dashList);
    }

    @Test
    public void test4() {
        // 方法三 匿名内部类
        List<Dash> dashList = filterDashByFilter(dashes,new FilterDash<Dash>() {
            @Override
            public boolean predicate(Dash dash) {
                return dash.getCalories() > 500;
            }
        });
        println(dashList);
    }

    @Test
    public void test5() {
        List<Dash> dashList = filterDashByFilter(dashes, dash -> dash.getCalories() > 500);
        println(dashList);
    }

    @Test
    public void test6() {
        Collections.sort(dashes, (d1, d2) -> {
            if (d1.getCalories() == d2.getCalories()) {
                return d1.getName().compareTo(d2.getName());
            } else {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        println(dashes);
    }

    private List<Dash> filterDash(List<Dash> dashes) {
        List<Dash> dashList = new ArrayList<>();
        for (Dash dash : dashes) {
            if (dash.getCalories() > 500) {
                dashList.add(dash);
            }
        }
        return dashList;
    }

    private List<Dash> filterDashByFilter(List<Dash> dashes, FilterDash<Dash> filterDash) {
        List<Dash> dashList = new ArrayList<>();
        for (Dash dash : dashes) {
            if (filterDash.predicate(dash)) {
                dashList.add(dash);
            }
        }
        return dashList;
    }

    private void println(List<Dash> dashes) {
        for (Dash dash : dashes) {
            System.out.println(dash);
        }
    }
}
