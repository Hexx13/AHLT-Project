import org.w3c.dom.Node;

import java.util.*;

public class ParserTreeNode {

    Word word;

    public POS getPos() {
        return pos;
    }

    public void setPos(POS pos) {
        this.pos = pos;
    }

    private POS pos;
    List<ParserTreeNode> children;
    ParserTreeNode parent;

    //leaf
    public ParserTreeNode(Word word){
        this.word = word;
        this.pos = word.getPos();
    }
    //not leaf
    ParserTreeNode(POS pos, List<ParserTreeNode> children){
        this.pos = pos;
        this.children = children;
    }

    public boolean isLeaf(){
        return children != null;
    }

    @Override
    public String toString() {
        if(word !=null){
            return ""+ word;
        }else
        return
                 pos +
                "" + children
                ;
    }


//    public boolean addChild(Word n) {
//        return childrenList.add(n);
//        //return children.add(n);
//    }
//    public boolean removeChild(TreeNode n) {
//        return true;
//    }

//    public Word getChild(int n) {
//        return childrenList.get(n);
//    }
//    public Iterator<TreeNode> iterator() {
//        return children.iterator();
//    }

}
