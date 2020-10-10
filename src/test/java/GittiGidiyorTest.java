import org.junit.Test;

public class GittiGidiyorTest extends BaseTestKeyword {

    @Test
    public void uyelikTest() throws InterruptedException {
        kayitOl("Anıl","Akgün","anilakgun5@gmail.com","123456a","5411234567");
    }

    @Test
    public void sepetTest() throws InterruptedException {
        sepeteEkle("Bilgisayar");
    }

    @Test
    public void girisTest() throws InterruptedException {
        girisYap();
    }

    @Test
    public void adresTest() throws InterruptedException {
        adresEkle();
    }

}