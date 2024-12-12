import java.util.Stack;

// Интерфейс команды
interface Command {
    void execute();
    void unexecute();
}

// Конкретная команда для вставки текста
class InsertTextCommand implements Command {
    private Document document;
    private String text;
    private int position;

    public InsertTextCommand(Document document, String text, int position) {
        this.document = document;
        this.text = text;
        this.position = position;
    }

    @Override
    public void execute() {
        document.insertText(text, position);
    }

    @Override
    public void unexecute() {
        document.deleteText(position, text.length());
    }
}

// Конкретная команда для удаления текста
class DeleteTextCommand implements Command {
    private Document document;
    private String text;
    private int position;

    public DeleteTextCommand(Document document, int position, int length) {
        this.document = document;
        this.position = position;
        this.text = document.getText().substring(position, position + length);
    }

    @Override
    public void execute() {
        document.deleteText(position, text.length());
    }

    @Override
    public void unexecute() {
        document.insertText(text, position);
    }
}

// Класс документа
class Document {
    private StringBuilder content = new StringBuilder();

    public void insertText(String text, int position) {
        content.insert(position, text);
    }

    public void deleteText(int position, int length) {
        content.delete(position, position + length);
    }

    public String getText() {
        return content.toString();
    }

    @Override
    public String toString() {
        return content.toString();
    }
}

// Класс для управления историей команд
class CommandHistory {
    private Stack<Command> history = new Stack<>();
    private Stack<Command> redoHistory = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
        redoHistory.clear();
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command command = history.pop();
            command.unexecute();
            redoHistory.push(command);
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            Command command = redoHistory.pop();
            command.execute();
            history.push(command);
        }
    }
}

// Основной класс для демонстрации
public class Main {
    public static void main(String[] args) {
        Document document = new Document();
        CommandHistory history = new CommandHistory();

        Command insertCommand1 = new InsertTextCommand(document, "Hello, ", 0);
        Command insertCommand2 = new InsertTextCommand(document, "world!", 7);

        history.executeCommand(insertCommand1);
        System.out.println(document);

        history.executeCommand(insertCommand2);
        System.out.println(document);

        // Проверка на наличие текста перед удалением
        if (document.getText().length() >= 7 + 6) {
            Command deleteCommand = new DeleteTextCommand(document, 7, 6);
            history.executeCommand(deleteCommand);
            System.out.println(document);
        }

        history.undo();
        System.out.println(document);

        history.redo();
        System.out.println(document);
    }
}
