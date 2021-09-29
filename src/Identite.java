public class Identite {

    private String nip, nom, prenom;

    public Identite(String identif, String n, String p){
        if (!identif.isEmpty() && !n.isEmpty() && !p.isEmpty()){
            this.nip = identif;
            this.nom = n;
            this.prenom = p;
        }
    }

    public String getNip() {
        return nip;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

}
