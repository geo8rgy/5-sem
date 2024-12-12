// Абстрактный класс для мобильного приложения
abstract class MobileApp {
    // Шаблонный метод для отображения интерфейса и обработки событий
    public final void run() {
        initialize();
        displayInterface();
        handleEvents();
        terminate();
    }

    // Абстрактные методы, которые должны быть реализованы подклассами
    protected abstract void initialize();
    protected abstract void displayInterface();
    protected abstract void handleEvents();
    protected abstract void terminate();
}

// Конкретная реализация для iOS приложения
class IOSApp extends MobileApp {
    @Override
    protected void initialize() {
        System.out.println("Initializing iOS app");
    }

    @Override
    protected void displayInterface() {
        System.out.println("Displaying iOS interface");
    }

    @Override
    protected void handleEvents() {
        System.out.println("Handling iOS events");
    }

    @Override
    protected void terminate() {
        System.out.println("Terminating iOS app");
    }
}

// Конкретная реализация для Android приложения
class AndroidApp extends MobileApp {
    @Override
    protected void initialize() {
        System.out.println("Initializing Android app");
    }

    @Override
    protected void displayInterface() {
        System.out.println("Displaying Android interface");
    }

    @Override
    protected void handleEvents() {
        System.out.println("Handling Android events");
    }

    @Override
    protected void terminate() {
        System.out.println("Terminating Android app");
    }
}

// Конкретная реализация для Windows приложения
class WindowsApp extends MobileApp {
    @Override
    protected void initialize() {
        System.out.println("Initializing Windows app");
    }

    @Override
    protected void displayInterface() {
        System.out.println("Displaying Windows interface");
    }

    @Override
    protected void handleEvents() {
        System.out.println("Handling Windows events");
    }

    @Override
    protected void terminate() {
        System.out.println("Terminating Windows app");
    }
}

// Основной класс для демонстрации
public class Main {
    public static void main(String[] args) {
        MobileApp iosApp = new IOSApp();
        MobileApp androidApp = new AndroidApp();
        MobileApp windowsApp = new WindowsApp();

        System.out.println("Running iOS app:");
        iosApp.run();

        System.out.println("\nRunning Android app:");
        androidApp.run();

        System.out.println("\nRunning Windows app:");
        windowsApp.run();
    }
}
