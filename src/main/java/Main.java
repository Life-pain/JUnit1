public class Main {
    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите логин");
//        String login = scanner.nextLine();
//        System.out.println("Введите пароль");
//        String password = scanner.nextLine();

        String login = "jhon";
        String password = "jhonpass";

        getUserByLoginAndPassword(login, password).validateUser();

        System.out.println("Доступ предоставлен");
    }



    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) return user;
        }
        throw new UserNotFoundException("User not found");
    }

    public static User[] getUsers() {
        User user1 = new User("jhon", "jhon@gmail.com", "jhonpass", 24);
        User user2 = new User("martin", "martin@gmail.com", "martinpass", 23);
        User user3 = new User("kevin", "kevin@gmail.com", "kevinpass", 22);
        User user4 = new User("linda", "linda@gmail.com", "lindapass", 21);
        User user5 = new User("karl", "karl@gmail.com", "karlpass", 20);
        return new User[]{user1, user2, user3, user4, user5};
    }
}