
import java.util.Arrays;
import java.util.List;

public class Kortti {

    private int arvo;
    private String maa;

//    public Kortti(int arvo, String maa) {
//        this.arvo = arvo;
//        this.maa = maa;
//    }
    public Kortti(int arvo, String maa) {
        setArvo(arvo);  //2
        setMaa(maa);    //"hearts"
    }

    public static List<Integer> getArvot() {
        return Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11/*jack*/, 12/*queen*/, 13/*king*/, 14/*ace*/);
    }

    public void setArvo(int arvo) {
        List<Integer> arvot = getArvot();
        if (getArvot().contains(arvo)) {
            this.arvo = arvo;
        }
    }

    public int getArvo() {
        return arvo;
    }

    public static List<String> getMaat() {
        return Arrays.asList("hearts", "diamonds", "spades", "clubs");
    }

    public void setMaa(String maa) {
        List<String> maat = getMaat();
//        maa = maa.toLowerCase();
        if (maat.contains(maa)) {
            this.maa = maa;
        }
    }

    public String getMaa() {
        return maa;
    }

    @Override
    public String toString() {
        return arvo + " " + maa;
    }
}
