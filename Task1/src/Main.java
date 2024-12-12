public class Main {
    public static void main(String[] args) {
        AuthMethod authByPassword = AuthFactory.getAuthMethod("password");
        authByPassword.authenticate();

        AuthMethod authByFingerprint = AuthFactory.getAuthMethod("fingerprint");
        authByFingerprint.authenticate();

        AuthMethod authBySocialMedia = AuthFactory.getAuthMethod("socialmedia");
        authBySocialMedia.authenticate();
    }
}
