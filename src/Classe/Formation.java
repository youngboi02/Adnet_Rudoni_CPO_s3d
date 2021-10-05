package Classe;

import java.util.Map;
import java.util.Set;

public class Formation {

    private String id;
    Map<String, Integer> listeMatiere;

    public Formation(String id1, Map<String, Integer> l ){
        this.id = id1;
        this.listeMatiere = l;
    }

    public void ajouter(String matiere, Integer coef){
        boolean res = listeMatiere.containsKey(matiere);
        if(!res){
            listeMatiere.put(matiere, coef);
        }
    }

    public void supprimer(String matiere, Integer coef){
        boolean res = listeMatiere.containsKey(matiere);
        if(res){
            listeMatiere.remove(matiere, coef);
        }
    }

    public int getMatiereCoef(String matiere){
        return this.listeMatiere.get(matiere);
    }

    public String getId() {
        return id;
    }

    public Map<String, Integer> getListeMatiere() {
        return listeMatiere;
    }
}
