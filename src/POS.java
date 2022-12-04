public class POS {
    public POS(String pos) {
        this.pos = pos;
    }

    public String getPosString() {
        return pos;
    }

    private String pos;

    @Override
    public String toString() {
        return pos;
    }
}
