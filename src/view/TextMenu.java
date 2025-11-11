package view;

import controller.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextMenu {
    private final Map<String, Command> commands;
    public TextMenu(){
        commands = new HashMap<>();
    }

    public void addCommand(Command command){
        commands.put(command.getKey(), command);
    }

    public void printCommands(){
        IO.println("Commands:\n");
        for (var command : commands.values()){
            String line = String.format("%4s : %s", command.getKey(), command.getDescription());
            IO.println(line);
        }
    }

    public void show(){

        Scanner scanner = new Scanner(System.in);
        while(true){
            printCommands();
            IO.print("Input the option: ");
            String key = scanner.nextLine();
            Command com = commands.get(key);

            if (com == null){
                System.out.println("Invalid Option");
                continue;
            }
            com.execute();
        }
    }
}

//    public void start() {
//        printCommands();
//        while(true){
//            String command = IO.readln("> ").toLowerCase();
//            switch (command){
//                case "exec" -> {
//                    while (true) {
//                        printPrograms();
//
//                        try{
//                            int pos = Integer.parseInt(IO.readln(">> ")) - 1;
//                            if (pos == -1) {
//                                IO.println("Exiting this section...\n");
//                                break;
//                            }
//                            IO.println();
//
//                            controller.executeProgram(pos);
//                        }
//                        catch (Exception e) {
//                            IO.println(e.getMessage());
//                        }
//                    }
//                }
//                case "exit" -> {
//                    IO.print("Bye!\n");
//                    System.exit(0);
//                }
//                default -> IO.print("Unknown command\n");
//            }
//        }
//    }
