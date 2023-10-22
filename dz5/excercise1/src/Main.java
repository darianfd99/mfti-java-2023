import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("*************************************************************************************");
        System.out.println("1 Найдите по словарю слова, начинающиеся с буквы n:");
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader("words.txt"));
        Stream<String> stream1 = bufferedReader1.lines();
        stream1
                .filter(e -> e.charAt(0) == 'n')
                .map(e -> e.substring(0, e.indexOf(':')))
                .forEach(System.out::println);
        System.out.println("*************************************************************************************");


        System.out.println("*************************************************************************************");
        System.out.println("2 Найдите по словарю слова, длиной 7 символов:");
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader("words.txt"));
        Stream<String> stream2 = bufferedReader2.lines();
        stream2
                .map(e -> e.substring(0, e.indexOf(':')))
                .filter(e -> e.length() == 7)
                .forEach(System.out::println);
        System.out.println("*************************************************************************************");

        System.out.println("*************************************************************************************");
        System.out.println("3 Сгруппируйте слова по первым трем буквам.:");
        BufferedReader bufferedReader3 = new BufferedReader(new FileReader("words.txt"));
        Stream<String> stream3 = bufferedReader3.lines();
        stream3
                .map(e -> e.substring(0, e.indexOf(':')))
                .sorted(Comparator.comparing(e -> e.substring(0, min(3, e.length()))))
                .forEach(System.out::println);
        System.out.println("*************************************************************************************");

        System.out.println("*************************************************************************************");
        System.out.println("4 Подсчитайте гласные, используемые в словах: ");
        List<Integer> vocals = new ArrayList<>();

        vocals.add((int) 'a');
        vocals.add((int) 'e');
        vocals.add((int) 'i');
        vocals.add((int) 'o');
        vocals.add((int) 'u');
        BufferedReader bufferedReader4 = new BufferedReader(new FileReader("words.txt"));
        Stream<String> stream4 = bufferedReader4.lines();
        long vocalsCount = stream4
                .flatMapToInt(e -> e.substring(0, e.indexOf(':')).chars())
                .filter(vocals::contains)
                .count();
        System.out.printf("vocal counts: %d\n", vocalsCount);
        System.out.println("*************************************************************************************");


        System.out.println("*************************************************************************************");
        System.out.println("5 Найдите слова, начинающиеся с букв от a до h: ");
        BufferedReader bufferedReader5 = new BufferedReader(new FileReader("words.txt"));
        Stream<String> stream5 = bufferedReader5.lines();
        stream5
                .map(e -> e.substring(0, e.indexOf(':')))
                .filter(e -> e.charAt(0) <= 'h')
                .forEach(System.out::println);
        System.out.println("*************************************************************************************");

        System.out.println("*************************************************************************************");
        System.out.println("6 Найдите палиндромы в словаре. Палиндром — это слово, число, фраза или другая последовательность символов, которая читается как в прямом, так и в обратном направлении, например мадам: ");
        BufferedReader bufferedReader6 = new BufferedReader(new FileReader("words.txt"));
        Stream<String> stream6 = bufferedReader6.lines();
        stream6
                .map(e -> e.substring(0, e.indexOf(':')))
                .filter(e -> e.contentEquals(new StringBuilder(e).reverse()))
                .forEach(System.out::println);
        System.out.println("*************************************************************************************");

        System.out.println("*************************************************************************************");
        System.out.println("7 Найдите слова, начинающиеся на букву a и заканчивающиеся на букву z: ");
        BufferedReader bufferedReader7 = new BufferedReader(new FileReader("words.txt"));
        Stream<String> stream7 = bufferedReader7.lines();
        stream7
                .map(e -> e.substring(0, e.indexOf(':')))
                .filter(e -> e.charAt(0) == 'a' && e.charAt(e.length() - 1) == 'z')
                .forEach(System.out::println);
        System.out.println("*************************************************************************************");

        System.out.println("*************************************************************************************");
        System.out.println("8 Найдите самое длинное слово в словаре: ");
        BufferedReader bufferedReader8 = new BufferedReader(new FileReader("words.txt"));
        Stream<String> stream8 = bufferedReader8.lines();
        String maxLengthString = stream8
                .map(e -> e.substring(0, e.indexOf(':')))
                .max(Comparator.comparingInt(String::length))
                .get();
        System.out.println(maxLengthString);
        System.out.println("*************************************************************************************");
    }
}