import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/*TODO
 * Tree Visualization
 * GUI
 * Document code
 * Write Paper
 */
/**
 *
 */
public class Parser {
    private List<Word> lexicon;
    private List<Rule> rules;
    private List<POS> partsOfSpeech;

    //private List<Word> inputWords;

    /**
     * Constructor assigns objects for lexicon, rules and populates them
     * @throws IOException due to use of BufferedReader and FileReader
     */
    public Parser() throws IOException {
        //Initialize Lists
        lexicon = new ArrayList<Word>();
        rules = new ArrayList<Rule>();
        partsOfSpeech = new ArrayList<POS>();
        //inputWords = new ArrayList<Word>();

        //Populate Lists
        populateRule();
        populateLexicon();

    }
    void populatePOS() {
        try {
            // Buffered reader, reads file, tokenizes it, and adds it to the list
            BufferedReader bf = new BufferedReader(new FileReader("src/POS.txt"));
            StringTokenizer st = new StringTokenizer(bf.readLine(), ",");
            while (st.hasMoreTokens()) {
                partsOfSpeech.add(new POS(st.nextToken()));
            }

        } catch (IOException e){
            System.out.println("Error: " + e);
        }
    }

    /**
     * Populates the lexicon with words from the lexicon.txt file
     * @throws IOException due to use of BufferedReader and FileReader
     */
    public void populateLexicon() throws IOException {
        //reader for lexicon.txt
        BufferedReader br = new BufferedReader(new FileReader("lexicon.txt"));
        String line = "";
        //loop until end of file
        while ((line = br.readLine()) != null) {
            //tokenize the line
            StringTokenizer st = new StringTokenizer(line, ";");
            //create a new word object
            Word word = new Word();
            //Populate word object with values from lexicon.txt
            word.setWord(st.nextToken());
            word.setPos(new POS(st.nextToken()));
            word.setAmnt(st.nextToken());
            //add word to lexicon
            lexicon.add(word);
        }
    }

    /**
     * Populates the rules with rules from the rules.txt file
     * @throws IOException due to use of BufferedReader and FileReader
     */
    void populateRule() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("rules.txt"));

        String line = "";
        while (line != null) {

            //get next line
            line = br.readLine();

            //if line is null end parsing
            if(line == null){
                break;
            }

            //create new rule object
            Rule rule = new Rule();

            //tokenize rule POS'
            StringTokenizer st = new StringTokenizer(line, ",");

            //add them to POS list in the rule object
            while(st.hasMoreTokens()){
                rule.addPOS(new POS(st.nextToken()));
            }

            //read the next line which has the rule name
            rule.setRule(br.readLine());

            //add rule to parser rule list
            rules.add(rule);
        }
    }

    //takes in the input and adds stuff to "tree"
    boolean parse(String input) {
        //parse input and store it in
        List<ParserTreeNode> tree = parseInput(input);
        if(tree == null){return false;}


        while (!"S".equals(tree.get(0).getPos().getPosString())){
            tree = determineRule(tree);
        }

        System.out.println(tree.get(0).toString().replaceAll("[^a-z A-Z \\] \\[]", ""));


        return true;
    }

    //clean input and assigns POS to words
    List<ParserTreeNode> parseInput(String sentence) {
        List<Word> inputWords = new ArrayList<Word>();
        List<String> compare = new ArrayList<String>();
        List<ParserTreeNode> tree = new ArrayList<ParserTreeNode>();
        //clean sentence of any other possible characters apart from letters and spaces
        sentence = sentence.replaceAll("[^a-z A-Z]", "");
        //tokenize sentence
        StringTokenizer st = new StringTokenizer(sentence, " ");

        while (st.hasMoreTokens()) {

            Word word = new Word();
            String wordString = st.nextToken();
            compare.add(wordString);
            //check if word is in lexicon
            for (Word w : lexicon) {
                if (w.getWord().equals(wordString)) {
                    word.setPos(w.getPos());
                    word.setWord(wordString);
                    //System.out.println(word.toString());
                    inputWords.add(word);
                    tree.add(new ParserTreeNode(word));
                }
            }
        }
        //System.out.println(compare.size() + " " + inputWords.size());
        if (compare.size() == inputWords.size()){return tree;}
        else {
            return null;
        }
        //return inputWords;
    }

    //reccursive search for rules for an inputted list
    List<ParserTreeNode> determineRule(List<ParserTreeNode> children) {

        //when a rule is found assign leafs to the rule node
        Rule rule;
        ParserTreeNode phrase = null;
        List<ParserTreeNode> parseList = new ArrayList<ParserTreeNode>();

        List<ParserTreeNode> parsed = new ArrayList<ParserTreeNode>();

        for(int i = 0; i < children.size(); i++){
            List<ParserTreeNode> parsedChildren = new ArrayList<ParserTreeNode>();
            parseList.add(children.get(i));

            //Debug statements
            rule = compareRule(parseList);
//            System.out.println("New itteration");
//            System.out.println("Trying parseList of pos: ");
//            for (ParserTreeNode node : parseList) {
//                System.out.println(" Rule:  "+ node.getPos().getPosString());
//            }
            if(rule != null){
                for (ParserTreeNode node : parseList) {
                    parsedChildren.add(node);
                }
                parsed.add(new ParserTreeNode(new POS(rule.getRule()), parsedChildren));
                System.out.println("Found rule: "+rule.getRule());
                parseList.clear();

            }
        }
        return parsed;
    }


    /**This method determines the match of the POS parameter list based on the global POS rule list.
     * It is assumed that the rules are in order of least complex to most complex in respect of amounts of POS
     * @param list is a list of POS objects
     * @return a Rule object if the rule is found otherwise returns Null
     */
    private Rule compareRule(List<ParserTreeNode> list){
        //boolean to determine if the rule matches
        boolean match = false;
        //declare Rule object to be returned, assigned null to return if no match is found
        Rule returnRule = null;
        //loop through all rules
        for(Rule rule: rules){
            //assign list of rules to new list for code readability
            List<POS> rulePOSList = rule.getPosList();

            //check if the size of the rule is the same as the list to reduce processing time
            if(list.size() == rulePOSList.size()){

                //loop through all POS passed as parameter
                for (int i = 0; i < list.size(); i++) {
                    //System.out.println("  "+ list.get(i).getPosString());

                    //Assign current POS and Rule POS to new variables for code readability
                    String wordPOS = list.get(i).getPos().getPosString();
                    String rulePOS = rulePOSList.get(i).getPosString();

                    //Determine if given POS matches the rule
                    if(!(wordPOS.equals(rulePOS))){

                        //If the POS does not match the rule, set match to false and go to next rule
                        match = false;
                        break;
                    }
                    else match = true;
                }
                //if match is true set current rule to be returned, but also allowing more complex rule down the line to replace it
                if(match) returnRule = rule;
            }
        }
        return returnRule;
    }


}

