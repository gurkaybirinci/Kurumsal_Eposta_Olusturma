package git_eposta_yonetim_uygulamasi.eposta_yonetim_uygulamasi;

import java.util.Scanner;

public class Eposta {
    private String ad;
    private String soyAd;
    private String birim;
    private String eposta;
    private String sifre = "";
    private String alternatifEposta;
//    public static String sifre1;
//    public static String sifre2;

    // Constructor: İsim ve soyisim bilgilerini al
    public Eposta(){
        // İsim ve soyisim bilgisini al
        Scanner input = new Scanner(System.in);
        System.out.print("Adınızı giriniz: ");
        this.ad = input.nextLine().trim().replaceAll("\\s+", " ");
        System.out.print("Soyadınızı giriniz: ");
        this.soyAd = input.nextLine().trim().replaceAll("\\s+", " ");
        System.out.println("\tİsim Soyisim: " + ad+" "+soyAd);

        // Birim bilgisini çağır
        birimBilgisiniAl();
        System.out.println("\tBiriminiz: " + birim);

        // Oluşturulan epostayı çağır
        epostaOlustur();
        System.out.println("\tKurumsal Epostanız: " + eposta);

        // Oluşturulan şifreyi çağır
        sifreOlustur();
        System.out.println("\tEposta Şifreniz: " + sifre);

        // Şifre değiştirme methodunu çağır
        setSifre();

        // Alternatif eposta methodunu çağır
        setAlternatifEposta();

        // Son durum ekranı oluştur
        System.out.println(this);
    }

    // Çalışılan birim bilgisini al
    private String birimBilgisiniAl(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nBİRİMLER: \n\t1- Pazarlama\n\t2- Geliştirme\n\t3- Muhasebe\nÇalıştığınız birimin kodunu giriniz: ");
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
        System.out.print("\nŞifrenizi değiştirmek ister misiniz? (E / H): ");
        String yanit = input.next();
        String sifre1 = "";
        String sifre2 = "";

        if (yanit.equalsIgnoreCase("E")){
            do {
                System.out.print("Şifreniz büyük harf, küçük harf ve rakam içeren, en az 8 karakterden oluşmalıdır.\nYeni şifrenizi giriniz: ");
                sifre1 = input.nextLine();
                if(yeniSifreKontrolu(sifre1)){
                    System.out.print("Şifrenizi tekrar giriniz: ");
                    sifre2 = input.nextLine();
                    if (!sifre1.equals(sifre2)){
                        System.out.println("Girdiğiniz şifreler birbiriyle uyumlu değil.");
                    }
                }else {
                    System.out.println("\nGeçersiz Şifre!");
                }
            } while (!sifre1.equals(sifre2));
            this.sifre = sifre1;
            System.out.println("\tYeni şifreniz: " + this.sifre);
        }else {
            System.out.println("\tŞifreniz: " + this.sifre);
        }
    }
    public boolean yeniSifreKontrolu(String sifre1){
        return (sifre1.length() > 7) &&
                (sifre1.replaceAll("[^A-Z]", "").length() > 0) &&
                (sifre1.replaceAll("[^a-z]", "").length() > 0) &&
                (sifre1.replaceAll("[^0-9]", "").length() > 0) &&
                (sifre1.replaceAll("\\S", "").length() == 0);
    }

    // Alternatif eposta ekle
    public void setAlternatifEposta() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nAlternatif eposta adresinizi giriniz: ");
        this.alternatifEposta = input.next();
        System.out.println("\tAlternatif eposta adresiniz: " + alternatifEposta);
    }

    // Son durum ekranı oluştur
    @Override
    public String toString() {
        System.out.println("\n----------------------");
        return "İsim Soyisim: "+ ad +" "+ soyAd + "\n" +
                "Çalışılan Birim: " + birim + "\n" +
                "Kurumsal Eposta Adresiniz: " + eposta + "\n" +
                "Kurumsal Eposta Adresinizin Şifresi: " + sifre + "\n" +
                "Alternatif Epostanız: " + alternatifEposta;
    }

}
