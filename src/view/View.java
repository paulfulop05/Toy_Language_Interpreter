package view;

import controller.Controller;
import exceptions.MyException;

import java.util.ArrayList;

public record View(Controller controller, ArrayList<String> input) {

    public void printCommands(){
        IO.print("Commands:\n\n" +
                "exec -> Choose from a list of programs and execute it\n" +
                "exit -> Quit\n\n");
    }

    public void printPrograms() {
        for (int i = 0; i < input.size(); i++) {
            IO.print(i + 1 + " -> " + input.get(i) + '\n');
        }
        IO.print("0 -> qui this section\n\n");
    }

    public void start() throws MyException {
        printCommands();
        while(true){
            String command = IO.readln("> ").toLowerCase();
            switch (command){
                case "exec" -> {
                    while (true) {
                        printPrograms();
                        int pos = Integer.parseInt(IO.readln(">> ")) - 1;
                        if (pos == -1) break;

                        controller.executeProgram(pos);
                    }

                }
                case "exit" -> {
                    IO.print("Bye!\n");
                    System.exit(0);
                }
                default -> IO.print("Unknown command\n");
            }
        }
    }

}
