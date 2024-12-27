import java.util.ArrayList;
import java.util.List;

public class Gestion {
    public List<Armée> List_Armée= new ArrayList<>();
    public Gestion() {

    }
    public void print(){
        System.out.println("Voici un détail de toutes les armées : ");
        for( Armée s:List_Armée){
            s.print();
        }
    }


}
