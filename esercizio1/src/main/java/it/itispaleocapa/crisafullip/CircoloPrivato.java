package it.itispaleocapa.crisafullip;

import java.io.*;
import java.util.HashMap;

public class CircoloPrivato {
    private HashMap<String, Socio> socis; 

    public CircoloPrivato() {
        socis = new HashMap<>();
    }

    public void aggiungiSocio(Socio socio) {
        socis.put(socio.getNome() + socio.getCognome(), socio);
        //System.out.println("Socio aggiunto");
    }

    public void modificaSocio(String nome, String cognome, int nuovaEta, char nuovoGenere) {
        String chiave = nome + cognome;
        Socio socio = socis.get(chiave);
        if (socio != null) {
            socio.setGenere(nuovoGenere);
            socio.setEta(nuovaEta);
            //System.out.println("Socio modificato");
        } else {
            System.out.println("Socio non trovato");
        }
    }

    public void rimuoviSocio(String nome, String cognome) {
        String chiave = nome + cognome;
        Socio socio = socis.remove(chiave);
        if (socio != null) {
            //System.out.println("Socio rimosso");
        } else {
            System.out.println("Socio non trovato");
        }
    }

    public double calcolaEtaMedia() {
        int sommaEta = 0;
        double etamedia = 0;
        
        if (socis.isEmpty()) {
            return 0; 
        }
        
        for (Socio socio : socis.values()) {
            sommaEta += socio.getEta();
        }
        
        etamedia = (double) sommaEta / socis.size();
        return etamedia;
    }
    

    public double calcolaEtaMediaGenere(char sesso) {
        int sommaEta = 0;
        int contSoci = 0;
        double etamedia = 0;
        for (Socio socio : socis.values()) {
            if (socio.getGenere() == sesso) {
                sommaEta += socio.getEta();
                contSoci++;
            }
        }
        if (contSoci == 0) {
            return 0;
        }
        etamedia = (double) sommaEta / contSoci;
        return etamedia; 
    }

    public HashMap<Character, Double> calcolaDistribuzionePercentualeGenere() {
        HashMap<Character, Double> distribuzione = new HashMap<>();
        int contM = 0;
        int contF = 0;
        for (Socio socio : socis.values()) {
            if (socio.getGenere() == 'M') {
                contM++;
            } else if (socio.getGenere() == 'F') {
                contF++;
            }
        }
        int contTot = contM + contF;
        if (contTot > 0) {
            double percM = (double) contM / contTot * 100;
            double percF = (double) contF / contTot * 100;
            distribuzione.put('M', percM);
            distribuzione.put('F', percF);
        }
        return distribuzione;
    }
    public HashMap<String, Socio> getSoci() {
        return socis;
    }
    public void caricaSociSuFile(String nomeFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] oggetti = linea.split(" ");
                if (oggetti.length == 4) {
                    String nome = oggetti[0];
                    String cognome = oggetti[1];
                    int eta = Integer.parseInt(oggetti[2]);
                    char sesso = oggetti[3].charAt(0);

                    Socio socio = new Socio(nome, cognome, eta, sesso);
                    aggiungiSocio(socio);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File non trovato: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Errore lettura file: " + e.getMessage());
        }
    }
}



