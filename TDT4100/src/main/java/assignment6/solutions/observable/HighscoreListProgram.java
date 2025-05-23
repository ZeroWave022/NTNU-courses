package assignment6.solutions.observable;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HighscoreListProgram implements HighscoreListListener {
    private HighscoreList list = new HighscoreList(3);
    private Scanner scanner = new Scanner(System.in);

    public HighscoreListProgram() {
        list.addHighscoreListListener(this);
        IntStream.range(0, 3).forEach(_ -> this.run());
    }

    public void run() {
        System.out.print("Skriv inn score: ");
        list.addResult(scanner.nextInt());
        System.out.println();
    }

    @Override
    public void listChanged(HighscoreList list, int i) {
        System.out.println("Listen ble endret. Nytt tall lagt til: " + i);
        System.out.println("Listen er nå: "
                + IntStream.range(0, list.size())
                        .mapToObj(e -> String.valueOf(list.getElement(e)))
                        .collect(Collectors.joining(", ")));
    }

    public static void main(String[] args) {
        new HighscoreListProgram();
    }
}
