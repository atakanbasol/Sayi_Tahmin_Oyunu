//package tutorials.jav.examples;

import tutorials.javase.AtakanBasolException;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    //Global Field (Class Variable)
    //final 3
    private static int COUNTER = 3;
    private static Scanner klavye = new Scanner(System.in);

    //Devam etmek istiyor musunuz?
    private static boolean wantToContinue() {
        //Scanner eğer static verirsek hata almamak için nextLine() yazmamız gerekiyor.
        klavye.nextLine();
        System.out.println("Tekrar oynamak ister misiniz E veya H");
        char conditional = 0;
        conditional = klavye.nextLine().charAt(0);
        if (conditional == 'E' || conditional == 'e') {
            return true;
        } else {
            System.out.println("Çıkış yapılıyor.");
            System.exit(0);
        }
        return false;
    }

    //Devam etmek istiyor musunuz?
    private static boolean easyOrHard() {
        System.out.println("Oyun zor mu olsun kolay mı olsun k veya z");
        //eğer kullanıcı kolay derse file dosyasına bilgisayarın üretttiği random sayıyı  bilgisayarda file dosyasına yazmamız gerekiyor.
        char conditional = 0;
        conditional = klavye.nextLine().charAt(0);
        if (conditional == 'K' || conditional == 'k') {
            return true;
        } else {
            System.out.println("Çıkış yapılıyor.");
            System.exit(0);
        }
        return false;
    }

    //Dosya yaz metodu
    private static void gameFileWriter(){

    }
    //Dosya oku metodu
    private static void gameFileReader(){

    }

    // Biz : sayı tahmin oyunu (bilgisayarın ürettiği sayıyı tahmin etmeye çalışalım.)
    // step-1:  kullanıcıdan aldığımız bir sayı(Scanner veya jOptionalPane) metotlar?
    // Validation: Kullanıcı negatif sayı giremez,
    // Validation: Kullanıcı sadece sayı girebilir. Eğer özel simge veya harf girerse bizi uyarsın,
    // Validation: Kullanıcı sadece sayı sınırı olsun 1-10000 arasında sadece sayı girebilir.
    public static int userNumber() throws AtakanBasolException {
        System.out.println("\nTahmin için bir sayı giriniz");
        int number = 0;
        try {
            number = klavye.nextInt();
            if (number < 0) {
                System.out.println("Lütfen pozitif sayı giriniz");
            } else if (number >= 10000) {
                System.out.println("Lütfen 1<=X<=10000 dışında sayı vermeyiniz");
            }
        } catch (InputMismatchException inputMismatchException) {
            //throw  new HamitMizrakException("Lütfen dikkat Sadece sayı giriniz");
            System.out.println("Lütfen dikkat Sadece sayı giriniz: " + inputMismatchException);
            userNumber();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return number;
    }

    // step-2:  bilgisayar  1-10 arasında sayı üretsin bu tahmin edeceğimiz sayı olacak (Random Object) metot
    // Kullanıcıya soralım. Oyun zor mu? (z) olsun yada basit mi (b) olsun.

    // Dikkat: validation kullanıcı girdiği büyük harf girerse her zaman küçük harfe çeviren (toLowercase()) metotudunu kullanalım.
    // Eğer kullanıcı zor derse:  1.adım bilgisayar sürekli 1-10 arasında sayı üretsin
    // Eğer kullanıcı kolay derse: bilgisayar oyunun başında sonuna kadar 1 kere sayı üretsin ve onu bulalım
    public static int computerNumber() {
        //Kolay mu , zor mu ?
        //eğer kullanıcı kolay derse file dosyasına bilgisayarın üretttiği random sayıyı  bilgisayarda file dosyasına yazmamız gerekiyor.
        Random random = new Random();
        int number = random.nextInt(10) + 1;
        return number;
    }

    //Main method
    public static void mainMethod() throws AtakanBasolException {
        char conditional = 0;
        boolean result=  easyOrHard();
        if(result){
            //Kolay
            System.out.println(result);
        }else{
            //zor olacak
            System.out.println(result);
        }
        while (true) {
            int computerNumber = computerNumber();
            System.out.println("Bilgisayar sayısı: " + computerNumber);
            int userData = userNumber();

            if (COUNTER > 0) {
                if (userData == computerNumber) {
                    System.out.println("Doğru bildiniz " + (4 - COUNTER) + " kerede bildiniz");
                    if(wantToContinue()){
                        mainMethod();
                    }
                } else {
                    COUNTER--;
                    System.out.println("Kalan hakkınız: " + (COUNTER));
                }
            } else {
                if (COUNTER == 0) {
                    if(wantToContinue()){
                        mainMethod();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws AtakanBasolException {
        mainMethod();
    }

//DİKKAT: bilgisayar random sayısına eğer sayi>=+1 uzaksa yukarı ve aradaki fark az desin eğer sayi>=3  uzaksa çok uzak
//DİKKAT: bilgisayar random sayısına eğer sayi>=-1 uzaksa aşağı ve aradaki fark az desin eğer sayi>=-3  uzaksa çok uzak

// Step- 3:
// result:  sayı tahmin sayımız 4 defa olmalıdır.
// NOT: Her yanlış tahminde  "C:\\io\\numberguessing.txt"; metin belgesine yanlış  tahminleri yazsın. yazarken  false ==> new BufferedWriter(new FileWriter(URL, false)))
// NOT: tahmini yazarken hem okuma hem yazma işlemi var dikkat.

// Step- 4:
// result:  Ekranda kaçıncı tahminde bulduğumuzu bize söylesin. (kalan tahmini "C:\\io\\numberguessing.txt"; metin belgesine okuma işlemi yapsın)

// Step- 5:
// result:  Eğer doğru tahmin edersek, bize soru sorsun oyunu tekrar oynamak istiyor musunuz ?
// result:  eğer cevabımız evetse oyuna tekrar oynatsın. eğer hayırsa şimdiye kadar bu oyunu kaç kere oynadığımızı bize söylesin. (static değişkenle yapabiliriz).
}