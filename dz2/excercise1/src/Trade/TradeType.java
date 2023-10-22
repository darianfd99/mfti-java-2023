package Trade;

import Car.Hatchback;
import Car.Sedan;
import Car.Suv;
import Car.Pickup;
import Car.Car;

public enum TradeType {
    HATCHBACK {
        @Override
        public Car createTrade(float price) {
            return new Hatchback(price);
        }
    },
    SEDAN{
        @Override
        public Car createTrade(float price) {
            return new Sedan(price);
        }
    },

    SUV{
        @Override
        public Car createTrade(float price) {
            return new Suv(price);
        }
    },
    PICKUP{
        @Override
        public Car createTrade(float price) {
            return new Pickup(price);
        }
    };

    public abstract Car createTrade(float price);
}
