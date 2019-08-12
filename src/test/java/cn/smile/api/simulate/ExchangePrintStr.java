package cn.smile.api.simulate;

public class ExchangePrintStr {
    public static void main(String [] args){

        MajorClass majorClass = new MajorClass();

        Thread t1 = new Thread(new PrintThread(majorClass,"A"));
        Thread t2 = new Thread(new PrintThread(majorClass,"B"));
        Thread t3 = new Thread(new PrintThread(majorClass,"C"));

        t1.start();
        t2.start();
        t3.start();
    }
}
