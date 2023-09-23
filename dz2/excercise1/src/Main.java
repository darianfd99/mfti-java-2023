import Trade.Trade;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0){
            System.out.println("No arguments found");
            return;
        }
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        String line;
        String tradeTypeString = "";
        String priceString = "";
        while((line = reader.readLine()) != null){
            if(line.contains("tradeType=")){
                tradeTypeString = line.substring(line.indexOf('=') + 1);
            }
            if (line.contains("price=")){
                priceString = line.substring(line.indexOf('=')+1);
            }
        }

        Float price = Float.parseFloat(priceString);
        Trade trade = new Trade(tradeTypeString, price);
        System.out.println(trade.toString());
    }
}