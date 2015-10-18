import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Levchhenko
 */
public class Combination {

    public static void main(String[] args) {
        for (String s : new Combination().comb("123")) {
            System.out.println(s);
        }

    }

    public List<String> comb(String source) {
        List<String> combinations = new ArrayList<>();
        comb("", source, combinations);
        return combinations;
    }

    public void comb(String result, String source, List<String> combinations) {
        if (source.length() <= 0) {
            combinations.add(result);
        } else {
            for (int i = 0; i < source.length(); i++) {
                String nextResult = result + source.charAt(i);
                String rest = getRest(source, i);
                comb(nextResult, rest, combinations);
            }
        }
    }

    public String getRest(String source, int indexToRemove) {
        StringBuilder stringBuilder = new StringBuilder(source);
        stringBuilder.deleteCharAt(indexToRemove);
        return stringBuilder.toString();
    }
}
