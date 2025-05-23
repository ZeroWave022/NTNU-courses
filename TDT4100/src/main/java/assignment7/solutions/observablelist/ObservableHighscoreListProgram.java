package assignment7.solutions.observablelist;

import java.util.Scanner;

public class ObservableHighscoreListProgram implements ObservableListListener {
    private ObservableHighscoreList list;

    @Override
    public void listChanged(ObservableList list, int i) {
        System.out.println("List changed!");
        System.out.println("List is now: " + list);
        System.out.println("Change happened at index " + i);
    }

    private void init() {
        this.list = new ObservableHighscoreList(3);
        this.list.addObservableListListener(this);
    }

    public void run() {
        this.init();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Du vil bli bedt om å skrive inn 5 high scores. Listen holder kun 3 av gangen.");
        for (int i = 0; i < 4; i++) {
            System.out.println("Skriv inn en high score: ");
            this.list.addResult(scanner.nextInt());
        }
        scanner.close();
    }

    public static void main(String[] args) {
        ObservableHighscoreListProgram program = new ObservableHighscoreListProgram();
        program.run();
    }
}
