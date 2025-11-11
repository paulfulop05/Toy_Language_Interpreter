import controller.Controller;
import exceptions.MyException;
import model.expressions.ArithmeticExpression;
import model.expressions.ValueExpression;
import model.expressions.VariableExpression;
import model.statements.*;
import model.states.ProgramState;
import model.types.BoolType;
import model.types.IntType;
import model.types.StringType;
import model.values.BoolValue;
import model.values.IntValue;
import model.values.StringValue;
import repo.ArrayListRepository;
import repo.Repository;
import view.ExitCommand;
import view.RunProgramCommand;
import view.TextMenu;
import java.util.Scanner;

void main() {

    // int v; v = 2; Print(v)
    StatementInterface ex1 = new CompoundStatement(
            new VariableDeclarationStatement("v", IntType.INSTANCE),
            new CompoundStatement(
                    new AssignStatement("v", new ValueExpression(new IntValue(2))),
                    new PrintStatement(new VariableExpression("v"))
            )
    );

    // int a; int b; a = 2 + 3 * 5; b = a + 1; Print(b)
    StatementInterface ex2 = new CompoundStatement(
            new VariableDeclarationStatement("a", IntType.INSTANCE),
            new CompoundStatement(
                    new VariableDeclarationStatement("b", IntType.INSTANCE),
                    new CompoundStatement(
                            new AssignStatement(
                                    "a",
                                    new ArithmeticExpression(
                                            "+",
                                            new ValueExpression(new IntValue(2)),
                                            new ArithmeticExpression(
                                                    "*",
                                                    new ValueExpression(new IntValue(3)),
                                                    new ValueExpression(new IntValue(5))
                                            )
                                    )
                            ),
                            new CompoundStatement(
                                    new AssignStatement(
                                            "b",
                                            new ArithmeticExpression(
                                                    "+",
                                                    new VariableExpression("a"),
                                                    new ValueExpression(new IntValue(1))
                                            )
                                    ),
                                    new PrintStatement(new VariableExpression("b"))
                            )
                    )
            )
    );

    // bool a; int v; a = true; (If a Then v = 2 Else v = 3); Print(v)
    StatementInterface ex3 = new CompoundStatement(
            new VariableDeclarationStatement("a", BoolType.INSTANCE),
            new CompoundStatement(
                    new VariableDeclarationStatement("v", IntType.INSTANCE),
                    new CompoundStatement(
                            new AssignStatement("a", new ValueExpression(new BoolValue(true))),
                            new CompoundStatement(
                                    new IfStatement(
                                            new VariableExpression("a"),
                                            new AssignStatement("v", new ValueExpression(new IntValue(2))),
                                            new AssignStatement("v", new ValueExpression(new IntValue(3)))
                                    ),
                                    new PrintStatement(new VariableExpression("v"))
                            )
                    )
            )
    );


    // string varf; varf="test.in"; openRFile(varf); int varc; readFile(varf,varc);print(varc);readFile(varf,varc);print(varc);closeRFile(varf)
    StatementInterface ex4 =
            new CompoundStatement(
                    new VariableDeclarationStatement("varf", StringType.INSTANCE),
                    new CompoundStatement(
                            new AssignStatement("varf", new ValueExpression(new StringValue("src/test.in"))),
                            new CompoundStatement(
                                    new OpenFileStatement(new VariableExpression("varf")),
                                    new CompoundStatement(
                                            new VariableDeclarationStatement("varc", IntType.INSTANCE),
                                            new CompoundStatement(
                                                    new ReadFileStatement(
                                                            new VariableExpression("varf"),
                                                            new VariableExpression("varc").toString()
                                                    ),
                                                    new CompoundStatement(
                                                            new PrintStatement(new VariableExpression("varc")),
                                                            new CompoundStatement(
                                                                    new ReadFileStatement(
                                                                            new VariableExpression("varf"),
                                                                            new VariableExpression("varc").toString()
                                                                    ),
                                                                    new CompoundStatement(
                                                                            new PrintStatement(new VariableExpression("varc")),
                                                                            new CloseFileStatement(new VariableExpression("varf"))
                                                                    )
                                                            )
                                                    )
                                            )
                                    )
                            )
                    )
            );

//      just in case
//    Scanner scanner = new Scanner(System.in);
//    IO.print("\nInsert the name of the file you want to save the logs into: ");
//    String fileName = "src/" + scanner.nextLine();

    Repository repository1 = new ArrayListRepository("src/log1.txt");
    Controller controller1 = new Controller(repository1);
    controller1.addNewProgram(ex1);

    Repository repository2 = new ArrayListRepository("src/log2.txt");
    Controller controller2 = new Controller(repository2);
    controller2.addNewProgram(ex2);


    Repository repository3 = new ArrayListRepository("src/log3.txt");
    Controller controller3 = new Controller(repository3);
    controller3.addNewProgram(ex3);

    Repository repository4 = new ArrayListRepository("src/log4.txt");
    Controller controller4 = new Controller(repository4);
    controller4.addNewProgram(ex4);

    TextMenu textMenu = new TextMenu();
    textMenu.addCommand(new ExitCommand("0", "exit"));
    textMenu.addCommand(new RunProgramCommand("1", ex1.toString(), controller1));
    textMenu.addCommand(new RunProgramCommand("2", ex2.toString(), controller2));
    textMenu.addCommand(new RunProgramCommand("3", ex3.toString(), controller3));
    textMenu.addCommand(new RunProgramCommand("4", ex4.toString(), controller4));
    textMenu.show();

}