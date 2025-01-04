package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private final Map<String, CharacterFlyweight> characters = new HashMap<>();

    public CharacterFlyweight getCharacter(String fontStyle, int fontSize, String color) {
        String key = fontStyle + fontSize + color;
        
        if (!characters.containsKey(key)) {
            System.out.println("Creating new character: " + fontStyle + " " + fontSize + " " + color);
            characters.put(key, new ConcreteCharacter(fontStyle, fontSize, color));
        } else {
            System.out.println("Reusing character: " + fontStyle + " " + fontSize + " " + color);
        }
        
        return characters.get(key);
    }
}