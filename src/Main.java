import controller.Controller;
import exceptions.MyException;
import model.expressions.ArithmeticExpression;
import model.expressions.ValueExpression;
import model.expressions.VariableExpression;
import model.statements.*;
import model.types.BoolType;
import model.types.IntType;
import model.values.BoolValue;
import model.values.IntValue;
import repo.ArrayListRepository;
import repo.Repository;
import view.TextMenu;

void main() throws MyException {
    // TODO change from MyException to the actual exception i want.
    // TODO file statements (2.6, 2.7, 2.8, *2.9)
    // TODO FileTable
    // TODO change from TextMenu to TextMenu (with private Map<String, Command> commands;)
    // TODO add Command class -> which has to be abstract apparently, and it does have subclasses (e.g. ExitCommand etc)
    // TODO maybe change to Scanner class for reading from console everywhere

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


    Repository repository = new ArrayListRepository("");
    Controller controller = new Controller(repository);
    ArrayList<String> input = new  ArrayList<>();
    input.add("int v; v = 2; Print(v)");
    input.add("int a; int b; a = 2 + 3 * 5; b = a + 1; Print(b)");
    input.add("bool a; int v; a = true; (If a Then v = 2 Else v = 3); Print(v)");

    // all of them work
    controller.addNewProgram(ex1);
    controller.addNewProgram(ex2);
    controller.addNewProgram(ex3);
    TextMenu view = new TextMenu(controller, input);
    view.start();
}