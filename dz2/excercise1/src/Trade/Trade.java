package Trade;

enum TradeType{
    HATCHBACK,
    SEDAN,
    SUV,
    PICKUP;

    static TradeType createTradeType(String type){
        switch (type){
            case "HATCHBACK":
                return HATCHBACK;
            case "SEDAN":
                return SEDAN;
            case "SUV":
                return SUV;
            default:
                return PICKUP;
        }
    }
}
public class Trade {
    private TradeType tradeType;
    private float priceValue;

    public Trade(String typeValue, float price){
        tradeType = TradeType.createTradeType(typeValue);
        priceValue = price;
    }

    @Override
    public String toString() {
        return String.format("Trade:{\ntradeType=%s\nprice=%f\n}", tradeType, priceValue);
    }
}
