package cn.smile.api.basicType;

import org.junit.Test;

/**
 * 自动的装箱使用相应装箱对象的valueOf方法
 * 其中Integer/int（缓存对象池可以设置大小，默认是-128~127）、Short/short、Long/long的对象缓存池是-128~127
 * Boolean/boolean
 * Character/char <= 127
 * Byte/byte -128~127全缓存
 * Double/double、Float/float不缓存
 *
 * */
public class IntegerTest {

    @Test
    public void testIntInteger(){
        int a = 1;
        //自动装箱，等于Integer.valueOf，会使用到Integer的缓存对象池
        Integer b = 1;
        //new 一个对象不会使用缓存对象池
        Integer c = new Integer(1);

        System.out.println(a == b);
        System.out.println(b.equals(a));
        System.out.println(a == c);
        System.out.println(c.equals(a));
        System.out.println(c == b);
        System.out.println(c.equals(a));

    }

    @Test
    public void testByte(){
        byte a = 12;
        Byte b = 12;

    }
}
