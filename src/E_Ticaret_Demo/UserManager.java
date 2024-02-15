package E_Ticaret_Demo;

import java.util.ArrayList;
import java.util.List;
public class UserManager {
    private List<User> users = new ArrayList<>();
    //Kullanıcılar burada tutulur, tekrar kontrol edilmeyi kolaylaştırır
    private EMailValidator emailValidator = new EMailValidator();
    private PasswordValidator passwordValidator = new PasswordValidator();
    
    
    //E-mail yardımıyla kullanıcı bilgileri döndürülür
    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
    
    //verilen zorunluluklara uygunluk bakılarak kullanıcı kaydedilmesi yapılır
    public boolean register(String firstName, String lastName, String email, String password) {
        if (!emailValidator.validate(email)) {//e-mail kontrol
            System.out.println("Email format is incorrect.");
            return false;
        }

        if (!passwordValidator.validate(password)) {//şifre kontrol
            System.out.println("Password is too weak. It should be at least 6 characters long.");
            return false;
        }

        if (getUserByEmail(email) != null) { //getUserByEmail metodu ile mail varlığı sorgulanır
            System.out.println("A user with this email already exists.");
            return false;
        }

        if (firstName.length() < 2 || lastName.length() < 2) { //isim bilgileri sorgulanır
            System.out.println("First name and last name should be at least 2 characters long.");
            return false;
        }

        //kullanıcı gereksinimleri ile kullanıcı oluşturur ve kullanıcı listesine eklenir
        User user = new User(firstName, lastName, email, password);
        users.add(user);

        System.out.println("User registered successfully. Verification email has been sent.");
        return true;
    }
    //e-mail ve şifreyi alır doğruysa başarı mesajı verilir
    public User login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login successful.");
                return user;
            }
        }

        System.out.println("Login failed. Please check your email and password.");
        return null;
    }

  //Mail gönderilir.

    public void sendVerificationEmail(User user) {
        System.out.println("Verification email sent to " + user.getEmail());
    }
}
