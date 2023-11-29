import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileProcessor {
    private final ArrayList<String> lines;
    private final HashMap<String, Integer> words;

    FileProcessor(String pathToFile) throws IOException {
        lines = new ArrayList<>();
        words = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
        String line = "";
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
                if (s == null || s.isBlank()){
                    continue;
                }
                words.putIfAbsent(s, 0);
                words.replace(s, words.get(s) + 1);
            }
        }
    }

    void printNumberOfDifferentWords(){
        System.out.printf("task1: number_of_different_words: %d\n", words.size());
    }

    public void printOrderedWordsByLength(){
        ArrayList<String> wordsList = new ArrayList<>(words.keySet());
        wordsList.sort(String.CASE_INSENSITIVE_ORDER);
        wordsList.sort(Comparator.comparingInt(String::length));
        System.out.printf("task2: ordered_words_by_length: %s\n", wordsList);
    }

    public void printNumberOfRepetitionPerWord(){
        System.out.printf("task3: number_of_repetition_per_word: %s\n", words);
    }

    public void printReverseLinesOfTheText(){
        List<String> reversedLines = lines.reversed();
        System.out.printf("task4: reversed_lines_of_the_text:\n%s\n\n", String.join("\n", reversedLines));
    }

    public void printLinesWithReverseIterator(){
        System.out.println("task5: lines_with_reversed_iterator:");

        ReverseIterator<String> reverseIterator = new ReverseIterator<>(lines);
        for (Object o : reverseIterator) {
            System.out.println(o);
        }
    }

    public void printSpecificLine(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n\ntask6: Enter a number of the line: ");
        int lineNumber = Integer.parseInt(scanner.nextLine());
        System.out.printf("task6: The line %d is: ", lineNumber);
        System.out.println(lines.get(lineNumber - 1));
    }

    public void doPipeline(){
        printNumberOfDifferentWords();
        printOrderedWordsByLength();
        printNumberOfRepetitionPerWord();
        printReverseLinesOfTheText();
        printLinesWithReverseIterator();
        printSpecificLine();
    }
}
