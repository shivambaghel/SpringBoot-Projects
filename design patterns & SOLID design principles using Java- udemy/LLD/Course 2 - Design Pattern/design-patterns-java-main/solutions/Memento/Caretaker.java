package Memento;

import java.util.Stack;

public class Caretaker {
    
    private final Stack<EditorMemento> history = new Stack<>();

    public void saveState(GraphicEditor graphicEditor) {
        history.push(graphicEditor.save());
    }

    public void undo(GraphicEditor graphicEditor){
        if(!history.empty()){
            history.pop();
            graphicEditor.restore(history.peek());
        }
    }
}
