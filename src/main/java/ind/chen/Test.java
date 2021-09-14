package ind.chen;

public class Test {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static int handle(int a,int b) {
        if(a==0) return b;
        if(b==0) return a;
        int i=a^b;
        int j=(a&b)<<1;
        return  handle(i,j);
    }

    public static void main(String[] args) {
//        final Test test = new Test();
//        for(int i=0;i<10;i++){
//            new Thread(){
//                public void run() {
//                    for(int j=0;j<1000;j++)
//                        test.increase();
//                }
//            }.start();
//        }
//
//        while(Thread.activeCount()>2)  //保证前面的线程都执行完
//            Thread.yield();
//        System.out.println(test.inc);
        System.out.println(handle(1024,256));
    }
}