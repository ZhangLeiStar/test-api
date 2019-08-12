package cn.smile.api.simulate;

public class PrintThread implements Runnable {

    private String printStr;
    private MajorClass majorClass;

    public PrintThread(MajorClass majorClass,String printStr){
        this.printStr = printStr;
        this.majorClass = majorClass;
    }

    public void run() {

        if(printStr.equals("A")){
            for(int i = 0; i < 10; i++){
                synchronized (majorClass){
                    while(majorClass.getStatus() != 0) {
                        try {
                            majorClass.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(printStr);
                    majorClass.setStatus(1);
                    majorClass.notifyAll();
                }
            }
        }

        if(printStr.equals("B")){
            for(int i = 0; i < 10; i++){
                synchronized (majorClass){
                    while(majorClass.getStatus() != 1) {
                        try {
                            majorClass.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(printStr);
                    majorClass.setStatus(2);
                    majorClass.notifyAll();
                }
            }
        }

        if(printStr.equals("C")){
            for(int i = 0; i < 10; i++){
                synchronized (majorClass){
                    while(majorClass.getStatus() != 2) {
                        try {
                            majorClass.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(printStr);
                    majorClass.setStatus(0);
                    majorClass.notifyAll();
                }
            }
        }

    }
}
