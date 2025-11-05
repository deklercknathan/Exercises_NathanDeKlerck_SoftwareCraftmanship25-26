import java.util.ArrayList;
import java.util.List;

public class ConcreteStock implements Stock {
    private String stockSymbol;
    private double price;
    private List<Investor> investors = new ArrayList<>();

    public ConcreteStock(String stockSymbol, double price) {
        this.stockSymbol = stockSymbol;
        this.price = price;
    }

    @Override
    public void addInvestor(Investor investor) {
        investors.add(investor);
    }

    @Override
    public void removeInvestor(Investor investor) {
        investors.remove(investor);
    }

    @Override
    public void notifyInvestors() {
        for (Investor investor : investors) {
            investor.update(stockSymbol, price);
        }
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
        System.out.println("\nPrice of " + stockSymbol + " updated to $" + price);
        notifyInvestors();
    }
}
