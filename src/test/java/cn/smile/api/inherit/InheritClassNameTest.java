package cn.smile.api.inherit;

import org.junit.Test;

import java.io.Serializable;
import java.util.HashMap;

public class InheritClassNameTest {

    @Test
    public  void classNameTest(){
        AnimalPark animalPark = new AnimalPark();
        animalPark.getParkRealName();

        //primitive
        System.out.println(int.class.getName());
        System.out.println(int.class.getCanonicalName());
        System.out.println(int.class.getSimpleName());
        System.out.println(int.class.getTypeName()); // Added in Java 8

        System.out.println();

        //class
        System.out.println(String.class.getName());
        System.out.println(String.class.getCanonicalName());
        System.out.println(String.class.getSimpleName());
        System.out.println(String.class.getTypeName());

        System.out.println();

        //inner class
        System.out.println(HashMap.SimpleEntry.class.getName());
        System.out.println(HashMap.SimpleEntry.class.getCanonicalName());
        System.out.println(HashMap.SimpleEntry.class.getSimpleName());
        System.out.println(HashMap.SimpleEntry.class.getTypeName());

        System.out.println();

        //anonymous inner class
        System.out.println(new Serializable(){}.getClass().getName());
        System.out.println(new Serializable(){}.getClass().getCanonicalName());
        System.out.println(new Serializable(){}.getClass().getSimpleName());
        System.out.println(new Serializable(){}.getClass().getTypeName());

    }
}
