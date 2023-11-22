package airport;

import lombok.SneakyThrows;

public class Airport {
    private final Spot start;
    private final Spot cross;

    private final Spot end1;

    private final Spot end2;

    public Airport() {
        start = new Spot();
        cross = new Spot();
        end1 = new Spot();
        end2 = new Spot();
    }

    @SneakyThrows
    public void getStart() {
        synchronized (start) {
            while (start.isLock()) {
                start.wait();
            }
            start.setLock(true);
            start.notifyAll();
        }
    }

    @SneakyThrows
    public void getCross() {
        synchronized (cross) {
            while (cross.isLock()) {
                cross.wait();
            }
            cross.setLock(true);
            cross.notifyAll();
        }
    }

    public void getWhichEnd(int whichEnd) {
        switch (whichEnd) {
            case 1 -> getEnd1();
            case 2 -> getEnd2();
            default -> throw new IllegalArgumentException("illegal runway");
        }
    }

    @SneakyThrows
    public void getEnd1() {
        synchronized (end1) {
            while (end1.isLock()) {
                end1.wait();
            }
            end1.setLock(true);
            end1.notifyAll();
        }
    }

    @SneakyThrows
    public void getEnd2() {
        synchronized (end2) {
            while (end2.isLock()) {
                end2.wait();
            }
            end2.setLock(true);
            end2.notifyAll();
        }
    }

    public void giveStart() {
        synchronized (start) {
            start.setLock(false);
            start.notifyAll();
        }
    }


    public void giveCross() {
        synchronized (cross) {
            cross.setLock(false);
            cross.notifyAll();
        }
    }

    public void giveEnd1() {
        synchronized (end1) {
            end1.setLock(false);
            end1.notifyAll();
        }
    }

    public void giveEnd2() {
        synchronized (end2) {
            end2.setLock(false);
            end2.notifyAll();
        }
    }

    public void giveWhichEnd(int whichEnd) {
        switch (whichEnd) {
            case 1 -> giveEnd1();
            case 2 -> giveEnd2();
        }
    }
}
