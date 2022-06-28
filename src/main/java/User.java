public class User {
    private String login;
    private String password;
    private String email;
    private int age;

    public User(String login, String email, String password, int age) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void validateUser() throws AccessDeniedException {
        if (this.age < 18) throw new AccessDeniedException("Возраст менее 18 лет");
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String changeLogin(String newLogin) {
        this.login = newLogin;
        return this.login;
    }
}
