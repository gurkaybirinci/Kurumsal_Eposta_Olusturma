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
        this.ad = input.nextLine().trim().replaceAll("\\s+", " ").toUpperCase();
        System.out.print("Soyadınızı giriniz: ");
        this.soyAd = input.nextLine().trim().replaceAll("\\s+", " ").toUpperCase();
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
                birim = " ";
                System.out.print("Girdiğiniz bilgiler eksik ya da yanlıştır.\nÇalıştığınız birimin kodunu giriniz: ");
                birimBilgisiniAl();
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

        if (yanit.equalsIgnoreCase("E")){
            yeniSifreKontrolu();
        }else {
            System.out.println("\tŞifreniz: " + this.sifre);
        }
    }
    public void yeniSifreKontrolu(){
        Scanner input = new Scanner(System.in);
        String yeniSifre1 = "";
        String yeniSifre2 = "";

        System.out.print("Şifreniz büyük harf, küçük harf ve rakam içeren, en az 8 karakterden oluşmalı ve boşluk içermemelidir." +
                "\nYeni şifrenizi giriniz: ");
        yeniSifre1 = input.nextLine();

        // i)Space hariç en az 8 character olmalı
        boolean first = yeniSifre1.replace(" ", "").length() > 7;

        // ii)En az bir seembol içermeli
        boolean second = yeniSifre1.replaceAll("[0-9a-zA-Z]", "").length() > 0;

        // iii) En az bir rakam iççermeli
        boolean third = yeniSifre1.replaceAll("[^0-9]", "").length() > 0;

        // iv) En az bir büyük harf içermeli
        boolean fourth = yeniSifre1.replaceAll("[^A-Z]", "").length() > 0;

        // v) En az bir küçük harf içermeli
        boolean fifth = yeniSifre1.replaceAll("[^a-z]", "").length() > 0;

        // vi) Boşluk karakteri içermemeli
        boolean sixth = yeniSifre1.replaceAll("[\\S]", "").length() < 1;

        boolean pwdGecerli = first && second && third && fourth && fifth && sixth;

        if (pwdGecerli) {
            System.out.print("Şifrenizi tekrar giriniz: ");
            yeniSifre2 = input.nextLine();
            if (yeniSifre1.equals(yeniSifre2)){
                sifre=yeniSifre1;
                System.out.println("\tŞifreniz: " + this.sifre);
            } else {
                System.out.println("Girdiğiniz şifreler birbiriyle uyumlu değil.");
                yeniSifreKontrolu();
            }
        } else {
            System.out.println("Şifre geçerli değildir");
            yeniSifreKontrolu();
        }
    }

    // Alternatif eposta ekle
    public void setAlternatifEposta() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nAlternatif eposta adresinizi giriniz: ");
        String ikinciEposta = input.next();
        if (ikinciEposta.contains("@")) {
            if ((ikinciEposta.matches("(.)@.") && (!ikinciEposta.startsWith("@") && !ikinciEposta.endsWith("@")))) {
                this.alternatifEposta = ikinciEposta;
                System.out.println("\tAlternatif eposta adresiniz: " + alternatifEposta);
            } else {
                System.out.println("Geçersiz eposta adresi girdiniz.");
                setAlternatifEposta();
            }
        }
    }

    // Son durum ekranı oluştur
    @Override
    public String toString () {
        System.out.println("\n----------------------");
        return "İsim Soyisim: " + ad + " " + soyAd + "\n" +
                "Çalışılan Birim: " + birim + "\n" +
                "Kurumsal Eposta Adresiniz: " + eposta + "\n" +
                "Kurumsal Eposta Adresinizin Şifresi: " + sifre + "\n" +
                "Alternatif Epostanız: " + alternatifEposta;
    }
}
