package test;
import Classe.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestEtudiant {

    private String matiere, matiere2;
    private int coeff;
    private HashMap<String, Integer> map;
    private Formation formation;
    private Identite identite;
    private Etudiant etudiant;
    private boolean res;
    private Map<String, Float> resultats;

    @Before
    public void avant(){
        matiere = "maths";
        matiere2 = "Francais";
        coeff = 3;
        map= new HashMap<>();
        map.put(matiere, coeff);
        formation = new Formation("matiere", map);
        etudiant = new Etudiant(identite, formation);
    }

    @Test
    public void TestAjouterNote() {
        float note = 10f;
        etudiant.ajouterNote(matiere, note);
        assertEquals("la note de maths devrait etre 10", 10f, etudiant.getNotes().values().toArray()[0]);
    }

    @Test
    public void TestCalculMoyenneMatiere(){
        float res = 12.5F;
        etudiant.ajouterNote(matiere, 10);
        etudiant.ajouterNote(matiere, 15);
        float test = etudiant.calculMoyenneMatiere(matiere);
        System.out.println(etudiant.getNotes());
        assertEquals("la moyenne est censée etre de 12.5", res, test, 0);
    }

    @Test
    public void TestMoyenneGenerale(){
        float moyenne = 12.5F;
        etudiant.ajouterNote(matiere, 10);
        etudiant.ajouterNote(matiere2, 15);
        float test = etudiant.calculMoyenneGenerale();
        assertEquals("la moyenne generale de l'etudiant devrait etre", moyenne, test, 0);
    }






}
