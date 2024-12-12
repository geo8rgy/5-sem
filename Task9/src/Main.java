import java.util.LinkedList;
import java.util.Queue;

// Интерфейс для задания печати
interface PrintJob {
    void print();
}

// Конкретная реализация задания печати
class DocumentPrintJob implements PrintJob {
    private String documentName;

    public DocumentPrintJob(String documentName) {
        this.documentName = documentName;
    }

    @Override
    public void print() {
        System.out.println("Printing document: " + documentName);
    }
}

// Сервис печати
class PrintService {
    private Queue<PrintJob> printQueue = new LinkedList<>();
    private boolean isPrinting = false;

    // Метод для добавления задания в очередь
    public synchronized void addPrintJob(PrintJob printJob) {
        printQueue.add(printJob);
        if (!isPrinting) {
            startPrinting();
        }
    }

    // Метод для начала печати
    private synchronized void startPrinting() {
        if (isPrinting) {
            return;
        }
        isPrinting = true;
        new Thread(() -> {
            while (!printQueue.isEmpty()) {
                PrintJob printJob = printQueue.poll();
                if (printJob != null) {
                    printJob.print();
                }
            }
            isPrinting = false;
        }).start();
    }
}

// Основной класс для демонстрации
public class Main {
    public static void main(String[] args) {
        PrintService printService = new PrintService();

        PrintJob job1 = new DocumentPrintJob("Document1.pdf");
        PrintJob job2 = new DocumentPrintJob("Document2.pdf");
        PrintJob job3 = new DocumentPrintJob("Document3.pdf");

        printService.addPrintJob(job1);
        printService.addPrintJob(job2);
        printService.addPrintJob(job3);
    }
}
