import java.util.ArrayList;
import java.util.List;

public class Noeud implements Comparable<Noeud>
{
    Noeud previous;
    List<Noeud> next = new ArrayList<Noeud>();
    Etat etat;

    public Noeud(Noeud prev,Etat e)
    {
        previous=prev;
        etat = e;
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(Noeud o) {
        return 0;
    }
}
