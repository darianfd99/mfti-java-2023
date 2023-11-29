import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0){
            System.out.println("No arguments found");
            return;
        }
        FileProcessor fp = new FileProcessor(args[0]);
        fp.doPipeline();
    }
}