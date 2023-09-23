import java.io.*;
import java.util.Objects;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line;

        line = reader.readLine();
        int n = Integer.parseInt(line);

        line = reader.readLine();
        String[] stringList = line.split(" ", n + 1);

        Vector<Integer> vector = new Vector<Integer>(n);
        int index = 0;
        for(String numberString: stringList){
            if (index >= n){
                break;
            }
            vector.add(Integer.parseInt(numberString));
            ++index;
        }

        line = reader.readLine();
        Integer x = Integer.parseInt(line);

        reader.close();

        Integer count = 0;
        for(Integer number : vector){
            if (Objects.equals(number, x)){
                ++count;
            }
        }
        FileWriter writer = new FileWriter("output.txt");
        writer.write(String.valueOf(count));
        writer.close();
    }
}