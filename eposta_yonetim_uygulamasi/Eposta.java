package git_eposta_yonetim_uygulamasi.eposta_yonetim_uygulamasi;

import java.util.Scanner;

public class Eposta {
    private String ad;
    private String soyAd;
    private String birim;
    private String eposta;
    private String sifre = "";
    private String alternatifEposta;

    // Constructor: İsim ve soyisim bilgilerini al
    public Eposta(){
        // İsim ve soyisim bilgisini al
        Scanner input = new Scanner(System.in);
        System.out.print("Adınızı giriniz: ");
        this.ad = input.nextLine().trim().replaceAll("\\s+", " ");
        System.out.print("Soyadınızı giriniz: ");
        this.soyAd = input.nextLine().trim().replaceAll("\\s+", " ");
        System.out.println(ad+" "+soyAd);

        // Birim bilgisini çağır
        birimBilgisiniAl();
        System.out.println("Biriminiz: " + birim);

        // Oluşturulan epostayı çağır
        epostaOlustur();
        System.out.println("Kurumsal epostanız: " + eposta);

        // Oluşturulan şifreyi çağır
        sifreOlustur();
        System.out.println("Eposta Şifreniz: " + sifre);

        // Şifre değiştirme methodunu çağır
        setSifre();
    }

    // Çalışılan birim bilgisini al
    private String birimBilgisiniAl(){
        Scanner input = new Scanner(System.in);
        System.out.print("BİRİMLER: \n1- Pazarlama\n2- Geliştirme\n3- Muhasebe\nÇalıştığınız birimin kodunu giriniz: ");
        int secilenBirim = input.nextInt();
        switch (secilenBirim){
            case 1:
                birim = "Pazarlama";
                break;
            case 2:
                birim = "Geliştirme";
                break;
            case 3:
                birim = "Muhasebe";
                break;
            default:
                birim = "";
        }
        return birim;
    }

    // Eposta oluştur
    private String epostaOlustur(){
        String yeniAd = ad.replaceAll(" ", "");
        String yeniSoyad = soyAd.replaceAll(" ", "");
        eposta = (yeniAd+"."+yeniSoyad+"@"+birim+".qateam04.com").toLowerCase()
                .replaceAll("ç", "c")
                .replaceAll("ğ","g")
                .replaceAll("ı", "i")
                .replaceAll("ö", "o")
                .replaceAll("ş", "s")
                .replaceAll("ü", "u");
        return eposta;
    }

    // Şifre oluştur
    private String sifreOlustur(){
        String karakterler = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789\"*?.!#$%";
        for (int i = 0; i < 8; i++) {
            int rastgeleIndex = (int) (Math.random()*karakterler.length());
            sifre = sifre + karakterler.charAt(rastgeleIndex);
        }
        return sifre;
    }

    // Şifre değiştir

    public void setSifre() {
        Scanner input = new Scanner(System.in);
        System.out.print("Şifrenizi değiştirmek ister misiniz? (E / H): ");
        String yanit = input.next();
        if (yanit.equalsIgnoreCase("E")){
            System.out.print("Yeni şifrenizi giriniz: ");
            this.sifre = input.next();
            System.out.println("Yeni şifreniz: " + this.sifre);
        }else {
            System.out.println("Şifreniz: " + this.sifre);
        }
    }


    // Alternatif eposta ekle


    // Son durum ekranı oluştur

}
