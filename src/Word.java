public class Word {



    public Word() {
    }
    public Word(String word, String amnt, POS pos) {
        this.word = word;
        this.amnt = amnt;
        this.pos = pos;
    }
    public POS getPos() {
        return pos;
    }

    public void setPos(POS pos) {
        this.pos = pos;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getAmnt() {
        return amnt;
    }

    public void setAmnt(String amnt) {
        this.amnt = amnt;
    }

    private String word, amnt;

    private POS pos;
    @Override
    public String toString() {
        return "Word{" +
                "type='" + pos.getPosString() + '\'' +
                ", word='" + word + '\'' +
                ", amnt='" + amnt + '\'' +
                '}';
    }
}
