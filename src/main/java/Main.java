import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<Details> dump = Dump.getRandomDetails(20);
        Map<String, Details> trophy1 = Scientist.initialize();
        Map<String, Details> trophy2 = Scientist.initialize();
        Runnable factory = () -> Dump.add(dump, 1, 4);
        Runnable scientist1 = () -> Dump.take(dump, 1, 4, trophy1);
        Runnable scientist2 = () -> Dump.take(dump, 1, 4, trophy2);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 100; i++) {
            executorService.submit(factory);
            executorService.submit(scientist1);
            executorService.submit(scientist2);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        Scientist.checkWinner(trophy1, trophy2);

        Locale locale =new Locale("fr","CA");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("res",locale);
        System.out.println(resourceBundle.getString("sas"));
    }
}