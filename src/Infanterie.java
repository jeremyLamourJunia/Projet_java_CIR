public class Infanterie extends Unité{
    Type_infanterie type_infanterie;
    public Infanterie(String nom,int coût, Type_infanterie type_infanterie){
        super(nom,coût);
        this.type_infanterie = type_infanterie;
    }

    public Type_infanterie getType_infanterie() {
        return type_infanterie;
    }

    public void setType_infanterie(Type_infanterie type_infanterie) {
        this.type_infanterie = type_infanterie;
    }
    @Override
    public String toString() {
        return "Unité 'Infanterie' => nom : "+nom+" ; Type infanterie : "+type_infanterie+" ; Coût de l'unité "+coût;
    }
}
