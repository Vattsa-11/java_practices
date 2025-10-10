// Problem 3: Game and Card Game Objects

class Game {
    protected String name;
    protected int players;
    
    public Game(String name, int players) {
        this.name = name;
        this.players = players;
    }
    
    @Override
    public String toString() {
        return "Game: " + name + ", Players: " + players;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Game game = (Game) obj;
        return players == game.players && name.equals(game.name);
    }
    
    @Override
    public int hashCode() {
        return name.hashCode() + players;
    }
}

class CardGame extends Game {
    private int deckSize;
    private String cardType;
    
    public CardGame(String name, int players, int deckSize, String cardType) {
        super(name, players);
        this.deckSize = deckSize;
        this.cardType = cardType;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Deck Size: " + deckSize + ", Card Type: " + cardType;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        
        CardGame cardGame = (CardGame) obj;
        return deckSize == cardGame.deckSize && cardType.equals(cardGame.cardType);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() + deckSize + cardType.hashCode();
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Game game1 = new Game("Chess", 2);
        Game game2 = new Game("Chess", 2);
        Game game3 = new Game("Monopoly", 4);
        
        CardGame card1 = new CardGame("Poker", 4, 52, "Standard");
        CardGame card2 = new CardGame("Poker", 4, 52, "Standard");
        CardGame card3 = new CardGame("UNO", 4, 108, "Special");
        
        System.out.println("toString() test:");
        System.out.println(game1);
        System.out.println(card1);
        
        System.out.println("\nequals() test:");
        System.out.println("game1.equals(game2): " + game1.equals(game2));
        System.out.println("game1.equals(game3): " + game1.equals(game3));
        System.out.println("card1.equals(card2): " + card1.equals(card2));
        System.out.println("card1.equals(card3): " + card1.equals(card3));
        
        System.out.println("\nhashCode() test:");
        System.out.println("game1 hashCode: " + game1.hashCode());
        System.out.println("game2 hashCode: " + game2.hashCode());
        System.out.println("card1 hashCode: " + card1.hashCode());
        System.out.println("card2 hashCode: " + card2.hashCode());
    }
}