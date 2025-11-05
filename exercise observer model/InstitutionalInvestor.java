public class InstitutionalInvestor implements Investor {
    private String companyName;

    public InstitutionalInvestor(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Institution " + companyName +
                " notified: " + stockSymbol + " is now $" + price);
    }
}
