package test;
import Classe.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Test_Etudiant {


    @Test
    public void TestAjouterNote() throws Exception{

        Formation formation = new Formation("formation", new HashMap<>());
        Identite identite = new Identite("001", "Paul", "Ochon");
        Etudiant etudiant = new Etudiant(identite, formation);

        formation.ajouter("Maths", 2500);
        formation.ajouter("Francais", 1);

        etudiant.ajouterNote("Francais", 10);

        Map<String, Float> matiere = etudiant.getNotes();
        float b = matiere.get("Francais");
        float f = 10F;

        assertEquals(f, b, 0);
    }

}
