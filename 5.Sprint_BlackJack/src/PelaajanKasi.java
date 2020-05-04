
import java.util.ArrayList;

public class PelaajanKasi {
    private int kasiSumma;
    private ArrayList<Kortti> kortitKadessa = new ArrayList<>();

    public PelaajanKasi(Korttipakka pakka) {

        for (int i = 0; i < 2; i++) {
            kortitKadessa.add(pakka.jaaKortti());
        }
        for (Kortti k : kortitKadessa) {
            kasiSumma += k.getArvo();
        }
    }

    public int getKasiArvo() {
        return kasiSumma;
    }

    public ArrayList<Kortti> getKortit() {
        return kortitKadessa;
    }

    // otaKortti 
    //lisää kortit-listaan parametrina saamansa kortin
    public void otaKortti(Kortti k) {
        this.kortitKadessa.add(k);
    }

    // selvitaSumma 
    //selvittää pelaajan käden summan seuraavin säännöin
    private int selvitaSumma() {
        int kasiSumma = 0;

        for (Kortti k : kortitKadessa) {
            if (k.getArvo() > 1 && k.getArvo() < 11) {
                kasiSumma += k.getArvo();
            }

            if (k.getArvo() > 10 && k.getArvo() < 14) {
                kasiSumma += 10;
            }

            if (k.getArvo() == 1) {
                kasiSumma += 11;
            }
        }

        if (kasiSumma > 21) {
            kasiSumma -= 10;
        }
        
        return kasiSumma;
    }

    // tutkii onko kätenä blackjack
    public boolean onkoBlackjack() {
        if (kortitKadessa.size() == 2) {
            System.out.println("BlackJack");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String kasi = "";
        for (int i = 0; i < kortitKadessa.size(); i++) {
            kasi += kortitKadessa.get(i).toString() + " ";
        }
        return kasi;
    }
}
