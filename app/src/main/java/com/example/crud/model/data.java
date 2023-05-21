package com.example.crud.model;

public class data {
    private String NIM, Nama, Jurusan;

    public data(){

    }

    public data(String NIM, String Nama, String Jurusan){
        this.NIM = NIM;
        this.Nama = Nama;
        this.Jurusan = Jurusan;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getJurusan() {
        return Jurusan;
    }

    public void setJurusan(String jurusan) {
        Jurusan = jurusan;
    }
}
