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
// lld. Tracker1 does not have to recalculate the average every time getAverage() is called, but has to recalculate it every time a number is added, and uses extra memory to store the average.
//      Tracker2 does not have to store an average or recalculate it every time a number is added, but requires extra calculation whenever getAverage() is called, since the average is not stored.