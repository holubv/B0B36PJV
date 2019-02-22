package cz.cvut.fel.pjv;

public class BruteForceAttacker extends Thief {

    private int[] numGuess;
    private char[] guess;
    private int dictLen;

    @Override
    public void breakPassword(int sizeOfPassword) {
        this.numGuess = new int[sizeOfPassword];
        this.guess = new char[sizeOfPassword];
        this.dictLen = this.getCharacters().length;

        this.convertAndTry();
        while (true) {
            try {
                if (rot(0)) {
                    break;
                }
            } catch (RuntimeException e) {
                break;
            }
        }
    }

    private boolean rot(int index) {
        if (index >= this.numGuess.length) {
            throw new RuntimeException("no solution found: " + toString());
        }
        numGuess[index]++;
        if (numGuess[index] >= this.dictLen) {
            numGuess[index] = 0;
            return rot(index + 1);
        }
        return this.convertAndTry();
    }

    private boolean convertAndTry() {
        for (int i = 0; i < numGuess.length; i++) {
            this.guess[i] = this.getCharacters()[numGuess[i]];
        }
        //System.out.println(Arrays.toString(numGuess));
        return this.tryOpen(this.guess);
    }
}
