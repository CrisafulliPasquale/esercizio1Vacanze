package it.paleocapa.labollita;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.*;

public class AppTest {

    private CircoloPrivato circolo = new CircoloPrivato();

    @Test
    public void testAggiungiSocio() {
        Socio socio1 = new Socio("Pasquale", "Crisafulli", 18, 'M');
        circolo.aggiungiSocio(socio1);
        assertEquals(1, circolo.getSoci().size());

        Socio socio2 = new Socio("Samuele", "Labollita", 18, 'M');
        circolo.aggiungiSocio(socio2);
        assertEquals(2, circolo.getSoci().size());
    }

    @Test
    public void testModificaSocio() {
        Socio socio = new Socio("Samuele", "Labollita", 18, 'M');
        circolo.aggiungiSocio(socio);
        assertEquals(18, circolo.getSoci().get("SamueleLabollita").getEta());

        circolo.modificaSocio("Pasquale", "Crisafulli", 23, 'M');
        assertEquals(20, circolo.getSoci().get("SamueleLabollita").getEta());
    }

    @Test
    public void testRimuoviSocio() {
        Socio socio = new Socio("Pasquale", "Crisafulli", 18, 'M');
        circolo.aggiungiSocio(socio);
        assertEquals(1, circolo.getSoci().size());

        circolo.rimuoviSocio("Pasquale", "Crisafulli");
        assertEquals(0, circolo.getSoci().size());
    }

    @Test
    public void testCalcolaEtaMedia() {
        Soci socio1 = new Soci("Pasquale", "Crisafulli", 18, 'M');
        Soci socio2 = new Soci("Samuele", "Crisafulli", 12, 'M');

        circolo.aggiungiSocio(socio1);
        circolo.aggiungiSocio(socio2);

        double etaMedia = circolo.calcolaEtaMedia();
        assertEquals(15, etaMedia, 0.001);
    }

    @Test
    public void testCalcolaEtaMediaSesso() {
        Soci socio1 = new Soci("Pasquale", "Crisafulli", 18, 'M');
        Soci socio2 = new Soci("Chiara", "Plebani", 17, 'F');
        Soci socio3 = new Soci("Samuele", "Crisafulli", 12, 'M');

        circolo.aggiungiSocio(socio1);
        circolo.aggiungiSocio(socio2);
        circolo.aggiungiSocio(socio3);

        double etaMediaMaschi = circolo.calcolaEtaMediaGenere('M');
        assertEquals(15, etaMediaMaschi, 0.001);

        double etaMediaFemmine = circolo.calcolaEtaMediaGenere('F');
        assertEquals(17, etaMediaFemmine, 0.001); 
    }

    @Test
    public void testCalcolaDistribuzionePercentualeSesso() {
        Soci socio1 = new Soci("Pasquale", "Crisafulli", 18, 'M');
        Soci socio2 = new Soci("Chiara", "Plebani", 17, 'F');
        Soci socio3 = new Soci("Samuele", "Labollita", 18, 'M');

        circolo.aggiungiSocio(socio1);
        circolo.aggiungiSocio(socio2);
        circolo.aggiungiSocio(socio3);

        HashMap<Character, Double> distribuzioneSesso = circolo.calcolaDistribuzionePercentualeGenere();

        assertEquals(66.67, distribuzioneSesso.get('M'), 0.01); 
        assertEquals(33.33, distribuzioneSesso.get('F'), 0.01); 
    }
}