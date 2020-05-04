
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Korttipakka {

    private ArrayList<Kortti> pakka;

    public Korttipakka(ArrayList<Kortti> pakka) {
        this.pakka = pakka;
    }

    public Korttipakka() {
        List<String> maat = Kortti.getMaat();
        List<Integer> arvot = Kortti.getArvot();

        pakka = new ArrayList<>();  // size=0
        for (String maa : maat) {  // "hertta" | size=4
            for (Integer arvo : arvot) {  // 3 | size=13
                pakka.add(new Kortti(arvo, maa));  //arvo:3, maa:"hertta" | pakka:size=1
            }
        }
        sekoita();
    }

//
//    // sekoita; sekoittaa atribuutin pakka korttien järjestyksen
    public void sekoita() {
        Collections.shuffle(pakka);
    }

    // jaaKortti palauttaa pakan ekan kortin ja poistaa sen pakasta
    public Kortti jaaKortti() {
        if (pakka.size() > 0) {
            return pakka.remove(0);
        }
        return null; // pakka.get(0)
    }

    public void lisaaKortti(Kortti k) {
        this.pakka.add(k);
    }

    public Kortti getKortti(int i) {
        return this.pakka.get(i);
    }

    @Override
    public String toString() {
//        return "" + pakka;
        String str = "";
        for (Kortti k : this.pakka) {
            str += "\n " + "-" + k.toString();
        }
        return str;
    }
}
