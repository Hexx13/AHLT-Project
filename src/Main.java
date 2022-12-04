import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
            Parser parser = new Parser();
            //TODO add conjunctive rules
            parser.parse("The green dog likes people and green people like dog");

        //new ParserGUI("ParserGui");

//        ParserTree tree = new ParserTree();
//        tree.addChild( new Word("A", "1", new POS("DT")));
//        tree.addChild( new Word("green", "1", new POS("JJ")));
//
//        System.out.println(((Word)(tree.getChild(1))).getWord());
    }
}
