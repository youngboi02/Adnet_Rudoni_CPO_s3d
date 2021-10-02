package Classe;

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

    public double calculerMoyenneGroupe(){
        // return
    }

    public double calculerMoyenneGenerale(){
        // return
    }
}
