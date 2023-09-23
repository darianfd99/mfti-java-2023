import java.io.*;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line;
        line = reader.readLine();
        int k = Integer.parseInt(line);

        Vector<Integer> dVector = new Vector<>(k);
        for(int i = 0; i < k; ++i){
            line = reader.readLine();
            String[] values = line.split(" ", 3);
            int n = Integer.parseInt(values[0]);
            int m = Integer.parseInt(values[1]);
            int d = 19 * m +  (n + 239) * (n + 366) / 2;
            dVector.add(d);
        }
        reader.close();

        FileWriter writer = new FileWriter("output.txt");
        for(Integer d: dVector){
            writer.write(String.valueOf(d) + '\n');
        }
        writer.close();
    }
}