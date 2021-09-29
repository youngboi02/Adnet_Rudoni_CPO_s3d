package test;

import jdk.jfr.StackTrace;

import java.util.ArrayList;
import java.util.HashMap;

public class Test_Etudiant {

    private static final int HashMap = 0;

    @Test
    public void TestAjouterNote() throws Exception{

        Formation formation = new Formation("formation", new HashMap<String, Integer>());
        Identite identite = new Identite("001", "Paul", "Ochon");
        Etudiant etudiant = new Etudiant(identite, formation);

        formation.ajouterMatiere("Maths", 2500);
        formation.ajouterMatiere("Francais", 4);

        etudiant.ajouterNote(10, "Francais");

        HashMap<String, ArrayList<Double>> matiere = etudiant.getNotes();
        ArrayList<Double> coef = matiere.get("francais");

        assertEquals("la note devrait etre 10", coef, 10);
    }
}
