package cn.smile.api.inherit;

public abstract class Park {

    public void getParkRealName(){
        System.out.println("My real name is:"+ this.getClass());
        System.out.println("My real short name is:"+ this.getClass().getCanonicalName());
        System.out.println("My real small name is:"+ this.getClass().getSimpleName()+":"+this.getClass().getName()+":"+this.getClass().getTypeName());
    }

}
