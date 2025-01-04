package Memento;

public class GraphicEditor {
    
    private String shapeType;
    private int x;
    private int y;
    private String color;
    private int size;

    public EditorMemento save() {
        return new EditorMemento(shapeType, x, y, color, size);
    }

    public void restore(EditorMemento memento) {
        this.shapeType = memento.getShapeType();
        this.x = memento.getX();
        this.y = memento.getY();
        this.color = memento.getColor();
        this.size = memento.getSize();
    }

    public String getShape() {
        return "Shape: " + shapeType + ", Position: (" + x + ", " + y + "), Color: " + color + ", Size: " + size;
    }

    public void setShape(String shapeType, int x, int y, String color, int size) {
        this.shapeType = shapeType;
        this.x = x;
        this.y = y;
        this.color = color;
        this.size = size;
    }
}
