package E_Ticaret_Demo;

public class PasswordValidator {
	//Şifre length kontrol edilir
	//E-mail ile password validatorlerini "UserValidator" ile yapmak da bir diğer seçenektir.
    public boolean validate(String password) {
        return password.length() >= 6;
    }

}
