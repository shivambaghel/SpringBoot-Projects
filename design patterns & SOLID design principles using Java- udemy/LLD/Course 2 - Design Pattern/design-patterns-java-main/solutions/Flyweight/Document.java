package Flyweight;

public class Document {
    private final StringBuilder content = new StringBuilder();
    private final CharacterFactory characterFactory = new CharacterFactory();

    public void addCharacter(String character, String fontStyle, int fontSize, String color) {
        CharacterFlyweight characterFlyweight = characterFactory.getCharacter(fontStyle, fontSize, color);
        content.append(character);
        characterFlyweight.display(character);
    }

    public void render() {
        System.out.println("Document Content: " + content.toString());
    }
}