import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public final class Main {
    private Main() {}

    public static void main(String... args) {
        try {
            CharStream input = new ANTLRFileStream(args[0]);
            AbschlussaufgabeLexer lex = new AbschlussaufgabeLexer(input);

            CommonTokenStream tokens = new CommonTokenStream(lex);
            AbschlussaufgabeParser parser = new AbschlussaufgabeParser(tokens);
            AbschlussaufgabeParser.program_return root = parser.program();

            CommonTreeNodeStream nodes = new CommonTreeNodeStream((Tree)root.tree);
            AbschlussaufgabeInterpreter walker = new AbschlussaufgabeInterpreter(nodes);
            walker.program();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
