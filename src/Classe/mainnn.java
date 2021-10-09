package Classe;

import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mainnn {

    public static void main(String[] args) {
            // on cree une map qui accueillera les matieres et coeff souhaites
            Map<String, Integer> matieres = new HashMap<>();
            //valeurs ajoutees dans les matieres
            matieres.put("anglais",2);
            matieres.put("prog",3);
            matieres.put("gestion",6);

            // formation des s2e composee de la liste des matieres
            Formation form = new Formation("s2e",matieres);

            // creation des identites
            Identite id0 = new Identite("0","brackmard","denis");

            // creation des etudiants vides
            Etudiant etu0 = new Etudiant(id0, form);
            // ajout de notes aux etudiants
            etu0.ajouterNote("anglais", 15);
            etu0.ajouterNote("anglais", 10);
            etu0.ajouterNote("prog", 10);
            etu0.ajouterNote("gestion", 18);

            System.out.println(etu0.calculMoyenneMatiere("anglais"));
            System.out.println(etu0.getResultats());
    }
}
