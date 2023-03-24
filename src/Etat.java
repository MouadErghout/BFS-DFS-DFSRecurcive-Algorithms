import java.util.Stack;

public class Etat
{
    Stack<Integer> One;
    Stack<Integer> Two;
    Stack<Integer> Three;

    public Etat(Stack<Integer> one, Stack<Integer> two, Stack<Integer> three)
    {
        One=one;
        Two=two;
        Three= three;
    }

    public Etat(Etat e)
    {
        One = new Stack<Integer>();
        Two = new Stack<Integer>();
        Three = new Stack<Integer>();
        int i=0;
        while(i<e.One.size())
        {
            One.push((e.One.get(i)));
            i++;
        }
        i=0;
        while(i<e.Two.size())
        {
            Two.push((e.Two.get(i)));
            i++;
        }
        i=0;
        while(i<e.Three.size())
        {
            Three.push((e.Three.get(i)));
            i++;
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        int i=0;
        if(((Etat)obj).One.size()==One.size() && ((Etat)obj).Two.size()==Two.size() && ((Etat)obj).Three.size()==Three.size())
        {
            while (i < One.size())
            {
                if (((Etat) obj).One.get(i) != One.get(i))
                    return false;
                i++;
            }
            i = 0;
            while (i < Two.size())
            {
                if (((Etat) obj).Two.get(i) != Two.get(i))
                    return false;
                i++;
            }
            i = 0;
            while (i < Three.size())
            {
                if (((Etat) obj).Three.get(i) != Three.get(i))
                    return false;
                i++;
            }
        }else return false;
        return true;
    }

    @Override
    public String toString() {
        String s =  "Etat{ One=" ;
        int i=0;
        while(i<One.size())
        {
            s=s+One.get(i)+"/";
            i++;
        }
        i=0;
        s+="\n Two=";
        while(i<Two.size())
        {
            s=s+Two.get(i)+"/";
            i++;
        }
        i=0;
        s+="\n Three=";
        while(i<Three.size())
        {
            s=s+Three.get(i)+"/";
            i++;
        }
        return s;
    }
}
