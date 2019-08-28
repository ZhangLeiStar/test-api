package cn.smile.api.JiHeTest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {

    @Test
    public void printHashMap(){
        Map<String,String> printMap = new HashMap<String,String>();

        printMap.put("1","黎明");
        printMap.put("2","刘德华");

        Iterator iterator = printMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,String> entry  = (Map.Entry)iterator.next();
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println("------------------------------------------------");

        for(String key : printMap.keySet()){
            System.out.println(key + " "+printMap.get(key));
        }

        System.out.println("------------------------------------------------");
        for(Map.Entry entry: printMap.entrySet()){
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }
    }
}
