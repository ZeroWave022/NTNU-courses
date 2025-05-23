package assignment3.suggestedsolutions;

public class Nim {

	private final int[] piles;

	public Nim(int pileSize) {
		this.piles = new int[] { pileSize, pileSize, pileSize };
	}

	public Nim() {
		this(10);
	}

	public void removePieces(int number, int targetPile) {
		if (this.isGameOver()) {
			throw new IllegalStateException("Cannot remove pieces when game is over");
		}
		if (!this.isValidMove(number, targetPile)) {
			throw new IllegalArgumentException("Move is not valid");
		}

		this.piles[targetPile] -= number;
	}

	public boolean isValidMove(int number, int targetPile) {
		return number > 0 && number <= this.getPile(targetPile) && !this.isGameOver();
	}

	public boolean isGameOver() {
		return this.getPile(0) == 0 || this.getPile(1) == 0 || this.getPile(2) == 0;
	}

	public int getPile(int targetPile) {
		return this.piles[targetPile];
	}

	@Override
	public String toString() {
		return String.format("[Nim piles=%s]", this.piles);
	}
}
