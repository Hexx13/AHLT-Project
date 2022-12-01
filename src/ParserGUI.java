import javax.swing.*;

public class ParserGUI extends JFrame {
    private JButton submit;
    private JTextField textField;
    private JTextArea bracketsArea;
    private JPanel treePane;
    private JPanel mainPan;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    public ParserGUI(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPan);
        this.pack();
        this.setVisible(true);
    }
}
