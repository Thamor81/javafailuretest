package ventti;

import java.util.ArrayList;
import java.util.Scanner;

public class Ventti {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        int[] korttienArvot = {2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10, 11, 11, 11, 11, 12, 12, 12, 12, 13, 13, 13, 13, 14, 14, 14, 14};
        ArrayList<Integer> korttipakka = new ArrayList<>();

        // Luodaan korttipakka
        for (int kortitlistaan : korttienArvot) {
            korttipakka.add(kortitlistaan);
        }
        // Luodaan muuttujat
        int jakajanKortti = 0;
        int pelaajanKortti = 0;
        int pelaajanArvo = 0;
        int jakajanArvo = 0;

        System.out.println("Tervetuloa Timon ja Tomin kasinolle, jossa häviät varmasti. Voittoja ei makseta!");

        // Peli alkaa
        while (true) {
            System.out.println("Haluatko aloittaa pelin? joo/ei");
            String aloita = lukija.nextLine();

            if (aloita.equals("joo")) {
                int rand = (int) (Math.random() * korttipakka.size() - 1);
                pelaajanKortti = korttipakka.get(rand);
                pelaajanArvo = pelaajanKortti;
                System.out.println("Nostit kortin " + pelaajanKortti);
                System.out.println("Kätesi arvo on: " + pelaajanArvo);
                korttipakka.remove(pelaajanKortti);

            } else if (aloita.equals("ei")) {
                System.out.println("Lopetetaan peli");
                break;

            } else {
                System.out.println("Etkö osaa lukea? Vastaa joo tai ei");
                continue;
            }

            // Pelaajan käsi
            while (true) {
                System.out.println("Haluatko nostaa uuden kortin? joo/ei");
                String jatketaanko = lukija.nextLine();

                if (jatketaanko.equals("joo")) {
                    int rand = (int) (Math.random() * korttipakka.size() - 1);
                    pelaajanKortti = korttipakka.get(rand);
                    pelaajanArvo += pelaajanKortti;
                    System.out.println("Nostit kortin " + pelaajanKortti);
                    System.out.println("Kätesi arvo on " + pelaajanArvo);
                    korttipakka.remove(pelaajanKortti);

                    if (pelaajanArvo <= 20) {
                        continue;
                    } else if (pelaajanArvo == 21) {
                        break;
                    } else {
                        System.out.println("Hävisit");
                        break;
                    }

                } else if (jatketaanko.equals("ei")) {
                    System.out.println("Siirrytään jakajan käteen");
                    break;
                } else {
                    System.out.println("Etkö osaa lukea? Vastaa joo tai ei");
                    continue;
                }
            }
            // Jakajan käsi
            while (true) {

                if (jakajanArvo < 17 && pelaajanArvo <21) {
                    int rand = (int) (Math.random() * korttipakka.size() - 1);
                    jakajanKortti = korttipakka.get(rand);
                    jakajanArvo += jakajanKortti;
                    System.out.println("Jakaja nosti kortin " + jakajanKortti);
                    System.out.println("Jakajan käden arvo on " + jakajanArvo);
                    korttipakka.remove(jakajanKortti);

                } else if (jakajanArvo == pelaajanArvo) {
                    break;
                } else if (jakajanArvo >= 17 && jakajanArvo <= 21) {
                    break;
                } else {
                    break;
                }
            }

            // Käsien vertailu
            if ((pelaajanArvo > jakajanArvo && pelaajanArvo < 21 && jakajanArvo < 21) || (jakajanArvo > 21) || (pelaajanArvo == 21)) {
                System.out.println("Pelaaja voittaa");
            } else if (pelaajanArvo < jakajanArvo || jakajanArvo == 21 || jakajanArvo == pelaajanArvo || pelaajanArvo>21) {
                System.out.println("jakaja voittaa");
            } else {
                break;
            }
            System.out.println("Haluatko pelata uudestaan? joo/ei");
            String uudestaan = lukija.nextLine();
            if (uudestaan.equals("joo")) {
                continue;
            } else if (uudestaan.equals("ei")) {
                System.out.println("Kiitos käynnistä ja tervetuloa uudelleen");
                break;
            } else {
                break;
            }
        }

    }
}
