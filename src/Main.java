import java.lang.constant.Constable;
import java.util.*;

import static java.lang.System.exit;

public class Main
{
    public static void main(String[] args)
    {
        Stack<Integer> stack1 = new Stack<Integer>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        Stack<Integer> stack2 = new Stack<Integer>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);

        Etat Initial = new Etat(stack1,new Stack<Integer>(),new Stack<Integer>());
        Etat But = new Etat(new Stack<Integer>(),new Stack<Integer>(),stack2);
        Probleme P = new Probleme(Initial, But);
        Noeud noeud = new Noeud(null,new Etat(P.Initial));

        System.out.println("\n\n===============================DFSRecu=====================================\n\n");
        DFSRecu(P,noeud,new Stack<Etat>(),new ArrayList<Etat>(),1);
        System.out.println("\n\n===============================DFS=====================================\n\n");
        DFS(P,noeud);
        System.out.println("\n\n===============================BFS=====================================\n\n");
        BFS(P,noeud);


    }

    public static void BFS(Probleme P, Noeud noeud)
    {
        if(P.BUT_TEST(noeud.etat))
        {
            System.out.println(noeud.etat);
            return;
        }

        LinkedList<Etat> frontiere = new LinkedList<Etat>();
        frontiere.add(noeud.etat);
        List<Etat> visites = new ArrayList<Etat>();
        int i=1;
        while(true)
        {
            if(frontiere.isEmpty())
            {
                return ;
            }
            else{
                Etat et = frontiere.removeFirst();
                visites.add(et);
                LinkedList<Etat> Etats = P.Actions(et);
                Noeud fils;
                for (Etat etat : Etats)
                {
                    fils = NOEUD_FILS(noeud,etat);
                    if (frontiere.indexOf(fils.etat) == -1 && visites.indexOf(fils.etat) == -1)
                    {
                        if(P.BUT_TEST(fils.etat))
                        {System.out.println("\nCoutBFS="+i);
                            System.out.println(fils.etat);
                            exit(1);
                        }else {
                            System.out.println(fils.etat);
                            frontiere.add(fils.etat);
                        }
                    }
                    /*System.out.println("["+i+"]"+frontiere.get(i));
                    System.out.println("HEY");
                    Scanner sc = new Scanner(System.in);
                    sc.nextLine();
                    */
                }
            }
            i++;
        }
    }

    public static void DFS(Probleme P, Noeud noeud) {
        Stack<Etat> frontiere = new Stack<Etat>();
        frontiere.push(noeud.etat);
        List<Etat> visites = new ArrayList<Etat>();
        int i = 1;
        while (true) {
            if (frontiere.isEmpty()) {
                return;
            } else {
                Etat et = frontiere.pop();
                if (P.BUT_TEST(et))
                {
                    System.out.println("\nCoutDFS="+i);
                    return;
                } else {
                    visites.add(et);
                    LinkedList<Etat> Etats = P.Actions(et);
                    Noeud fils;
                    for (Etat etat : Etats) {
                        fils = NOEUD_FILS(noeud, etat);
                        if (frontiere.search(fils.etat) == -1 && visites.indexOf(fils.etat) == -1)
                        {
                                System.out.println(fils.etat);
                                frontiere.push(fils.etat);
                        }
                    }
                    /*System.out.println("["+i+"]"+frontiere.get(i));
                    System.out.println("HEY");
                    Scanner sc = new Scanner(System.in);
                    sc.nextLine();
                    */
                }
            }
            i++;
        }
    }

    public static int DFSRecu(Probleme P, Noeud noeud, Stack<Etat> front, List<Etat> vis, int j) {
        Stack<Etat> frontiere = front;
        frontiere.push(noeud.etat);
        List<Etat> visites = vis;
        int i = j;
        while (true) {
            if (frontiere.isEmpty()) {
                return 0;
            } else {
                Etat et = frontiere.pop();
                if (P.BUT_TEST(et))
                {
                    System.out.println("\nCoutDFSRecu="+i);
                    return 1;
                } else {
                    visites.add(et);
                    LinkedList<Etat> Etats = P.Actions(et);
                    Noeud fils;
                    for (Etat etat : Etats) {
                        fils = NOEUD_FILS(noeud, etat);
                        if (frontiere.search(fils.etat) == -1 && visites.indexOf(fils.etat) == -1)
                        {
                            System.out.println(fils.etat);
                            if(DFSRecu(P,fils,frontiere,visites,++i)==1) return 1;
                        }
                    }
                }
            }
        }
    }

    public static Noeud NOEUD_FILS(Noeud n, Etat e)
    {
        Noeud no = new Noeud(n,new Etat(e));
        n.next.add(no);
        return no;
    }
}