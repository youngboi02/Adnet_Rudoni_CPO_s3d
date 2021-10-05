package test;

import Classe.Etudiant;
import Classe.Formation;
import Classe.Groupe;
import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestGroupe {

    @Before
    public void avant(){

        // on cree une map qui accueillera les matieres et coeff souhaites
        Map<String, Integer> matieres = new HashMap<>();
        //valeurs ajoutees dans les matieres
        matieres.put("anglais",2);
        matieres.put("prog",3);
        matieres.put("gestion",6);

        // formation des s2e composee de la liste des matieres
        Formation form = new Formation("s2e",matieres);

        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(new Etudiant());

        Groupe grp = new Groupe(form, etudiants);
    }
}
