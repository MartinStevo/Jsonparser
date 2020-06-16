import com.google.gson.annotations.Expose;

public class User {

    @Expose(deserialize = true)
    public String Meno;
    @Expose(deserialize = true)
    public String Priezvisko;
    @Expose(deserialize = true)
    public String Adresa;
    public String PSC;
    public String Mesto;
    @Expose(deserialize = true)
    public String Region;
    @Expose(deserialize = true)
    public String Tel;
    @Expose(deserialize = true)
    public String Mobil;

    public User() {
    }

    public User(String meno, String adresa, String PSC, String mesto, String region, String tel, String mobil) {
        Meno = meno;
        Adresa = adresa;
        this.PSC = PSC;
        Mesto = mesto;
        Region = region;
        Tel = tel;
        Mobil = mobil;
    }

    // getters and setters, toString() .... (omitted for brevity)


    public String getMeno() {
        return Meno;
    }

    public void setMeno(String meno) {
        Meno = meno;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    public String getPSC() {
        return PSC;
    }

    public void setPSC(String PSC) {
        this.PSC = PSC;
    }

    public String getMesto() {
        return Mesto;
    }

    public void setMesto(String mesto) {
        Mesto = mesto;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getMobil() {
        return Mobil;
    }

    public void setMobil(String mobil) {
        Mobil = mobil;
    }

    public String getPriezvisko() {
        return Priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        Priezvisko = priezvisko;
    }
}