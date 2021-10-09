package test;

import Classe.Etudiant;
import Classe.Formation;
import Classe.Groupe;
import Classe.Identite;
import org.junit.Before;
import org.junit.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestGroupeAdnet {

    private Groupe group;
    private Map<String, Integer> matieres;
    private Formation form;
    private List<Etudiant> etudiants;
    private Identite id0, id1, id2;
    private Etudiant etu0, etu1, etu2;

    @Before
    public void avant(){

        // on cree une map qui accueillera les matieres et coeff souhaites
        matieres = new HashMap<>();
        //valeurs ajoutees dans les matieres
        matieres.put("anglais",2);
        matieres.put("prog",3);
        matieres.put("gestion",6);

        // formation des s2e composee de la liste des matieres
        form = new Formation("s2e",matieres);

        etudiants = new ArrayList<>();

        // creation des identites
        id0 = new Identite("0","brackmard","denis");
        id1 = new Identite("1","vingron","stivine");
        id2 = new Identite("2","mergonvillerelai","axelandre");

        // creation des etudiants vides
        etu0 = new Etudiant(id0, form);
        etu1 = new Etudiant(id1, form);
        etu2 = new Etudiant(id2, form);

        // ajout de notes aux etudiants
        etu0.ajouterNote("anglais", 15);
        etu0.ajouterNote("prog", 10);
        etu0.ajouterNote("gestion", 18);

        etu1.ajouterNote("anglais", 13);
        etu1.ajouterNote("prog", 11);
        etu1.ajouterNote("gestion", 17);

        etu2.ajouterNote("anglais", 18);
        etu2.ajouterNote("prog", 19);
        etu2.ajouterNote("gestion", 5);

        // ajout des etudiants a la liste d etudiants
        etudiants.add(etu0);
        etudiants.add(etu1);
        etudiants.add(etu2);

        group = new Groupe(form, etudiants);
    }


    @Test
    public void TestMoyenneMatiereValide(){
        // on recupere la moyenne en float, donc bcp de decimales
        float res = group.calculerMoyenneMatiere("anglais");

        // on le tronque en le passant en string
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.DOWN);
        String s = df.format(res);

        assertEquals("la moyenne devrait etre 15,3","15,33",s);
    }

    @Test
    public void TestMoyenneGeneraleValide(){
        // on recupere la moyenne en float, donc bcp de decimales
        float res = group.calculerMoyenneGenerale();

        // on le tronque en le passant en string
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.DOWN);
        String s = df.format(res);

        assertEquals("la moyenne devrait etre 13,69","13,69",s);
    }

}
