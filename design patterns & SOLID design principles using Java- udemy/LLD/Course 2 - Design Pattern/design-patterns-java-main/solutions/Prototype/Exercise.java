package Prototype;

import java.util.Scanner;

public class Exercise {
    
    public void run() {
        
        Scanner sc = new Scanner(System.in);

        String warriorName = sc.nextLine();

        int health = sc.nextInt();

        int attackPower = sc.nextInt();

        int defense = sc.nextInt();

        Warrior warrior = new Warrior(warriorName, health, attackPower, defense);

        Warrior clonedWarrior = warrior.clone();
        
        int clonedHealth = sc.nextInt();

        int clonedAttackPower = sc.nextInt();

        int clonedDefense = sc.nextInt();

        clonedWarrior.setHealth(clonedHealth);
        clonedWarrior.setAttackPower(clonedAttackPower);
        clonedWarrior.setDefense(clonedDefense);
        
        System.out.println("Original Character:");
        warrior.displayAttributes();

        System.out.println("Cloned Character:");
        clonedWarrior.displayAttributes();

        sc.close();
    }
}
