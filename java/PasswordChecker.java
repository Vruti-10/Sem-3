public class PasswordChecker {

    
    public boolean checkLength(String pw) {
        return pw.length() >= 8;
    }

    
    public boolean checkUppercase(String pw) {
        return pw.matches(".*[A-Z].*");
    }

    
    public boolean checkDigit(String pw) {
        return pw.matches(".*[0-9].*");
    }

    
    public boolean checkSpecial(String pw) {
        return pw.matches(".*[^a-zA-Z0-9].*");
    }

    public boolean 
}
