package ClasseAdvencedWars;



/**
 * 
 */
public class Team {
    
    /**
     * 
     */
    private int money;

    /**
     * 
     */
    private int income;
    
    /**
     * 
     */
    private final String name;
    
    /**
     * Default constructor
     */
    public Team(String name){
        this.name = name;
        this.money = 0;
        this.income = 0;
    }

    public int getMoney() {
        return money;
    }
    
    public void pay(int price){
        this.money -= price;
    }
    
    public String getName() {
        return name;
    }
    
    public void ChangeIncome(int i){
        this.income += i;
    }
    
    public void onEndTurn(){
        this.money+=this.income;
    }
    
    
    //TEST PROVISIOIRE
    public int getIncome(){
        return this.income;
    }
}