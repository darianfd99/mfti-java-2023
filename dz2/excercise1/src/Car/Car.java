package Car;
import Trade.TradeType;

public abstract class Car {
    public float price;

    public Car(float price) {
        this.price = price;
    }

    public static Car CreateCar(String type, float price){
        Car car;
        TradeType tradeType = TradeType.valueOf(type);
        switch (tradeType){
            case HATCHBACK -> car = new Hatchback(price);
            case SEDAN -> car = new Sedan(price);
            case SUV -> car = new Suv(price);
            default -> car = new Pickup(price);
        }
        return car;
    }
}

