package Classe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

    public Formation getFormation() {
        return formation;
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

    public float calculMoyenneGenerale() {
        float moyenneGen = 0;
        float coeffTot = 0;
        // on fait la moyenne d'une matiere qu'on multiplie par son coeff
        Iterator<String> ite = formation.getListeMatiere().keySet().iterator();
        while(ite.hasNext()) {
            String m = ite.next();
            float moyCoef = calculMoyenneMatiere(m);
            moyenneGen += moyCoef * formation.getMatiereCoef(m);
            coeffTot += formation.getMatiereCoef(m);
        }
        // pour chaque matière, on cherche le coeff qu'on additionne avec les autres
        moyenneGen = moyenneGen/coeffTot;
        // on fait la somme de toutes les moyennes qu'on divise part le total des coeff
        return moyenneGen;
    }

    public Map<String, Float> getNotes() {
        return this.resultats;
    }
    // pour toutes
    /**Iterator<String> ite = formation.getListeMatiere().keySet().iterator();
     while(ite.hasNext()){
     String m = ite.next();
     }*/
}
