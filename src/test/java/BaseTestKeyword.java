import static org.junit.Assert.*;

public class BaseTestKeyword extends BaseTest {

    public void kayitOl(String name,String surname,String email,String password,String gsm) throws InterruptedException {
        clickByText("Giriş Yap");
        Thread.sleep(2000);
        clickByDataCy("header-register-button");
        Thread.sleep(2000);
        sendByName("name",name);
        Thread.sleep(2000);
        sendByName("surname",surname);
        Thread.sleep(2000);
        sendByDataType("e-mail",email);
        Thread.sleep(2000);
        sendByName("passwd",password);
        Thread.sleep(2000);
        sendByName("gsmData",gsm);
        Thread.sleep(2000);
        clickByClassName("checkmark");
        Thread.sleep(2000);
        assertEquals("Ücretsiz Kayıt Olun - Online Alışveriş - GittiGidiyor",driver.getTitle());
    }

    public void sepeteEkle(String product) throws InterruptedException {
        sendByDataCy("header-search-input",product);
        Thread.sleep(2000);
        clickByDataCy("search-find-button");
        Thread.sleep(2000);
        clickByProductIndex((int)((Math.random() * 48)+1)+"");
        Thread.sleep(9000);
        clickByText("Sepete Ekle");
        Thread.sleep(2000);
        clickByClassName("header-cart-hidden-link");
        Thread.sleep(2000);
        assertEquals("Sepetim - GittiGidiyor",driver.getTitle());
    }

    public void girisYap() throws InterruptedException {
        clickByText("Giriş Yap");
        Thread.sleep(2000);
        clickByDataCy("header-login-button");
        Thread.sleep(2000);
        sendByName("kullanici",secret.get(0));
        Thread.sleep(2000);
        sendByName("sifre",secret.get(1));
        Thread.sleep(2000);
        clickById("gg-login-enter");
        Thread.sleep(2000);
        assertEquals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi",driver.getTitle());
    }

    public void adresEkle() throws InterruptedException {
        girisYap();
        clickByText("Hesabım");
        Thread.sleep(2000);
        clickByText("Bilgilerim / Ayarlarım");
        Thread.sleep(2000);
        clickByText("Adres Bilgilerim ");
        Thread.sleep(2000);
        sendByName("sifre", secret.get(1));
        Thread.sleep(2000);
        clickById("gg-login-enter");
        Thread.sleep(2000);
        clickByText("Yeni Adres Ekle");
        Thread.sleep(2000);
        assertEquals("GittiGidiyor - Adres Ekleme Formu",driver.getTitle());
        sendByName("title","Ev");
        Thread.sleep(2000);
        sendByName("name","Anıl");
        Thread.sleep(2000);
        sendByName("surname","Akgün");
        Thread.sleep(2000);
        selectById("cities", secret.get(2));
        Thread.sleep(2000);
        selectById("counties", secret.get(3));
        Thread.sleep(2000);
        selectById("neighborhoods", secret.get(4));
        Thread.sleep(2000);
        sendByName("zipCode", secret.get(5));
        Thread.sleep(2000);
        sendByName("address", secret.get(6));
        Thread.sleep(2000);
        sendByName("phone",secret.get(7));
        Thread.sleep(2000);
        clickById("AddressSave");
        Thread.sleep(2000);
    }

}