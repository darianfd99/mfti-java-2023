import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Math.min;

public class FileProcessor {
    private final ArrayList<String> lines;
    FileProcessor(ArrayList<String> lines) {
        this.lines = lines;
    }

    public void printWordsStartingWithN(){
        System.out.println("*************************************************************************************");
        System.out.println("1 Найдите по словарю слова, начинающиеся с буквы n:");
        Stream<String> stream = lines.stream();
        stream
                .filter(e -> e.charAt(0) == 'n')
                .map(e -> e.substring(0, e.indexOf(':')))
                .forEach(System.out::println);
        System.out.println("*************************************************************************************");
    }

    public void printWordsWithLengthLessThan7(){
        System.out.println("*************************************************************************************");
        System.out.println("2 Найдите по словарю слова, длиной 7 символов:");
        Stream<String> stream = lines.stream();
        stream
                .map(e -> e.substring(0, e.indexOf(':')))
                .filter(e -> e.length() == 7)
                .forEach(System.out::println);
        System.out.println("*************************************************************************************");
    }

    public void printGroupedWordsBy3FirstLetters(){
        System.out.println("*************************************************************************************");
        System.out.println("3 Сгруппируйте слова по первым трем буквам.:");
        Stream<String> stream = lines.stream();
        stream
                .map(e -> e.substring(0, e.indexOf(':')))
                .sorted(Comparator.comparing(e -> e.substring(0, min(3, e.length()))))
                .forEach(System.out::println);
        System.out.println("*************************************************************************************");
    }

    public void printVocalsInWords(){
        System.out.println("*************************************************************************************");
        System.out.println("4 Подсчитайте гласные, используемые в словах: ");
        List<Integer> vocals = new ArrayList<>();

        vocals.add((int) 'a');
        vocals.add((int) 'e');
        vocals.add((int) 'i');
        vocals.add((int) 'o');
        vocals.add((int) 'u');

        Stream<String> stream = lines.stream();
        long vocalsCount = stream
                .flatMapToInt(e -> e.substring(0, e.indexOf(':')).chars())
                .filter(vocals::contains)
                .count();
        System.out.printf("vocal counts: %d\n", vocalsCount);
        System.out.println("*************************************************************************************");
    }

    public void printWordsStartedFromAToH(){
        System.out.println("*************************************************************************************");
        System.out.println("5 Найдите слова, начинающиеся с букв от a до h: ");
        Stream<String> stream = lines.stream();
        stream
                .map(e -> e.substring(0, e.indexOf(':')))
                .filter(e -> e.charAt(0) <= 'h')
                .forEach(System.out::println);
        System.out.println("*************************************************************************************");
    }

    public void printPolyndromes(){
        System.out.println("*************************************************************************************");
        System.out.println("6 Найдите палиндромы в словаре. Палиндром — это слово, число, фраза или другая последовательность символов, которая читается как в прямом, так и в обратном направлении, например мадам: ");
        Stream<String> stream = lines.stream();
        stream
                .map(e -> e.substring(0, e.indexOf(':')))
                .filter(e -> e.contentEquals(new StringBuilder(e).reverse()))
                .forEach(System.out::println);
        System.out.println("*************************************************************************************");
    }

    public void printWordsStartedByAAndFinishingByZ(){
        System.out.println("*************************************************************************************");
        System.out.println("7 Найдите слова, начинающиеся на букву a и заканчивающиеся на букву z: ");
        Stream<String> stream = lines.stream();
        stream
                .map(e -> e.substring(0, e.indexOf(':')))
                .filter(e -> e.charAt(0) == 'a' && e.charAt(e.length() - 1) == 'z')
                .forEach(System.out::println);
        System.out.println("*************************************************************************************");
    }

    public void printLargestWord(){
        System.out.println("*************************************************************************************");
        System.out.println("8 Найдите самое длинное слово в словаре: ");
        Stream<String> stream = lines.stream();
        String maxLengthString = stream
                .map(e -> e.substring(0, e.indexOf(':')))
                .max(Comparator.comparingInt(String::length))
                .get();
        System.out.println(maxLengthString);
        System.out.println("*************************************************************************************");
    }

    public void doPipeline(){
        printWordsStartingWithN();
        printWordsWithLengthLessThan7();
        printGroupedWordsBy3FirstLetters();
        printVocalsInWords();
        printWordsStartedFromAToH();
        printPolyndromes();
        printWordsStartedByAAndFinishingByZ();
        printLargestWord();
    }
}
