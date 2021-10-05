package test;
import Classe.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Test_Etudiant {

    private String matiere, matiere2;
    private int coeff;
    private HashMap<String, Integer> map;
    private Formation formation;
    private Identite identite;
    private Etudiant etudiant;

    private boolean res;

    @Before
    public void avant(){
        matiere = "maths";
        matiere2 = "Francais";
        coeff = 3;
        map= new HashMap<>();
        map.put(matiere, coeff);
        formation = new Formation("matiere", map);
    }

    @Test
    public void TestAjouterNote() throws Exception{
        formation.ajouter(matiere, coeff);
        formation.ajouter(matiere2, coeff);
        etudiant.ajouterNote(matiere2, 10);
        Map<String, Float> matiere = etudiant.getNotes();
        float b = matiere.get("Francais");
        float f = 10F;

        assertEquals(f, b, 0);
    }



}
