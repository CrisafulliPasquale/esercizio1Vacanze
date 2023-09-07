package it.itispaleocapa.crisafullip;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        
        CircoloPrivato circ = new CircoloPrivato();
        Socio socio1 = new Socio("Pasquale", "Crisafulli", 18, 'M');
        Socio socio2 = new Socio("Samuele", "Labollita", 18, 'm');
        Socio socio3 = new Socio("Luca", "Rossi", 25, 'M');
        circ.aggiungiSocio(socio1);
        circ.aggiungiSocio(socio2);
        circ.aggiungiSocio(socio3);
        circ.modificaSocio("Pasquale", "Crisafulli", 23, 'M');
        circ.caricaSociSuFile("soci.txt");

        double etaMediaTotale = circ.calcolaEtaMedia();
        double etaMediaMaschi = circ.calcolaEtaMediaGenere('M');
        double etaMediaFemmine = circ.calcolaEtaMediaGenere('F');
        HashMap<Character, Double> distribuzionegenere = circ.calcolaDistribuzionePercentualeGenere();
        Double percentualeMaschi = distribuzionegenere.get('M');
        Double percentualeFemmine = distribuzionegenere.get('F');
        
        System.out.println("Età media dei soci maschi: " + etaMediaMaschi + 
        "\nEtà media dei soci: " + etaMediaTotale + 
        "\nEtà media dei soci femmine: " + etaMediaFemmine + 
        "\nDistribuzione percentuale dei soci maschi: " + percentualeMaschi + "%" + 
        "\nDistribuzione percentuale dei soci femmine: " + percentualeFemmine + "%");

        circ.rimuoviSocio("Luca", "Rossi");

    }
}
