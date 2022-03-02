public class Tracker1 implements NumTrackerInterface {
    int count, sum;
    double average;

    public Tracker1() {
        count = 0;
        sum = 0;
        average = 0;
    }

    public void add(int a) {
        count += 1;
        sum = sum + a;
        average = sum / count;
    }

    public int getCount() {
        return count;
    }

    public int getSum() {
        return sum;
    }

    public double getAverage() {
        return average;
    }
    
}
