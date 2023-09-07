package it.itispaleocapa.crisafullip;


public class Socio{

    public String nome;
    public String cognome;
    public int eta;
    public char genere;

    public Socio(String nome, String cognome, int eta, char genere) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.genere = genere;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }
    
    public void setEta(int eta) {
        this.eta= eta;
    }

    public void incrementaEta() {
        eta++;
    }

    public char getGenere() {
        return genere;
    }

    public void setGenere(char genere) {
        this.genere = genere;
    }
}