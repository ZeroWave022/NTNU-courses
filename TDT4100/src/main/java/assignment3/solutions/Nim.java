package assignment3.solutions;

import java.util.ArrayList;

public class Nim {
    private ArrayList<Integer> piles = new ArrayList<Integer>();
    private boolean gameEnded = false;

    public Nim() {
        for (int i = 0; i < 3; i++) {
            piles.add(10);
        }
    }

    public Nim(int pileSize) {
        for (int i = 0; i < 3; i++) {
            piles.add(pileSize);
        }
    }

    private boolean validateInput(int number, int targetPile) {
        return this.validateInput(number, targetPile, true);
    }

    private boolean validateInput(int number, int targetPile, boolean throwException) {
        if (gameEnded) {
            if (throwException)
                throw new IllegalStateException("Cannot move items after the game ended");
            return false;
        }

        if (targetPile < 0 || targetPile > 2) {
            if (throwException)
                throw new IllegalArgumentException("Pile number invalid");
            return false;
        }

        if (number < 1) {
            if (throwException)
                throw new IllegalArgumentException("Cannot remove a negative number from pile");
            return false;
        }

        Integer pile = piles.get(targetPile);

        if (number > pile) {
            if (throwException)
                throw new IllegalArgumentException("Cannot remove so many items from the pile!");
            return false;
        }

        return true;
    }

    public void removePieces(int number, int targetPile) {
        this.validateInput(number, targetPile);

        Integer pile = piles.get(targetPile);
        piles.set(targetPile, pile - number);

        if (piles.contains(0))
            gameEnded = true;
    }

    public boolean isValidMove(int number, int targetPile) {
        return this.validateInput(number, targetPile, false);
    }

    public boolean isGameOver() {
        return this.gameEnded;
    }

    public int getPile(int targetPile) {
        return this.piles.get(targetPile);
    }

    public String toString() {
        return "Piles:" + piles;
    }
}
