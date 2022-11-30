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


    /**
     * Constructor assigns objects for lexicon, rules and populates them
     * @throws IOException due to use of BufferedReader and FileReader
     */
    public Parser() throws IOException {
        //Initialize Lists
        lexicon = new ArrayList<Word>();
        rules = new ArrayList<Rule>();
        partsOfSpeech = new ArrayList<POS>();

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
            word.setPos(st.nextToken());
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
            String word = st.nextToken();
            //check if word is in lexicon
            for (Word w : lexicon) {
                if (w.getWord().equals(word)) {
                    partsOfSpeech.add(w.getPos());
                }
            }
        }
       determineRule();
    }
    //TODO Refactor this to work on a larger scale
    void determineRule() {
        //loop for each rule, if the parts of speech from the input match a certain rule then print the rule
        for (Rule rule : rules) {
            if(partsOfSpeech.size() == rule.getPosList().size()){
                for (int i = 0; i < partsOfSpeech.size(); i++) {
                    if(!(partsOfSpeech.get(i).getPosString().equals(rule.getPosList().get(i).getPosString()))){
                        break;
                    }
                }
                System.out.println(rule.getRule());
            }
        }
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

