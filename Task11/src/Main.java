import java.util.Random;

// Интерфейс для прототипа
interface Prototype {
    Prototype clone();
}

// Класс для текстового документа
class TextDocument implements Prototype {
    private String content;

    public TextDocument(String content) {
        this.content = content;
    }

    @Override
    public Prototype clone() {
        return new TextDocument(content);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "TextDocument{" +
                "content='" + content + '\'' +
                '}';
    }
}

// Генератор случайных текстовых документов
class RandomTextDocumentGenerator {
    private static final String[] WORDS = {"Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit"};
    private Random random = new Random();

    public TextDocument generateRandomDocument() {
        StringBuilder content = new StringBuilder();
        int wordCount = random.nextInt(20) + 10; // Случайное количество слов от 10 до 30
        for (int i = 0; i < wordCount; i++) {
            content.append(WORDS[random.nextInt(WORDS.length)]).append(" ");
        }
        return new TextDocument(content.toString().trim());
    }
}

// Основной класс для демонстрации
public class Main {
    public static void main(String[] args) {
        RandomTextDocumentGenerator generator = new RandomTextDocumentGenerator();

        // Создаем прототип документа
        TextDocument prototypeDocument = generator.generateRandomDocument();
        System.out.println("Prototype Document: " + prototypeDocument);

        // Клонируем прототип и изменяем содержимое
        TextDocument clonedDocument1 = (TextDocument) prototypeDocument.clone();
        clonedDocument1.setContent("This is the first cloned document.");
        System.out.println("Cloned Document 1: " + clonedDocument1);

        TextDocument clonedDocument2 = (TextDocument) prototypeDocument.clone();
        clonedDocument2.setContent("This is the second cloned document.");
        System.out.println("Cloned Document 2: " + clonedDocument2);
    }
}
