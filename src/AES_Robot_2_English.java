//QUEUE İLE YAPABİLİRİM

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AES_Robot_2_English {

    static int satir = 0;
    static int sutun = 0;

    static final int i = 0;
    static final int j = 1;

    static final int Referansa_Donuldu = 0;

    static final int Max_Saga_ulasildi = 1;
    static final int Max_Sola_ulasildi = 2;
    static final int atlayis_noktasi_donuldu = 3;

    public static void Labirent_Dolas(String[][] Labirent_Harita) {

        final int gecit_sayisi = sutun / 3 + 1;

        int Cikis_Icin_gerekli_Dizi_Sayisi;
        int Max_atlayis_sayisi_dizi_icin;

        Cikis_Icin_gerekli_Dizi_Sayisi = Us_Alma(gecit_sayisi, (satir - 1) / 2);   // [A][] --> A için
        Max_atlayis_sayisi_dizi_icin = (satir + 1) / 2 + 1; // referanslar & dolaşmalar için lazım olacak

        int j_dolas, i_dolas;
        Random random = new Random();
        int baslangic_j = random.nextInt(sutun);
        int baslangic_i = 0;
        int bitis = random.nextInt(sutun);
        String[][] Labirent = Labirent_Harita;
        int[][] Referans_i_j = new int[Max_atlayis_sayisi_dizi_icin][2];    // geçiçi yerleri tutmak için  
        int atlanılan_basamak_sayisi = 0;
        int cikis_sayisi = 0;
        int[][] atlayıs_noktasi = new int[Max_atlayis_sayisi_dizi_icin][2];
        int[][][] Cikis_Dizisi = new int[Cikis_Icin_gerekli_Dizi_Sayisi][Max_atlayis_sayisi_dizi_icin][2];
        boolean[][] Referans_Sag_Sol_Atlayıs_noktasi = new boolean[Max_atlayis_sayisi_dizi_icin][4];
        Labirent[satir - 1][bitis] = "|☺|"; //bitis
        Labirent[0][baslangic_j] = "|☯|";         //baslangic 
        j_dolas = baslangic_j;
        i_dolas = 0;
        for (int i = satir - 1; i >= 0; i--) {//Görseleştirmeye yarar
            for (int j = 0; j < sutun; j++) {
                System.out.print(Labirent[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
        Referans_i_j[atlanılan_basamak_sayisi][i] = i_dolas;
        Referans_i_j[atlanılan_basamak_sayisi][j] = j_dolas;

        Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][Referansa_Donuldu] = false;
        Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][Max_Saga_ulasildi] = false;
        Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][Max_Sola_ulasildi] = false;
        Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][atlayis_noktasi_donuldu] = false;

        while (cikis_sayisi != Cikis_Icin_gerekli_Dizi_Sayisi) {
            if (Labirent[i_dolas][j_dolas].equals("|☺|")) {
                for (int atama = 0; atama < atlanılan_basamak_sayisi; atama++) {
                    Cikis_Dizisi[cikis_sayisi][atama][i] = atlayıs_noktasi[atama][i];
                    Cikis_Dizisi[cikis_sayisi][atama][j] = atlayıs_noktasi[atama][j];
                }
                Cikis_Dizisi[cikis_sayisi][atlanılan_basamak_sayisi][i] = i_dolas;
                Cikis_Dizisi[cikis_sayisi][atlanılan_basamak_sayisi][j] = j_dolas;
                cikis_sayisi++;
                atlanılan_basamak_sayisi--;
                i_dolas = atlayıs_noktasi[atlanılan_basamak_sayisi][i];
                j_dolas = atlayıs_noktasi[atlanılan_basamak_sayisi][j];
                Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][atlayis_noktasi_donuldu] = true;
            } else if (i_dolas < satir - 1 && !Labirent[(i_dolas + 1)][j_dolas].equals("|X|") && (Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][Referansa_Donuldu] != true && Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][atlayis_noktasi_donuldu] != true)) {//!!!!!!!!!! && Referans_i_j[atlanılan_basamak_sayisi][j] != Referans_i_j[i_dolas][j]
                atlayıs_noktasi[atlanılan_basamak_sayisi][i] = i_dolas;
                atlayıs_noktasi[atlanılan_basamak_sayisi][j] = j_dolas;
                i_dolas += 2;
                atlanılan_basamak_sayisi++;
                Referans_i_j[atlanılan_basamak_sayisi][i] = i_dolas;
                Referans_i_j[atlanılan_basamak_sayisi][j] = j_dolas;
                Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][Referansa_Donuldu] = false;
                Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][Max_Saga_ulasildi] = false;
                Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][Max_Sola_ulasildi] = false;
                Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][atlayis_noktasi_donuldu] = false;
            } else if (Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][Max_Saga_ulasildi] != true) {
                Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][atlayis_noktasi_donuldu] = false;
                if (j_dolas == sutun - 1) {
                    Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][Max_Saga_ulasildi] = true;
                    i_dolas = Referans_i_j[atlanılan_basamak_sayisi][i];
                    j_dolas = Referans_i_j[atlanılan_basamak_sayisi][j];
                    Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][Referansa_Donuldu] = true;
                } else {
                    j_dolas++;
                    Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][atlayis_noktasi_donuldu] = false;
                    Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][Referansa_Donuldu] = false;
                }
            } else if (Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][Max_Sola_ulasildi] != true) {
                Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][atlayis_noktasi_donuldu] = false;
                Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][Referansa_Donuldu] = false;
                if (j_dolas == 0) {
                    Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][Max_Sola_ulasildi] = true;
                    atlanılan_basamak_sayisi--;
                    i_dolas = atlayıs_noktasi[atlanılan_basamak_sayisi][i]; //sag sol bitti bir önceki referansa atamamız lazım ve  referans donus ilk tur ise  yukarı atlamamalı
                    j_dolas = atlayıs_noktasi[atlanılan_basamak_sayisi][j];
                    Referans_Sag_Sol_Atlayıs_noktasi[atlanılan_basamak_sayisi][atlayis_noktasi_donuldu] = true;
                } else {
                    j_dolas--;
                }
            } 
        }
        for (int cikis = 0;
                cikis < Cikis_Icin_gerekli_Dizi_Sayisi;
                cikis++) {
            System.out.print("Exit : (" + (cikis + 1) + ") ");
            for (int atama = 0; atama <= atlanılan_basamak_sayisi + 1; atama++) {
                System.out.print(" [" + Cikis_Dizisi[cikis][atama][0] + "] [" + Cikis_Dizisi[cikis][atama][1] + "] ,  ");
            }
            int adım_sayisi = 0;
            for (int atama = 1; atama <= atlanılan_basamak_sayisi + 1; atama++) {
                int gidilen_yer = Cikis_Dizisi[cikis][atama][1];
                int bulunan_yer = Cikis_Dizisi[cikis][atama - 1][1];
                int sonuc;
                if (gidilen_yer - bulunan_yer < 0) {
                    sonuc = (-1) * (gidilen_yer - bulunan_yer);
                } else {
                    sonuc = (gidilen_yer - bulunan_yer);
                }
                adım_sayisi += sonuc;
            }
            System.out.println("  ---> step count :" + adım_sayisi);
            System.out.println();
        }
    }

    public static String[][] labirent_Ayarlama(int satir, int sutun) {  //Baslangıç ve bitişi başka fonksiyonda yapacağım
        final int gecit_sayisi = sutun / 3 + 1;
        System.out.println("bridge number: " + gecit_sayisi);
        System.out.println("Row : " + satir + ", (Column value) : " + sutun);
        Random random = new Random();
        ArrayList<Integer> arraylist_randomlama = new ArrayList<Integer>();
        String[][] Labirent_Yolu = new String[satir][sutun];
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                Labirent_Yolu[i][j] = "| |";
            }
        }
        int satirlar_arasi_gecis = random.nextInt(sutun);
        for (int i = 0; i < satir; i++) {
            if (i % 2 == 1) {
                int satirdaki_toplam_random_sayisi = 0;
                for (int j = 0; j < sutun; j++) {
                    //&& j != satirlar_arasi_gecis
                    while (satirdaki_toplam_random_sayisi != gecit_sayisi) {
                        satirdaki_toplam_random_sayisi++;
                        int random_ekleme = random.nextInt(sutun);
                        if (!Labirent_Yolu[i][random_ekleme].equals("|X|")) {
                            if (random_ekleme == 0) {
                                Labirent_Yolu[i][random_ekleme + 1] = "|X|";
                            } else if (random_ekleme == sutun - 1) {
                                Labirent_Yolu[i][random_ekleme - 1] = "|X|";
                            } else {
                                Labirent_Yolu[i][random_ekleme + 1] = "|X|";
                                Labirent_Yolu[i][random_ekleme - 1] = "|X|";
                            }
                            arraylist_randomlama.add(random_ekleme);
                            if (satirdaki_toplam_random_sayisi > 1) {
                                for (int random_kontrol = 0; random_kontrol < arraylist_randomlama.size() - 1; random_kontrol++) {
                                    if (arraylist_randomlama.get(random_kontrol) == arraylist_randomlama.get(satirdaki_toplam_random_sayisi - 1)) {
                                        arraylist_randomlama.remove(satirdaki_toplam_random_sayisi - 1);
                                        satirdaki_toplam_random_sayisi--;
                                    }
                                }
                            }
                        } else {
                            satirdaki_toplam_random_sayisi--;
                        }
                    }
                    for (int random_yerlestirme = 0; random_yerlestirme < gecit_sayisi; random_yerlestirme++) {
                        if (arraylist_randomlama.get(random_yerlestirme) == j) {
                            Labirent_Yolu[i][j] = "|  |";
                        }
                    }
                }
                arraylist_randomlama.clear();
            }
        }
        for (int i = 0;i < satir;i++) {
            for (int j = 0; j < sutun; j++) {
                if (!Labirent_Yolu[i][j].equals("|  |") && i % 2 == 1) {
                    Labirent_Yolu[i][j] = "|X|";
                }
            }
        }
        for (int i = 0;i < satir;i++) {
            for (int j = 0; j < sutun; j++) {
                if (Labirent_Yolu[i][j].equals("|  |")) {
                    Labirent_Yolu[i][j] = "| |";
                }
            }
        }
        return Labirent_Yolu;
    }

    public static int Us_Alma(int deger1, int deger2) {
        int sonuc = 1;
        for (int i = 1; i <= deger2; i++) {
            sonuc *= deger1;
        }
        return sonuc;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter rows and columns.");
        System.out.print("Enter the number of rows and columns separated by a space (at least 3,2):");
        System.out.println("(bridge number = column / 3 + 1)");
        if (scanner.hasNextInt()) {
            satir = scanner.nextInt();
        }
        if (scanner.hasNextInt()) {
            sutun = scanner.nextInt();
        }
        if (satir < 2) {
            satir = 3;
            System.out.println("Belirtilen degerden kucuk deger girdiginiz icin satir =" + satir + " alınmıştır");
        }
        if (sutun < 2) {
            sutun = 2;
            System.out.println("Belirtilen degerden kucuk deger girdiginiz icin sutun =" + sutun + " alınmıştır");
        }
        if (satir % 2 == 0) {
            satir++;
            System.out.println("The number of lines cannot be an even number.");
        }
        Random random = new Random();
        String[][] Labirent = labirent_Ayarlama(satir, sutun);
        Labirent_Dolas(Labirent);
        for (int i = satir - 1; i >= 0; i--) {//Görseleştirmeye yarar
            for (int j = 0; j < sutun; j++) {
                System.out.print(Labirent[i][j]);
                System.out.print("");
            }
            System.out.println();
        }

    }

}
