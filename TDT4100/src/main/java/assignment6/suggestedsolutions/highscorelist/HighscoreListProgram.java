package assignment6.suggestedsolutions.highscorelist;

import java.util.Scanner;

public class HighscoreListProgram implements HighscoreListListener {

	private HighscoreList highscoreList;

	public void init() {
		this.highscoreList = new HighscoreList(5);
		this.highscoreList.addHighscoreListListener(this);
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextInt()) {
			int score = scanner.nextInt();
			highscoreList.addResult(score);
		}

		scanner.close();
	}

	public void listChanged(HighscoreList list, int pos) {
		for (int i = 0; i < highscoreList.size(); i++) {
			System.out.println(highscoreList.getElement(i) + (pos == i ? (" <==== @ " + pos) : ""));
		}

		System.out.println();
	}

	public static void main(String[] args) {
		HighscoreListProgram program = new HighscoreListProgram();
		program.init();
		program.run();
	}
}
