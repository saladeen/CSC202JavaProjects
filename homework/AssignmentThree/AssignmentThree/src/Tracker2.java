public class Tracker2 implements NumTrackerInterface {
    int count, sum;

    public Tracker2() {
        count = 0;
        sum = 0;
    }

    @Override
    public void add(int a) {
        count += 1;
        sum = sum + a;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public int getSum() {
        return sum;
    }

    @Override
    public double getAverage() {
        return sum / count;
    }
}
// TODO lld.