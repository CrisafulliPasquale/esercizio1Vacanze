package it.itispaleocapa.crisafullip;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CircoloPrivato {
    
    HashMap<String, Socio> soci;

    public CircoloPrivato() {
        soci = new HashMap<>();
    }

    public void caricaDaFile(String nomeFile) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(nomeFile))) {
            while (scanner.hasNextLine()) {
                String[] campi = scanner.nextLine().split(",");
                if (campi.length != 4) {
                    throw new IllegalArgumentException("Formato errato nella riga: " + Arrays.toString(campi));
                }
                soci.put(campi[0].trim(), new Socio(campi[0].trim(), campi[1].trim(), Integer.parseInt(campi[2].trim()), campi[3].trim().charAt(0)));
            }
        }
    }

}



