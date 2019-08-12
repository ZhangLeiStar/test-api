package cn.smile.api.simulate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//三个线程交替打印ABCABC 打印十次
public class MutiThreadEachPrintChar {
    static ReentrantLock lock = new ReentrantLock();
    static Condition printAcondition = lock.newCondition();
    static Condition printBcondition = lock.newCondition();
    static Condition printCcondition = lock.newCondition();

    static volatile int status = 0;

    public static void main(String [] args){
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i< 10;i++){
                    lock.lock();
                    try{
                        if(status != 0){
                            printAcondition.await();
                        }
                        System.out.println("A");
                        status = 1;
                        printBcondition.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i< 10;i++) {
                    lock.lock();
                    try{
                        while(status != 1){
                            printBcondition.await();
                        }
                        System.out.println("B");
                        status = 2;
                        printCcondition.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i< 10;i++) {
                    lock.lock();
                    try {
                        while (status != 2) {
                            printCcondition.await();
                        }
                        System.out.println("C");
                        status = 0;
                        printAcondition.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
