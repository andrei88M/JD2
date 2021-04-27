package group.person;

public class Generate {
    public static String getRandomName() {
        return (int) (Math.random() * 9 + 1) + "name";
    }

    public static String getRandomSurname() {
        return (int) (Math.random() * 9 + 1) + "surname";
    }

    public static int getRandomAge(int from, int to) {
        return (int) (Math.random() * (to + 1 - from) + from);
    }
}
