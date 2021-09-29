package Classe;

import Classe.Formation;
import Classe.Identite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Etudiant {

    private Identite id;
    private Formation formation;
    private Map<String, Float> resultats;

    public Etudiant(Identite identite, Formation form){
        this.id = identite;
        this.formation = form;
        this.resultats = new HashMap<String, Float>();
    }

    public void ajouterNote(String matiere, float note){
        if (note>0 && note<20 && formation.getListeMatiere().containsKey(matiere)){
            resultats.put(matiere, note);
        } else {
            System.out.println("La note ajoutee ne respecte pas les conventions\nou\nLa matière n est pas compris dans la formation de l'etudiant");
        }
    }

    public float calculMoyenneMatiere(String matiere){
        float moyenne = 0;
        float sommeNotes = 0;
        if (formation.getListeMatiere().containsKey(matiere)){
            ArrayList<Float> notes = new ArrayList<>();
            int nombreNotes = 0;
            for (int i = 0; i<resultats.keySet().size();i++){
                notes.add(resultats.get(matiere));
                nombreNotes++;
            }
            for (int j = 0; j<notes.size();j++){
                sommeNotes += notes.get(j);
            }
            moyenne = sommeNotes/nombreNotes;
        }
        return moyenne;
    }


    // pour toutes
    /**Iterator<String> ite = formation.getListeMatiere().keySet().iterator();
     while(ite.hasNext()){
     String m = ite.next();
     }*/
}
