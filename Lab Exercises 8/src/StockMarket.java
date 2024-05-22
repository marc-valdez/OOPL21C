/*
 * Author: Marc Valdez
 * Section: C231_CS
 */

public class StockMarket {
    private final String symbol, name;
    double previousClosingPrice, currentPrice;

    public StockMarket(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public static void main(String[] args) {
        StockMarket sp500 = new StockMarket("SP500", "S&P 500");
        sp500.previousClosingPrice = 144.59;
        sp500.currentPrice = 144.75;

        System.out.println(sp500.name + " | " + sp500.symbol + " | " + sp500.getChangePercent());
    }

    public double getChangePercent() {
        return (currentPrice - previousClosingPrice) / previousClosingPrice;
    }
}
