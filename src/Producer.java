class Producer implements Runnable {
    private Three three;
    private int needNum;

    public Producer(Three three, int needNum) {
        this.three = three;
        this.needNum = needNum;
    }

    @Override
    public void run() {
        for (int i = 0; i < needNum; i++) {
            three.putToHashMap();
        }
    }
}