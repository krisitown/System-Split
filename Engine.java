import Controllers.MainController;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Engine {
    private MainController mainController;
    private Scanner scanner;

    public Engine(){
        mainController = new MainController();
        scanner = new Scanner(System.in);
    }

    public void run(){
        String input = scanner.nextLine();
        while (!input.equals("System Split")){
            String[] commandParams = parseCommand(input);
            String[] methodParams = new String[commandParams.length-1];
            System.arraycopy(commandParams, 1, methodParams, 0, commandParams.length - 1);

            //black magic a.k.a reflection
            try{
                Method method = mainController.getClass().getMethod(commandParams[0], String[].class);
                method.setAccessible(true);
                method.invoke(mainController, new Object[] {methodParams});
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored){

            }
            input = scanner.nextLine();
        }
        mainController.systemSplit();
    }

    private String[] parseCommand(String input){
        String[] tokens = input.split("\\(");
        String commandName = tokens[0];
        tokens[1] = tokens[1].replaceAll("\\)", "");
        String[] commandParams = tokens[1].split(", ");

        String[] returnArray = new String[commandParams.length + 1];
        returnArray[0] = commandName;

        for (int i = 0; i < commandParams.length; i++) {
            returnArray[i + 1] = commandParams[i];
        }

        return returnArray;
    }
}
