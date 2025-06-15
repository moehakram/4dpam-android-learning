package com.example.a213049_muhakram;


public class Menu {
    private int harga;
    private int ongkir;
    private int pajak;

    public Menu(int harga, int ongkir, int pajak) {
        this.harga = harga;
        this.ongkir = ongkir;
        this.pajak = pajak;
    }


    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getOngkir() {
        return ongkir;
    }

    public void setOngkir(int ongkir) {
        this.ongkir = ongkir;
    }


    public int getPajak() {
        return pajak;
    }

    public void setPajak(int pajak) {
        this.pajak = pajak;
    }

}
