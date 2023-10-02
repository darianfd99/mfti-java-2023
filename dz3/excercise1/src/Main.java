import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0){
            System.out.println("No arguments found");
            return;
        }
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        List<String> lines = new ArrayList<>();
        String line = "";
        HashMap<String, Integer> wordsCount = new HashMap<String, Integer>();
        while((line = reader.readLine()) != null){
            lines.add(line);
            line = line.toLowerCase();
            line = line.replace("?", "");
            line = line.replace("!", "");
            line = line.replace("\n", "");
            line = line.replace(".", "");
            line = line.replace(",", "");
            line = line.replace(";", "");
            String[] wordsArray = line.split(" ");
            for (String s : wordsArray) {
                wordsCount.putIfAbsent(s, 0);
                wordsCount.replace(s, wordsCount.get(s) + 1);
            }
        }

        List<String> wordsList = new ArrayList<>(wordsCount.keySet().stream().toList());
        wordsList.sort(String.CASE_INSENSITIVE_ORDER);
        wordsList.sort((String s1, String s2) -> s1.length() - s2.length());

        Collections.reverse(lines);
        System.out.printf("task1: number_of_different_words: %d\n", wordsList.toArray().length);
        System.out.printf("task2: ordered_words_by_length: %s\n", wordsList);
        System.out.printf("task3: number_of_repetition_per_word: %s\n", wordsCount);
        System.out.printf("task4: reversed_lines_of_the_text:\n%s\n\n", String.join("\n", lines));
        System.out.println("task5: lines_with_reversed_iterator:");

        ReverseIterator<String> reverseIterator = new ReverseIterator<>(lines);
        for (Object o : reverseIterator) {
            System.out.println(o);
        }

        Collections.reverse(lines);

        Scanner scanner = new Scanner(System.in);
        System.out.print("\n\nEnter a number of the line: ");
        int lineNumber = Integer.parseInt(scanner.nextLine());
        System.out.printf("The line %d is: ", lineNumber);
        System.out.println(lines.get(lineNumber - 1));

    }
}