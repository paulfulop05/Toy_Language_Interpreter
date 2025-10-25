package view;

import controller.Controller;
import exceptions.MyException;

public record View(Controller controller) {

    public void printCommands(){
        IO.print("Commands:\n\n" +
                "exec -> Choose from a list of programs and execute it\n" +
                "exit -> Quit\n\n");
    }

    public void printPrograms(){
        IO.print("1 -> int v; v = 2; Print(v)\n" +
                 "2 -> int a; int b; a = 2 + 3 * 5; b = a + 1; Print(b)\n" +
                 "3 -> bool a; int v; a = true; (If a Then v = 2 Else v = 3); Print(v)\n" +
                 "4 -> exit this page\n");
    }

    public void start() throws MyException {
        printCommands();
        while(true){
            String command = IO.readln("> ").toLowerCase();
            switch (command){
                case "exec" -> {
                    printCommands();

                    while (true) {
                        int pos = Integer.getInteger(IO.readln(">> "));
                        if (pos == 4) break;

                        controller.executeProgram(pos);
                    }

                }
                case "exit" -> {
                    IO.print("Bye!\n\n");
                    System.exit(0);
                }
            }
        }
    }

}
