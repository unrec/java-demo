package threads.sync;

class Counter {
    long count = 0;

    synchronized void add(long value) {
        this.count += value;
    }
}