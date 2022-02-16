import java.time.LocalDate;

public class ThirtySix {
    public static void main(String[] args) {
        // java.util.Date is pretty deprecated and hard to use so I used LocalDate
        LocalDate dates[] = new LocalDate[10];
        for (int i=0; i<dates.length; i++) {
            dates[i] = LocalDate.of(2005, 12, i+1);
        }
        for (LocalDate d: dates) {
            System.out.println(d);
        }
    }
}
