package model;

import java.util.ArrayList;

public class Rota {
	
	int id;
	
	Cidade origem;
	Cidade destino;
	float km;
	public static ArrayList<Cidade> paradas = new ArrayList<>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cidade getOrigem() {
		return origem;
	}
	public void setOrigem(Cidade origem) {
		this.origem = origem;
	}
	public Cidade getDestino() {
		return destino;
	}
	public void setDestino(Cidade destino) {
		this.destino = destino;
	}
	public static ArrayList<Cidade> getParadas() {
		return paradas;
	}
	public static void setParadas(ArrayList<Cidade> paradas) {
		Rota.paradas = paradas;
	}


}
