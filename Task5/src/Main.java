import java.util.ArrayList;
import java.util.List;

// Интерфейс для подписчиков
interface Subscriber {
    void update(String message);
}

// Конкретный подписчик
class Reader implements Subscriber {
    private String name;

    public Reader(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }
}

// Интерфейс для публикаций
interface Blog {
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifySubscribers(String message);
}

// Конкретная реализация блога
class BlogPost implements Blog {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String title;
    private String content;

    public BlogPost(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }

    public void publish() {
        String message = "New blog post: " + title + "\nContent: " + content;
        notifySubscribers(message);
    }
}

// Основной класс для демонстрации
public class Main {
    public static void main(String[] args) {
        BlogPost blogPost = new BlogPost("New Features in Java 17", "Java 17 introduces several new features...");

        Subscriber reader1 = new Reader("Alice");
        Subscriber reader2 = new Reader("Bob");

        blogPost.addSubscriber(reader1);
        blogPost.addSubscriber(reader2);

        blogPost.publish();
    }
}
