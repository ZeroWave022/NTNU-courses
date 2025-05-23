package assignment7.suggestedsolutions.observablelist;

import java.util.Scanner;

public class ObservableHighscoreListProgram implements ObservableListListener {

	private ObservableHighscoreList highscoreList;

	public void init() {
		this.highscoreList = new ObservableHighscoreList(5);
		this.highscoreList.addObservableListListener(this);
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextInt()) {
			int score = scanner.nextInt();
			this.highscoreList.addResult(score);
		}

		scanner.close();
	}

	public void listChanged(ObservableList list, int pos) {
		for (int i = 0; i < this.highscoreList.size(); i++) {
			System.out.println(
					this.highscoreList.getElement(i) + (pos == i ? (" <=== @ " + pos) : ""));
		}

		System.out.println();
	}

	public static void main(String[] args) {
		ObservableHighscoreListProgram program = new ObservableHighscoreListProgram();
		program.init();
		program.run();
	}
}
