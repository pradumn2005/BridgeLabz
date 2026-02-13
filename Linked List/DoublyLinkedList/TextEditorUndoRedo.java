class StateNode {
    String textState;
    StateNode next;
    StateNode prev;

    public StateNode(String text) {
        this.textState = text;
    }
}

public class TextEditorUndoRedo {
    StateNode current;
    
    public TextEditorUndoRedo() {
        current = new StateNode(""); 
    }

    public void type(String newText) {
        StateNode newState = new StateNode(current.textState + newText);
        current.next = newState;
        newState.prev = current;
        current = newState;
        System.out.println("Typed: " + current.textState);
    }

    public void undo() {
        if (current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.textState);
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.textState);
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    public static void main(String[] args) {
        TextEditorUndoRedo editor = new TextEditorUndoRedo();
        editor.type("Hello");
        editor.type(" World");
        editor.undo();
        editor.redo();
        editor.type("!");
    }
}
