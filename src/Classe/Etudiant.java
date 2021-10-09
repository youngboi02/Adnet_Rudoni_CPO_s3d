package Classe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Etudiant{

    private Identite id;
    private Formation formation;
    private Map<String, ArrayList<Float>> resultats;

    public Etudiant(Identite identite, Formation form){
        this.id = identite;
        this.formation = form;
        this.resultats = new HashMap<String, ArrayList<Float>>();
    }

    public void ajouterNote(String matiere, float note){
        if (note>0 && note<20 && formation.getListeMatiere().containsKey(matiere)){
            if (this.getResultats().containsKey(matiere)){
                // si la matiere existe deja dans la map, on ajoute seulement la note
                resultats.get(matiere).add(note);
            } else {
                // sinon on cree une liste de notes pour la nouvele matiere
                ArrayList<Float> listeNotesMat =  new ArrayList<>();
                // on cree ainsi le lien key et value
                resultats.put(matiere, listeNotesMat);
                // on ajoute la note dans la liste des notes de la matiere
                listeNotesMat.add(note);
            }
        } else {
            System.out.println("La note ajoutee ne respecte pas les conventions\nou\nLa matière n est pas compris dans la formation de l'etudiant");
        }
    }

    public float calculMoyenneMatiere(String matiere){
        int nombreNotes = 0;
        float sommeNotes = 0;
        if (formation.getListeMatiere().containsKey(matiere)){
            for (Float notes : resultats.get(matiere)){
                sommeNotes += notes;
                nombreNotes++;
            }
        }
        return sommeNotes/nombreNotes;
    }

    public float calculMoyenneGenerale() {
        float moyenneGen = 0;
        float coeffTot = 0;
        // on fait la moyenne d'une matiere qu'on multiplie par son coeff
        Iterator<String> ite = formation.getListeMatiere().keySet().iterator();
        while(ite.hasNext()) {
            String m = ite.next();
            float moyenneUneMatiere = calculMoyenneMatiere(m);
            moyenneGen += moyenneUneMatiere * formation.getMatiereCoef(m);
            coeffTot += formation.getMatiereCoef(m);
        }
        // on fait la somme de toutes les moyennes qu'on divise part le total des coeff
        return moyenneGen/coeffTot;
    }

    public Map<String, ArrayList<Float>> getResultats() {
        return this.resultats;
    }

    public Identite getId() {
        return id;
    }

    public Formation getFormation() {
        return formation;
    }

}
