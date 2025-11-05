public class IndividualInvestor implements Investor {
    private String name;

    public IndividualInvestor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Individual Investor " + name +
                " notified: " + stockSymbol + " is now $" + price);
    }
}
