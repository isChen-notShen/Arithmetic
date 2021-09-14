package ind.chen.util;

public class ArithmeticTimer {
    private long start;

    ArithmeticTimer(){
        start = -1;
    }

    public void start(){
        start = System.currentTimeMillis();
    }

    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public void reset(){
        start = -1;
    }
}