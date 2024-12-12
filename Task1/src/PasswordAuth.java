public class PasswordAuth implements AuthMethod {
    @Override
    public void authenticate() {
        System.out.println("Authenticating using password.");
        // Логика аутентификации по паролю
    }
}
