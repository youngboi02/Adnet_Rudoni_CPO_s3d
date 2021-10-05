package Classe;

import java.util.Iterator;
import java.util.List;

public class Groupe {

    Formation formation;
    List<Etudiant> listeEtu;

    public Groupe(Formation f, List<Etudiant> l){
        this.formation = f;
        this.listeEtu = l;
    }

    public void ajouter(Etudiant etudiant){
        boolean res = listeEtu.contains(etudiant);
        if(!res && etudiant.getFormation() == this.formation){
            listeEtu.add(etudiant);
        }
    }

    public void supprimer(Etudiant etudiant){
        boolean res = listeEtu.contains(etudiant);
        if(res){
            listeEtu.remove(etudiant);
        }
    }

    public float calculerMoyenneMatiere(String matiere){
        float res = 0;
        for (Etudiant etud : listeEtu){
            res += etud.calculMoyenneMatiere(matiere);
        }
        return res/listeEtu.size();
    }

    public float calculerMoyenneGenerale(){
        float res = 0;
        for (Etudiant etu : listeEtu){
            res += etu.calculMoyenneGenerale();
        }
        res = res/listeEtu.size();
        return res;
    }

    public Formation getFormation() {
        return formation;
    }

    public List<Etudiant> getListeEtu() {
        return listeEtu;
    }
}
