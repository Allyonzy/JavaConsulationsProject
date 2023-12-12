import repository.UserRepository;
import repository.UserRepositoryImpl;

public class App {
    public static void main(String[] args) {
        System.out.println("Программа работы с файлом пользователей");
        UserRepository userRepository = new UserRepositoryImpl();
        String color = "Красный";

        Double averageAge = userRepository.findAverageAgeByAvatarColor(color);
        System.out.printf("Средний возраст команды с красным аватаром %.2f", averageAge);

        System.out.println();

        String nameWithMinAge = userRepository.findNameByMinAge();
        System.out.printf("Имя человека с минимальным возрастом %s", nameWithMinAge);

    }
}