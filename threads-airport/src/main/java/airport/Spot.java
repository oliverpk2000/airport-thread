package airport;

public class Spot {
    private boolean lock;
    public Spot(){
        lock = false;
    }

    public Spot(boolean lock){
        setLock(lock);
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }
}
