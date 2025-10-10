// PROBLEM 9: Cryptocurrency Exchange Platform - Advanced Polymorphism with Interfaces

interface Tradeable {
    void buy(double amount);
    void sell(double amount);
    double getCurrentPrice();
    void displayInfo();
}

abstract class Cryptocurrency implements Tradeable {
    protected String name;
    protected String symbol;
    protected double currentPrice;
    protected double holdings;

    public Cryptocurrency(String name, String symbol, double currentPrice) {
        this.name = name;
        this.symbol = symbol;
        this.currentPrice = currentPrice;
        this.holdings = 0;
    }

    @Override
    public void buy(double amount) {
        holdings += amount;
        System.out.println("Bought " + amount + " " + symbol);
        System.out.println("Total holdings: " + holdings + " " + symbol);
    }

    @Override
    public void sell(double amount) {
        if (amount <= holdings) {
            holdings -= amount;
            System.out.println("Sold " + amount + " " + symbol);
            System.out.println("Remaining holdings: " + holdings + " " + symbol);
        } else {
            System.out.println("Insufficient holdings!");
        }
    }

    @Override
    public double getCurrentPrice() {
        return currentPrice;
    }

    @Override
    public void displayInfo() {
        System.out.println("\nCrypto: " + name + " (" + symbol + ")");
        System.out.println("Current Price: $" + currentPrice);
        System.out.println("Your Holdings: " + holdings + " " + symbol);
        System.out.println("Portfolio Value: $" + (holdings * currentPrice));
    }
}

class Bitcoin extends Cryptocurrency {
    private String blockchainVersion;
    private double miningDifficulty;

    public Bitcoin(double currentPrice, String blockchainVersion, double miningDifficulty) {
        super("Bitcoin", "BTC", currentPrice);
        this.blockchainVersion = blockchainVersion;
        this.miningDifficulty = miningDifficulty;
    }

    public void verifyBlockchain() {
        System.out.println("Verifying Bitcoin blockchain...");
        System.out.println("Blockchain version: " + blockchainVersion);
        System.out.println("Mining difficulty: " + miningDifficulty);
        System.out.println("Verification complete!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Bitcoin (BTC)");
        System.out.println("Blockchain: " + blockchainVersion);
        System.out.println("Mining Difficulty: " + miningDifficulty);
    }
}

class Ethereum extends Cryptocurrency {
    private boolean smartContractEnabled;
    private double gasFee;

    public Ethereum(double currentPrice, boolean smartContractEnabled, double gasFee) {
        super("Ethereum", "ETH", currentPrice);
        this.smartContractEnabled = smartContractEnabled;
        this.gasFee = gasFee;
    }

    public void deploySmartContract(String contractName) {
        if (smartContractEnabled) {
            System.out.println("Deploying smart contract: " + contractName);
            System.out.println("Gas fee: " + gasFee + " Gwei");
            System.out.println("Contract deployed successfully!");
        } else {
            System.out.println("Smart contracts not enabled!");
        }
    }

    public void calculateGasFee(int transactions) {
        double totalFee = gasFee * transactions;
        System.out.println("Gas fee for " + transactions + " transactions: " + totalFee + " Gwei");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Ethereum (ETH)");
        System.out.println("Smart Contracts: " + (smartContractEnabled ? "Enabled" : "Disabled"));
        System.out.println("Gas Fee: " + gasFee + " Gwei");
    }
}

class Stablecoin extends Cryptocurrency {
    private String pegCurrency;
    private double reserveBacking;

    public Stablecoin(String name, String symbol, double currentPrice, 
                     String pegCurrency, double reserveBacking) {
        super(name, symbol, currentPrice);
        this.pegCurrency = pegCurrency;
        this.reserveBacking = reserveBacking;
    }

    public void verifyPegMechanism() {
        System.out.println("Verifying peg to " + pegCurrency);
        System.out.println("Reserve backing: " + reserveBacking + "%");
        if (reserveBacking >= 100) {
            System.out.println("Peg is stable and fully backed");
        } else {
            System.out.println("Warning: Under-collateralized");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Stablecoin");
        System.out.println("Pegged to: " + pegCurrency);
        System.out.println("Reserve Backing: " + reserveBacking + "%");
    }
}

class NFT extends Cryptocurrency {
    private String metadata;
    private String ownerHistory;
    private String marketplace;

    public NFT(String name, double currentPrice, String metadata, 
              String ownerHistory, String marketplace) {
        super(name, "NFT", currentPrice);
        this.metadata = metadata;
        this.ownerHistory = ownerHistory;
        this.marketplace = marketplace;
    }

    public void displayMetadata() {
        System.out.println("NFT Metadata: " + metadata);
        System.out.println("Ownership History: " + ownerHistory);
        System.out.println("Listed on: " + marketplace);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Non-Fungible Token (NFT)");
        System.out.println("Marketplace: " + marketplace);
    }
}

class TradingAlgorithm {
    // Uniform trading across all crypto types
    public void executeTrade(Tradeable crypto, String action, double amount) {
        System.out.println("\n--- Executing Trade ---");
        if (action.equalsIgnoreCase("buy")) {
            crypto.buy(amount);
        } else if (action.equalsIgnoreCase("sell")) {
            crypto.sell(amount);
        }
        System.out.println("Current price: $" + crypto.getCurrentPrice());
    }

    // Access specific features when needed
    public void performSpecialOperations(Cryptocurrency crypto) {
        System.out.println("\n--- Special Operations ---");
        if (crypto instanceof Bitcoin) {
            Bitcoin btc = (Bitcoin) crypto;
            btc.verifyBlockchain();
        } else if (crypto instanceof Ethereum) {
            Ethereum eth = (Ethereum) crypto;
            eth.deploySmartContract("DecentralizedApp");
            eth.calculateGasFee(10);
        } else if (crypto instanceof Stablecoin) {
            Stablecoin stable = (Stablecoin) crypto;
            stable.verifyPegMechanism();
        } else if (crypto instanceof NFT) {
            NFT nft = (NFT) crypto;
            nft.displayMetadata();
        }
    }
}

public class Problem9 {
    public static void main(String[] args) {
        System.out.println("===== CRYPTOCURRENCY EXCHANGE PLATFORM =====");

        // Create different cryptocurrencies
        Cryptocurrency btc = new Bitcoin(45000, "v2.0", 25.5);
        Cryptocurrency eth = new Ethereum(3000, true, 50);
        Cryptocurrency usdt = new Stablecoin("Tether", "USDT", 1.00, "USD", 100);
        Cryptocurrency nft = new NFT("CryptoPunk #1234", 50000, 
                                     "Rare punk with attributes", 
                                     "Owner1->Owner2->Current", 
                                     "OpenSea");

        Cryptocurrency[] portfolio = {btc, eth, usdt, nft};
        TradingAlgorithm algorithm = new TradingAlgorithm();

        // Uniform trading operations
        System.out.println("\n===== TRADING OPERATIONS =====");
        algorithm.executeTrade(btc, "buy", 0.5);
        algorithm.executeTrade(eth, "buy", 2.0);
        algorithm.executeTrade(usdt, "buy", 1000);
        algorithm.executeTrade(nft, "buy", 1);

        // Display portfolio
        System.out.println("\n===== PORTFOLIO OVERVIEW =====");
        for (Cryptocurrency crypto : portfolio) {
            crypto.displayInfo();
        }

        // Specific operations
        System.out.println("\n===== CRYPTOCURRENCY-SPECIFIC OPERATIONS =====");
        for (Cryptocurrency crypto : portfolio) {
            algorithm.performSpecialOperations(crypto);
        }
    }
}
