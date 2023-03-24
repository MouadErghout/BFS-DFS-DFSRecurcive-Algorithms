import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Probleme
{
     Etat Initial = new Etat(new Stack<Integer>(),new Stack<Integer>(),new Stack<Integer>());
     Etat But = new Etat(new Stack<Integer>(),new Stack<Integer>(),new Stack<Integer>());

    public Probleme(Etat init, Etat but)
    {
        Initial = init;
        But = but;
    }

    public LinkedList<Etat> Actions(Etat e)
    {
        LinkedList<Etat> L = new LinkedList<Etat>();
        Etat et = new Etat(e);
        //L'ordre de création des actions pour un état initial et final donnés joue sur l'optimalité

        if(e.Three.size()>0)
        {
            et = new Etat(e);
            et.One.push(et.Three.pop());
            L.add(et);

            et = new Etat(e);
            et.Two.push(et.Three.pop());
            L.add(et);
        }
        if(e.One.size()>0)
        {
            et.Two.push(et.One.pop());
            L.add(et);


            et = new Etat(e);
            et.Three.push(et.One.pop());
            L.add(et);
        }
        if(e.Two.size()>0)
        {
            et = new Etat(e);
            et.One.push(et.Two.pop());
            L.add(et);

            et = new Etat(e);
            et.Three.push(et.Two.pop());
            L.add(et);
        }



        return L;
    }

    public boolean BUT_TEST(Etat e)
    {
        return e.equals(But);
    }
}
