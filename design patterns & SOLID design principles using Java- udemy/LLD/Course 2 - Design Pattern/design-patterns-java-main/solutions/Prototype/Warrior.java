package Prototype;

public class Warrior implements Character {
    
    private String name;
    private int health;
    private int attackPower;
    private int defense;

    public Warrior(String name, int health, int attackPower, int defense) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defense = defense;
    }

    @Override
    public Warrior clone() {
        return new Warrior(name, health, attackPower, defense);
    }

    @Override
    public void displayAttributes() {
        System.out.println("Warrior - Name: " + name + ", Health: " + health + ", Attack Power: " + attackPower + ", Defense: " + defense);
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefense() {
        return defense;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}