package com.aziz.unittest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Buku {

	@Id
	private int id;
	private String nama;
	private int jumlah;
	private int harga;

	@Transient
	private int value;

	public Buku() {

	}

	public Buku(int id, String nama, int jumlah, int harga) {
		super();
		this.id = id;
		this.nama = nama;
		this.jumlah = jumlah;
		this.harga = harga;
	}

	public int getId() {
		return id;
	}

	public String getNama() {
		return nama;
	}

	public int getJumlah() {
		return jumlah;
	}

	public int getHarga() {
		return harga;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Buku [id=" + id + ", nama=" + nama + ", jumlah=" + jumlah + ", harga=" + harga + ", value=" + value
				+ "]";
	}

}
