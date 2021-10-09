package Classe;

import java.util.*;


public class Groupe {

    Formation formation;
    List<Etudiant> listeEtu;

    public Groupe(Formation f, List<Etudiant> l) {
        this.formation = f;
        this.listeEtu = l;
    }

    public void ajouter(Etudiant etudiant) {
        boolean res = listeEtu.contains(etudiant);
        if (!res && etudiant.getFormation() == this.formation) {
            listeEtu.add(etudiant);
        }
    }

    public void supprimer(Etudiant etudiant) {
        boolean res = listeEtu.contains(etudiant);
        if (res) {
            listeEtu.remove(etudiant);
        }
    }

    public float calculerMoyenneMatiere(String matiere) {
        float res = 0;
        for (Etudiant etud : listeEtu) {
            res += etud.calculMoyenneMatiere(matiere);
        }
        return res / listeEtu.size();
    }

    public float calculerMoyenneGenerale() {
        float res = 0;
        for (Etudiant etu : listeEtu) {
            res += etu.calculMoyenneGenerale();
        }
        res = res / listeEtu.size();
        return res;
    }

    public Formation getFormation() {
        return formation;
    }

    public List<Etudiant> getListeEtu() {
        return listeEtu;
    }

    /**public List<Etudiant> triAlpha() {
        for (int i = 0; i < listeEtu.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < listeEtu.size(); j++) {
                if (listeEtu.get(j).getId().getNom().compareTo(listeEtu.get(index).getId().getNom()) < 0) {
                    index = j;
                }
            }
            Etudiant min = listeEtu.get(index);
            listeEtu.get(index) = listeEtu.get(i);
            listeEtu.get(i) = min;
        }
    }
     */

    /**
    public ArrayList<String> triParMerite(){
         // je prends le nom d'un etudiant auquel j'ajoute sa moyenne générale
        for (Etudiant etu : listeEtu){
            System.out.println(etu.getId().getNom()+etu.getId().getPrenom()+":"+etu.calculMoyenneGenerale());
        }
     */
}
