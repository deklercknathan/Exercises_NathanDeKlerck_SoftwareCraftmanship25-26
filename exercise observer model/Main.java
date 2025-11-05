public class Main {
    public static void main(String[] args) {

        ConcreteStock appleStock = new ConcreteStock("AAPL", 150.00);

        Investor nathan = new IndividualInvestor("Nathan De Klerck");
        Investor bigBank = new InstitutionalInvestor("BigBank Capital");

        appleStock.addInvestor(nathan);
        appleStock.addInvestor(bigBank);

        appleStock.setPrice(155.50);
        appleStock.setPrice(160.75);

        appleStock.removeInvestor(nathan);

        appleStock.setPrice(165.00);
    }
}
