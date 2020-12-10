package model;

public class Akun
{
    private String kode_akun;
    private String nama_akun;
    private String jenis_akun;
    private String saldo_normal;
    
    public String getSaldoNormal()
    {
        return saldo_normal;
    }

    public void setSaldoNormal(String saldo_normal)
    {
        this.saldo_normal = saldo_normal;
    }

    public String getJenisAkun()
    {
        return jenis_akun;
    }

    public void setJenisAkun(String jenisAkun)
    {
        this.jenis_akun = jenisAkun;
    }

    public String getNamaAkun()
    {
        return nama_akun;
    }

    public void setNamaAkun(String nama_akun)
    {
        this.nama_akun = nama_akun;
    }

    public String getKodeAkun()
    {
        return kode_akun;
    }
    
    public void setKodeAkun(String kode_akun)
    {
        this.kode_akun = kode_akun;
    }
}