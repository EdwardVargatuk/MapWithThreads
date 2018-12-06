class Consumer implements Runnable {
    private Three three;
    private int existNum;

    public Consumer(Three three, int existNum) {
        this.three = three;
        this.existNum = existNum;
    }


    @Override
    public void run() {
        for (int i = 0; i < existNum; i++) {
            three.getFromHashMap();
        }
    }
}