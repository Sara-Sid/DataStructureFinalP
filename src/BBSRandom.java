class BBSRandom {
    private long x;
    private long n;

    public BBSRandom() {
        long p = 383;
        long q = 503;
        n = p * q;
        x = System.currentTimeMillis() % n;  // simple seed
        if (x == 0) x = 17;
    }

    // Returns a random number between 0 and max-1
    public int nextInt(int max) {
        x = (x * x) % n;  // BBS formula
        return (int) (x % max);

    }
}


