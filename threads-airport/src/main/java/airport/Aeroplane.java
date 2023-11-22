package airport;

import java.time.LocalDateTime;
import java.util.Random;

public class Aeroplane implements Runnable {

    final private int runway;

    final private Airport airport;

    final private int id;

    public Aeroplane(Airport airport, int runway, int id) {
        this.airport = airport;
        if (runway < 1 || runway > 2) {
            throw new IllegalArgumentException("illegal runway");
        }
        this.runway = runway;
        this.id = id;
    }

    @Override
    public void run() {
        airport.getWhichEnd(runway);
        airport.getStart();
        airport.getCross();
        moveToStart();
        moveToCross();
        airport.giveStart();
        airport.giveCross();
        moveToEnd(runway);
        airport.giveWhichEnd(runway);
    }


    public void moveToStart() {
        System.out.printf("%s Aeroplane %s started landing%n", LocalDateTime.now().toLocalTime().toString(), id);
        try {
            System.out.printf("%s Aeroplane %s currently at start%n", LocalDateTime.now().toLocalTime().toString(), id);
            Thread.sleep(new Random().nextInt(500, 1001));
            System.out.printf("%s Aeroplane %s leaving start%n", LocalDateTime.now().toLocalTime().toString(), id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void moveToCross() {
        System.out.printf("%s Aeroplane %s is trying to cross%n", LocalDateTime.now().toLocalTime().toString(), id);
        try {
            System.out.printf("%s Aeroplane %s currently at cross%n", LocalDateTime.now().toLocalTime().toString(), id);
            Thread.sleep(new Random().nextInt(500, 1001));
            System.out.printf("%s Aeroplane %s leaving cross%n", LocalDateTime.now().toLocalTime().toString(), id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void moveToEnd(int whichEnd) {
        System.out.printf("%s Aeroplane %s is trying to end at end%d %n", LocalDateTime.now().toLocalTime().toString(), id, whichEnd);
        end(whichEnd);
    }

    public void end(int end) {
        try {
            System.out.printf("%s Aeroplane %s currently at end%s%n", LocalDateTime.now().toLocalTime().toString(),id, end);
            Thread.sleep(new Random().nextInt(500, 1001));
            System.out.printf("%s Aeroplane %s leaving end%s%n", LocalDateTime.now().toLocalTime().toString(), id, end);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
