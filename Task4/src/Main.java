// Интерфейс для облачного хранилища
interface CloudStorage {
    void uploadFile(String filePath);
    void downloadFile(String filePath);
    void deleteFile(String filePath);
}

// Адаптер для Google Drive
class GoogleDriveAdapter implements CloudStorage {
    private GoogleDrive googleDrive;

    public GoogleDriveAdapter(GoogleDrive googleDrive) {
        this.googleDrive = googleDrive;
    }

    @Override
    public void uploadFile(String filePath) {
        googleDrive.uploadToGoogleDrive(filePath);
    }

    @Override
    public void downloadFile(String filePath) {
        googleDrive.downloadFromGoogleDrive(filePath);
    }

    @Override
    public void deleteFile(String filePath) {
        googleDrive.deleteFromGoogleDrive(filePath);
    }
}

// Адаптер для Dropbox
class DropboxAdapter implements CloudStorage {
    private Dropbox dropbox;

    public DropboxAdapter(Dropbox dropbox) {
        this.dropbox = dropbox;
    }

    @Override
    public void uploadFile(String filePath) {
        dropbox.uploadToDropbox(filePath);
    }

    @Override
    public void downloadFile(String filePath) {
        dropbox.downloadFromDropbox(filePath);
    }

    @Override
    public void deleteFile(String filePath) {
        dropbox.deleteFromDropbox(filePath);
    }
}

// Адаптер для OneDrive
class OneDriveAdapter implements CloudStorage {
    private OneDrive oneDrive;

    public OneDriveAdapter(OneDrive oneDrive) {
        this.oneDrive = oneDrive;
    }

    @Override
    public void uploadFile(String filePath) {
        oneDrive.uploadToOneDrive(filePath);
    }

    @Override
    public void downloadFile(String filePath) {
        oneDrive.downloadFromOneDrive(filePath);
    }

    @Override
    public void deleteFile(String filePath) {
        oneDrive.deleteFromOneDrive(filePath);
    }
}

// Класс для Google Drive
class GoogleDrive {
    public void uploadToGoogleDrive(String filePath) {
        System.out.println("Uploading to Google Drive: " + filePath);
    }

    public void downloadFromGoogleDrive(String filePath) {
        System.out.println("Downloading from Google Drive: " + filePath);
    }

    public void deleteFromGoogleDrive(String filePath) {
        System.out.println("Deleting from Google Drive: " + filePath);
    }
}

// Класс для Dropbox
class Dropbox {
    public void uploadToDropbox(String filePath) {
        System.out.println("Uploading to Dropbox: " + filePath);
    }

    public void downloadFromDropbox(String filePath) {
        System.out.println("Downloading from Dropbox: " + filePath);
    }

    public void deleteFromDropbox(String filePath) {
        System.out.println("Deleting from Dropbox: " + filePath);
    }
}

// Класс для OneDrive
class OneDrive {
    public void uploadToOneDrive(String filePath) {
        System.out.println("Uploading to OneDrive: " + filePath);
    }

    public void downloadFromOneDrive(String filePath) {
        System.out.println("Downloading from OneDrive: " + filePath);
    }

    public void deleteFromOneDrive(String filePath) {
        System.out.println("Deleting from OneDrive: " + filePath);
    }
}

// Основной класс для демонстрации
public class Main {
    public static void main(String[] args) {
        GoogleDrive googleDrive = new GoogleDrive();
        Dropbox dropbox = new Dropbox();
        OneDrive oneDrive = new OneDrive();

        CloudStorage googleDriveAdapter = new GoogleDriveAdapter(googleDrive);
        CloudStorage dropboxAdapter = new DropboxAdapter(dropbox);
        CloudStorage oneDriveAdapter = new OneDriveAdapter(oneDrive);

        googleDriveAdapter.uploadFile("file1.txt");
        googleDriveAdapter.downloadFile("file1.txt");
        googleDriveAdapter.deleteFile("file1.txt");

        dropboxAdapter.uploadFile("file2.txt");
        dropboxAdapter.downloadFile("file2.txt");
        dropboxAdapter.deleteFile("file2.txt");

        oneDriveAdapter.uploadFile("file3.txt");
        oneDriveAdapter.downloadFile("file3.txt");
        oneDriveAdapter.deleteFile("file3.txt");
    }
}
