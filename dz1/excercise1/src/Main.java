import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String keyboardLetters = new String("qwertyuiopasdfghjklzxcvbnm");
        File file = new File("input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        FileWriter writer = new FileWriter("output.txt");
        char letter;
        st = br.readLine();
        if(st != null){
            letter = st.charAt(0);
        }else{
            IOException IOException = new IOException("error: invalid letter");
            throw IOException;
        }
        br.close();

        int letterPosition = keyboardLetters.indexOf(letter);
        char result = keyboardLetters.charAt((letterPosition + 1) % keyboardLetters.length());

        writer.write(result);
        writer.close();
    }
}