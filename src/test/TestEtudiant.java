package test;
import Classe.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestEtudiant {

    private String matiere, matiere2;
    private int coeff, coeff2;
    private HashMap<String, Integer> map;
    private Formation formation;
    private Identite identite;
    private Etudiant etudiant;

    @Before
    public void avant(){
        // on nomme deux matieres
        matiere = "maths";
        matiere2 = "Francais";

        // on cree le coeff de chacune
        coeff = 1;
        coeff2 = 2;

        // on cree une map pour la liste des matieres de la formation
        map = new HashMap<String, Integer>();

        // on put les deux matieres avec leur coeff dedans
        map.put(matiere, coeff);
        map.put(matiere2, coeff2);

        // on nomme la formation en lui ajoutant la map contenant les matieres
        formation = new Formation("s3d", map);

        // on assigne une identite a l etudiant et on lui donne la formation cree avant
        identite = new Identite("10000","pol","caillou");
        etudiant = new Etudiant(identite, formation);

    }

    @Test
    public void TestAjouterNote() {
        float note = 10f;
        etudiant.ajouterNote(matiere, note);
        assertEquals("la note de maths devrait etre 10", 10f, etudiant.getResultats().values().toArray()[0]);
    }

    @Test
    public void TestCalculMoyenneMatiere(){
        float res = 12.5F;
        etudiant.ajouterNote(matiere, 10f);
        etudiant.ajouterNote(matiere, 15f);
        float test = etudiant.calculMoyenneMatiere(matiere);
        System.out.println(etudiant.getResultats());
        assertEquals("la moyenne est censée etre de 12.5", res, test, 0);
    }

    @Test
    public void TestMoyenneGenerale(){
        float moyenne = 9;
        // moyenne de 10*1
        etudiant.ajouterNote(matiere, 8);
        etudiant.ajouterNote(matiere, 12);

        // moyenne de 8.5*2
        etudiant.ajouterNote(matiere2, 8.5F);

        // 10 + 17 = 27 / 3 = 9 car le coeff total etait de 9
        float test = etudiant.calculMoyenneGenerale();
        assertEquals("la moyenne generale de l'etudiant devrait etre", moyenne, test, 0);
    }






}
