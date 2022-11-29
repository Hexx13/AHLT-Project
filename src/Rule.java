import java.util.ArrayList;
import java.util.List;

public class Rule {
    public String getRule() {
        return rule;
    }

    public List<POS> getPosList() {
        return posList;
    }

    private String rule;
    List<POS> posList = new ArrayList<POS>();

    public void addPOS(POS pos) {
        posList.add(pos);
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}
