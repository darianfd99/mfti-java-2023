import Car.Car;

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
            if(line.contains("carType=")){
                tradeTypeString = line.substring(line.indexOf('=') + 1);
            }
            if (line.contains("price=")){
                priceString = line.substring(line.indexOf('=')+1);
            }
        }
        float price = Float.parseFloat(priceString);
        Car car = Car.CreateCar(tradeTypeString, price);
        System.out.println(car.toString());
    }
}