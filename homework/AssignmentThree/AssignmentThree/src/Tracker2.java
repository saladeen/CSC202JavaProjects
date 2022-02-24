public class Tracker2 implements NumTrackerInterface {
    int count, sum;

    public Tracker2() {
        count = 0;
        sum = 0;
    }

    public void add(int a) {
        count += 1;
        sum = sum + a;
    }

    public int getCount() {
        return count;
    }

    public int getSum() {
        return sum;
    }

    public double getAverage() {
        return sum / count;
    }
}
// TODO lld.