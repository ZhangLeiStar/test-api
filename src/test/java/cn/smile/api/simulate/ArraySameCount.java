package cn.smile.api.simulate;

import java.util.Arrays;

/**
 * 求一个1-n的整数数组的值的每个元素的重复次数，要求时间复杂度是O(n),空间复杂度为O(1)
 * */
public class ArraySameCount {
    public static void main(String [] args){
        int [] array = new int [] {8,2,3,3,2,5,2,2,9,6};

        for(int i = 0; i< array.length; i ++){
            //取下标为0的元素值
            int temp = array[i];

            //temp的值小于0，说明是计数元素，直接略过
            if(temp < 0){
                continue;
            }
            //取以当前元素为下标的元素的值
            int temp2 = array[temp-1];


            if(temp2 < 0){
                //temp2的值小于0，说明此位置是用来计数的则计数+1(使用负数表示，则计数--)
                array[temp-1] --;
            }else{
                //否则说明此位置为第一个新计数，计数为-1，然后把此下标位置元素交换到当前元素，i-1
                array[temp-1] = -1;
                if(i >= temp -1){
                    continue;
                }
                array[i] = temp2;
                --i;
            }
        }

        System.out.println(Arrays.toString(array));

    }
}
