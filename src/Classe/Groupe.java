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

    public void triAlpha() {
        this.listeEtu.sort(new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant o1, Etudiant o2) {
                String nom1 = o1.getId().getNom();
                String nom2 = o2.getId().getNom();
                String prenom1 = nom1 + o1.getId().getNom();
                String prenom2 = nom2 + o2.getId().getNom();
                int compare = prenom1.compareTo(prenom2);
                if(compare < 0) return -1;
                if (compare > 0) return 1;
                return 0;
            }
        });
    }



    public ArrayList<String> triParMerite() {

        ArrayList<String> listeTriee = new ArrayList<>();

        for (int i = 0; i < listeEtu.size(); i++) {
            int i2 = i;
            for (int j = i + 1; j < listeEtu.size(); j++) {
                if (listeEtu.get(j).calculMoyenneGenerale() > listeEtu.get(i2).calculMoyenneGenerale()) {
                    i2 = j;
                }
            }
            Etudiant etuFirst = listeEtu.get(i);
            Etudiant etuSecond = listeEtu.get(i2);

            String etu0 = etuFirst.getId().getNom() + " " + etuFirst.getId().getPrenom() + " : " + etuFirst.calculMoyenneGenerale();
            String etu1 = etuSecond.getId().getNom() + " " +etuSecond.getId().getPrenom() + " : " + etuSecond.calculMoyenneGenerale();
            listeTriee.add(i2, etu0);
            listeTriee.add(i, etu1);
        }
        return listeTriee;
    }
}
