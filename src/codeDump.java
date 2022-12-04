public class codeDump {
    //    /**Takes in a list of words and compares them to the rules
//     * @param list takes in a list of words with POS objects to compare against existing rule POS structures
//     * @return a rule if the rule is found, null if not
//     */
//    private Rule compareRule3(List<Word> list){
//        boolean match = false;
//        Rule returner = null;
//        //for each rule in the rules list
//        for (Rule rule: rules) {
//
//            //if the size of the rule is the same as the size of the list
//            if(list.size() == rule.getPosList().size()){
//                //loop for each pos in the list
//                for (int i = 0; i < list.size(); i++) {
//                    String wordPOS = list.get(i).getPos().getPosString();
//                    String rulePOS = rule.getPosList().get(i).getPosString();
//                    //if pos in the list is not the same as the rule pos then break
//                    if(!(wordPOS.equals(rulePOS))){
//                        match = false;
//                        break;
//                    }
//                    //if pos in the list is the same as the rule pos then set match to true
//                    else match = true;
//                }
//                //if the match is successful then set the rule to returner
//                returner = rule;
//                if (match) return returner;
//            }
//        }
//        //if match is successful return the rule
//        if (match) return returner;
//        else return null;
//    }


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
