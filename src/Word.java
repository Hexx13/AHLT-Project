public class Word {
    public POS getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = new POS(pos);
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
