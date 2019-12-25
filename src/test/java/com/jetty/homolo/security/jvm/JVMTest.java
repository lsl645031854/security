package com.jetty.homolo.security.jvm;

import org.junit.Test;
import sun.applet.Main;

import java.util.*;

/**
 * @Author: lsl
 * @Description:
 * @Date: Created on 21:37 2019/12/8
 */
public class JVMTest {

    @Test
    public void test() {
        // 电脑核数
        System.out.println(Runtime.getRuntime().availableProcessors());


    }

    public static void main(String[] args){
//        long maxMemory = Runtime.getRuntime().maxMemory() ;//返回 Java 虚拟机试图使用的最大内存量。
//        long totalMemory = Runtime.getRuntime().totalMemory() ;//返回 Java 虚拟机中的内存总量。
//        System.out.println("-Xmx: MAX_MEMORY = " + maxMemory + "（字节）、" + (maxMemory / (double)1024 / 1024) + "MB");
//        System.out.println("-Xms: TOTAL_MEMORY = " + totalMemory + "（字节）、" + (totalMemory / (double)1024 / 1024) + "MB");

        Character g = mostFrequentLetter("12345._");
        System.out.println(g);
        int[] a = new int[3];
        a[0] = 4;
        a[1] = 5;
        a[2] = 6;
        int[] b = new int[5];
        b[0] = 4;
        b[1] = 5;
        b[2] = 3;
        b[3] = 2;
        b[4] = 6;
        int[] c = new int[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        sort(c, 0, c.length - 1);
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }

    private static void sort(int a[], int left, int right)
    {
        if(left >= right)
        {
            return ;
        }
        int i = left;
        int j = right;
        int key = a[left];

        while(i < j)
        {
            while(i < j && key <= a[j])
            {
                j--;
            }
            a[i] = a[j];
            while(i < j && key >= a[i])
            {
                i++;
            }
            a[j] = a[i];
        }
        a[i] = key;
        sort(a, left, i - 1);
        sort(a, i + 1, right);
    }

    public static Character mostFrequentLetter(String string) {
        Character character = null;
        char[] c = string.toCharArray();
        if(c.length>0){
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0;i<c.length;i++){
                if(map.get(c[i]) == null){
                    map.put(c[i], 1);
                }else{
                    map.put(c[i], map.get(c[i])+1);
                }
            }
            int tempCount = 0;
            Iterator<Character> iterator = map.keySet().iterator();
            while(iterator.hasNext()){
                Character ch = iterator.next();
                int chCount = map.get(ch);
                if(chCount > tempCount){
                    tempCount = chCount;
                    character = ch;
                }else if (chCount == tempCount) {
                    if(ch < character) {
                        tempCount = chCount;
                        character = ch;
                    }
                }
            }
        }
        return character;
    }

}
