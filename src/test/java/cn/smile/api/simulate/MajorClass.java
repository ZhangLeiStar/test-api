package cn.smile.api.simulate;


public class MajorClass {

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private volatile int status = 0;

}
