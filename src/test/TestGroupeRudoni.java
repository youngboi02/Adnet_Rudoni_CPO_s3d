package test;
import Classe.Etudiant;
import Classe.Formation;
import Classe.Groupe;
import Classe.Identite;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class TestGroupeRudoni {

    private Groupe groupe;
    private Map<String, Integer> matieres;
    private Formation formation;
    private List<Etudiant> etudiants;
    private Identite id0, id1;
    private Etudiant et0, et1;

    @Before
    public void avant(){
        matieres = new HashMap<>();
        matieres.put("c3po", 1);
        matieres.put("R2D2", 1);

        formation = new Formation("S2Elite", matieres);

        etudiants = new ArrayList<>();

        id0 = new Identite("0", "ochon", "paul");
        id1 = new Identite("1", "guigzome", "guigz");


        et0 = new Etudiant(id0, formation);
        et1 = new Etudiant(id1,formation);

        etudiants.add(et0);
        etudiants.add(et1);

        groupe = new Groupe(formation, etudiants);
    }

    @Test
    public void TestCalculMoyenneMatiere(){
        et0.ajouterNote("c3po", 10);
        et1.ajouterNote("c3po", 15);
        float res = groupe.calculerMoyenneMatiere("c3po");
        assertEquals("la moyenne devrait etre 12.5", 12.5f, res, 0);
    }

    @Test

    public void TestCalculerMoyenneGenerale(){
        et0.ajouterNote("c3po", 10);
        et1.ajouterNote("c3po", 15);
        et0.ajouterNote("R2D2", 10);
        et1.ajouterNote("R2D2", 15);
        groupe.calculerMoyenneMatiere("c3po");
        groupe.calculerMoyenneMatiere("R2D2");
        float res = groupe.calculerMoyenneGenerale();
        assertEquals("la moyenne generale devrait etre de 12.5", 12.5f, res, 0);
    }

    @Test
    public void TestAjouter(){
        Identite id2 = new Identite("2", "rudi", "nosaure");
        Etudiant et2 = new Etudiant(id2, formation);
        etudiants.add(et2);
        groupe.ajouter(et2);
        assertEquals("l'etudiant devrait ajouter a la formation", groupe.getListeEtu().get(2), et2);
    }

    @Test
    public void TestSupprimer(){
        Identite id2 = new Identite("2", "rudi", "nosaure");
        Etudiant et2 = new Etudiant(id2, formation);
        etudiants.add(et2);
        groupe.ajouter(et2);
        int taille = etudiants.size() - 1;
        groupe.supprimer(et2);
        int tailleApres = etudiants.size();
        assertEquals("l'etudiant devrait ajouter a la formation", taille, tailleApres);
    }

    @Test
    public void TestTriAlpha(){
        groupe.triAlpha();
        String guigz = etudiants.get(0).getId().getNom();
        assertEquals("l'etudiant en tete de liste devrait etre guigzome", etudiants.get(0).getId().getNom(), guigz);
    }


}
