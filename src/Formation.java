import java.util.Map;

public class Formation {

    private String id;
    Map<String, Integer> listeMatiere;

    public Formation(String id1, Map<String, Integer> l ){
        this.id = id1;
        this.listeMatiere = l;
    }

    public void ajouter(){
        //to do
    }

    public void supprimer(){
        //to do
    }



    public String getId() {
        return id;
    }

    public Map<String, Integer> getListeMatiere() {
        return listeMatiere;
    }
}
