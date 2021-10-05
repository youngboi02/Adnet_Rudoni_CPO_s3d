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
    private Formation form;

    private boolean res;

    @Before
    public void avant(){
        matiere = "maths";
        coeff = 3;
        map= new HashMap<>();
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

    // test si la matiere existe dans la hashmap
    @Test
    public void TestMatiereExsitante(){
        res = map.containsKey("maths");
        assertTrue("res devrait etre true", res);
    }

    // test pour ajouter une matiere dans la hashmap
    @Test
    public void TestAjouter(){
        map.put("philo", 12);
        int oh = map.get("philo");
        assertEquals("philo devrait avoir un coeff de 12",12, oh);
    }

    // test de suppression avec 2 arguments pour etre sur de cibler la bonne matiere
    @Test
    public void TestSupprimer2Args(){
        map.remove("maths",3);
        assertFalse(map.containsKey("maths"));
    }

    // test de suppression general
    @Test
    public void TestSupprimer(){
        map.remove("maths");
        assertFalse(map.containsKey("maths"));
    }

}
