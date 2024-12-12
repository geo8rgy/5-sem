public class AuthFactory {

    public static AuthMethod getAuthMethod(String type) {
        switch (type.toLowerCase()) {
            case "password":
                return new PasswordAuth();
            case "fingerprint":
                return new FingerprintAuth();
            case "socialmedia":
                return new SocialMediaAuth();
            default:
                throw new IllegalArgumentException("Unknown authentication type: " + type);
        }
    }
}

