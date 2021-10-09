package test;

import Classe.Formation;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;

import static org.junit.Assert.*;

public class TestFormation {

    private String matiere;
    private int coeff;
    private HashMap<String, Integer> map;
    private Formation form, formNull;

    private boolean res;

    @Before
    public void avant(){
        matiere = "maths";
        coeff = 3;
        map = new HashMap<>();
        map.put(matiere, coeff);
        form = new Formation("matiere", map);
    }

    // test du constructeur
    @Test
    public void TestConstructeur(){
        res = true;
        if (form == null) res = false;
        assertTrue("res devrait etre true", res);
    }

    // formation nulle, pas d'id ni de map assignees
    @Test
    public void TestConstructeurNull(){
        res = false;
        System.out.println(formNull);
        if (formNull == null) res = true;
        assertTrue("res devrait etre true", res);
    }

    // test si la matiere existe dans la hashmap
    @Test
    public void TestMatiereExsitante(){
        res = map.containsKey("maths");
        assertTrue("res devrait etre true", res);
    }

    // test si la matiere n existe pas dans la hashmap
    @Test
    public void TestMatiereInexistante(){
        res = map.containsKey("denis");
        assertFalse("res devrait etre false", res);
    }

    // test pour ajouter une matiere dans la hashmap
    @Test
    public void TestAjouterOK(){
        form.ajouter("philo", 12);
        int coeff = map.get("philo");
        assertTrue("philo devrait exister dans la formation",form.getListeMatiere().containsKey("philo"));
        assertEquals("philo devrait avoir un coeff de 12",12, coeff);
    }

    @Test
    public void TestAjouterMatiereDejaExistante(){
        form.ajouter("philo", 12);
        form.ajouter("philo", 10);
        int coeff = map.get("philo");
        assertEquals("la matiere devrait avoir un coeff de 12 car elle existe deja", 12, coeff);
    }

    // test de suppression avec 2 arguments
    @Test
    public void TestSupprimerOK(){
        form.supprimer("maths",3);
        assertFalse(map.containsKey("maths"));
    }

    @Test
    public void TestSupprimerMatiereInexistante(){
        form.supprimer("algo",3);
        assertEquals("la map ne peut pas supprimer algo alors qu'elle ne compte pas parmis les matieres", false, map.containsKey("algo"));
    }

}
