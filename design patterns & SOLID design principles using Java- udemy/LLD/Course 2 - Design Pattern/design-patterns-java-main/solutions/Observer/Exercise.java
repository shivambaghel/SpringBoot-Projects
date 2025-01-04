package Observer;

import java.util.Scanner;

public class Exercise {
    
    public void run() {
        
        Scanner sc = new Scanner(System.in);
        
        double priceChangeThreshold = sc.nextDouble();
        StockMarket stockMarket = new StockMarket(priceChangeThreshold);

        InvestorA investorA = new InvestorA();
        InvestorB investorB = new InvestorB();

        stockMarket.registerObserver(investorA);
        stockMarket.registerObserver(investorB);

        int updates = sc.nextInt();
        
        for (int i = 1; i <= updates; i++) {
            
            if(i == 5) {
                stockMarket.removeObserver(investorB);
            }
            
            String stockSymbol = sc.next();
            double newPrice = sc.nextDouble();
            double oldPrice = sc.nextDouble();
            
            stockMarket.setStockPrice(stockSymbol, newPrice, oldPrice);
        }
        sc.close();
    }
}
