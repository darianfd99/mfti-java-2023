import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> lines = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
        String line = "";
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        FileProcessor fp = new FileProcessor(lines);
        fp.doPipeline();
    }
}