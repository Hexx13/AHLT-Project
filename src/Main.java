import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
            Parser parser = new Parser();
            //TODO add conjunctive rules
        //parser.parse("Oooga booga, hunt animal, breed woman");
        boolean result = parser.parse("The green dog likes people ");
        if(!result) System.out.println("Invalid grammar or unknown word");
        //new ParserGUI("ParserGui");


    }
}
