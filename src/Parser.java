import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 */
public class Parser {
    private List<Word> lexicon;
    private List<Rule> rules;
    private List<POS> partsOfSpeech;

    private List<Word> inputWords;

    /**
     * Constructor assigns objects for lexicon, rules and populates them
     * @throws IOException due to use of BufferedReader and FileReader
     */
    public Parser() throws IOException {
        //Initialize Lists
        lexicon = new ArrayList<Word>();
        rules = new ArrayList<Rule>();
        partsOfSpeech = new ArrayList<POS>();
        inputWords = new ArrayList<Word>();
        //Populate Lists
        populateRule();
        populateLexicon();
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

    void parseInput(String sentence) {
        //clean sentence of any other possible characters apart from letters and spaces
        sentence = sentence.replaceAll("[^a-z A-Z]", "");
        //tokenize sentence
        StringTokenizer st = new StringTokenizer(sentence, " ");

        while (st.hasMoreTokens()) {
            Word word = new Word();
            String wordString = st.nextToken();
            //check if word is in lexicon
            for (Word w : lexicon) {
                if (w.getWord().equals(wordString)) {
                    word.setPos(w.getPos());
                    word.setWord(wordString);
                    //System.out.println(word.toString());
                    inputWords.add(word);
                }
            }
        }
       determineRule();
    }
    void determineRule() {
        List<Word> list = new ArrayList<Word>();
        for(int i = 0; i < inputWords.size(); i++){
            //Debug
            String rulesString = "";

            //End Debug
            //System.out.println(i);

            list.add(inputWords.get(i));



            Rule rule = compareRule(list);

            if(rule != null){
                System.out.println();
                for (Word w : list) {
                    System.out.println(w.getWord() + "  "+ w.getPos().getPosString());
                }
                list.clear();
                System.out.println(rule.getRule());
            }


//            for (Rule rule: rules) {
//                if(list.size() == rule.getPosList().size()){
//                    for (int j = 0; j < list.size(); j++) {
//                        //if the parts of speech don't match the rule then break out of the loop
//                        if(!(list.get(j).getPos().getPosString().equals(rule.getPosList().get(j).getPosString()))){
//                            System.out.println("not a rule");
//                            //break;
//                        } else {
//                            for (Word word:list) {
//                                System.out.println(word.toString());
//                            }
//                            list.clear();
//                            rulesString = rulesString + rule.getRule() + " ";
//                        }
//                    }
//                }
//            }
//            System.out.println(rulesString);
        }
//        //loop for each rule, if the parts of speech from the input match a certain rule then print the rule
//        for (Rule rule : rules) {
//
//
//
//            if(inputWords.size() == rule.getPosList().size()){
//                //loop for each part of speech in input
//                for (int i = 0; i < inputWords.size(); i++) {
//                    //if the parts of speech don't match the rule then break out of the loop
//                    if(!(inputWords.get(i).getPos().getPosString().equals(rule.getPosList().get(i).getPosString()))){
//                        break;
//                    }
//                }
//                System.out.println(rule.getRule());
//            }
//        }
    }
    private Rule compareRule(List<Word> list){
        boolean match = false;
        Rule returner = null;
        //for each rule in the rules list
        for (Rule rule: rules) {
            //if the size of the rule is the same as the size of the list
            if(list.size() == rule.getPosList().size()){
                //loop for each pos in the list
                for (int i = 0; i < list.size(); i++) {
                    String wordPOS = list.get(i).getPos().getPosString();
                    String rulePOS = rule.getPosList().get(i).getPosString();
                    //if pos in the list is not the same as the rule pos then break
                    if(!(wordPOS.equals(rulePOS))){
                        match = false;
                        break;
                    }
                    //if pos in the list is the same as the rule pos then set match to true
                    else match = true;
                }
                //if the match is successful then set the rule to returner
                returner = rule;
                if (match) return returner;
            }
        }
        //if match is successful return the rule
        if (match) return returner;
        else return null;
    }

    /**
     * @deprecated
     */
//    void populatePOS() {
//        try {
//            // Buffered reader, reads file, tokenizes it, and adds it to the list
//            BufferedReader bf = new BufferedReader(new FileReader("src/POS.txt"));
//            StringTokenizer st = new StringTokenizer(bf.readLine(), ",");
//            while (st.hasMoreTokens()) {
//                partsOfSpeech.add(new POS(st.nextToken()));
//            }
//
//        } catch (IOException e){
//            System.out.println("Error: " + e);
//        }
//    }
//    public List<POS> getPartsOfSpeech() {
//        return partsOfSpeech;
//    }
}

