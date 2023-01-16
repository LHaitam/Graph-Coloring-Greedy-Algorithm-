// A Java program to implement greedy algorithm for graph coloring
import java.io.*;
import java.util.*;

//Cette classe représente un graphe non orienté utilisant une liste d'adjacence
class Graph
{
	private int V; // Nombre de sommets
	private LinkedList<Integer> adj[]; // Liste d'adjacence

	// Constructeur
	Graph(int v)
	{
		V = v;
		adj = new LinkedList[v];
		for (int i=0; i<v; ++i)
			adj[i] = new LinkedList();
	} 

	// Fonction pour ajouter une arête dans le graphe
	void addEdge(int v,int w)
	{
		adj[v].add(w);
		adj[w].add(v); //Le graph n'est pas orienté
	}

	// Attribue des couleurs (à partir de 0) à tous les sommets et
	// imprime l'affectation des couleurs
	void Coloriage()
	{
		int result[] = new int[V];

		// Initialiser tous les sommets comme non assignés
		Arrays.fill(result, -1);

		// Attribuer la première couleur au premier sommet
		result[0] = 0;

		// Un tableau temporaire pour stocker les couleurs disponibles. False
		// la valeur du [cr] disponible signifierait que la couleur cr est
		// affecté à l'un de ses sommets adjacents
		boolean available[] = new boolean[V];
		
		// Au départ, toutes les couleurs sont disponibles
		Arrays.fill(available, true);

		// Attribuer des couleurs aux sommets V-1 restants
		for (int u = 1; u < V; u++)
		{
			// Traite tous les sommets adjacents et marque leurs couleurs
			// comme indisponible
			Iterator<Integer> it = adj[u].iterator() ;
			while (it.hasNext())
			{
				int i = it.next();
				if (result[i] != -1)
					available[result[i]] = false;
			}

			// Trouver la première couleur disponible
			int cr;
			for (cr = 0; cr < V; cr++){
				if (available[cr])
					break;
			}

			result[u] = cr; // Attribuez la couleur trouvée

			// Réinitialisez les valeurs à true pour la prochaine itération
			Arrays.fill(available, true);
		}

		// afficher le résultat
		for (int u = 0; u < V; u++)
			System.out.println("Sommet " + u + " ---> Couleur "+ result[u]);
	}

	// Main
	public static void main(String args[])
	{
		System.out.println("-------------------------------------------------------  BONJOUR  --------------------------------------------------------");
		System.out.println("");
		System.out.println("");
		System.out.println("Ce petit programme permet le coloriage d'un graph suivant l'algorithme glouton (Coloration gloutonne)");
		System.out.println("");
		System.out.println("Comment l'utiliser ? C'est simple !");
		System.out.println("");
		System.out.println("Vous devez d'abord entrer le nombre de sommet de votre graph ;");
		System.out.println("Ensuite vous devez créer les arêtes entre vos sommets (on attribue à chaque sommet un chiffre positif comme nom : sommet 0, 1, 2...) .");
		System.out.println("Enfin vous aurez les résultat comme suivant :");
		System.out.println("Exemple du résulat : ");
		System.out.println("Coloration du graph");
		System.out.println("Sommet 0 ---> Couleur 0");
		System.out.println("Sommet 1 ---> Couleur 1");
		System.out.println("Sommet 2 ---> Couleur 2");
		System.out.println("Sommet 3 ---> Couleur 0");
		System.out.println("Sommet 4 ---> Couleur 3");
		System.out.println("");System.out.println("");
		System.out.println("--------------------------------------------------  DEBUT DU PROGRAMME  --------------------------------------------------");
		System.out.println("");System.out.println("");
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrer le nombre des sommets : ");
        int nbSommets = sc.nextInt();
        sc.nextLine();
		Graph g1 = new Graph(nbSommets);
		System.out.println("Entrer les arêtes : (pour terminer entrer -1)");
		boolean b=true;
		while(b==true)
		{
			System.out.print("Il y'a une arête entre le sommet : ");
			int x = sc.nextInt();
//			System.out.println("et le sommet : ");
//			int y = sc.nextInt();
			if(x==-1) {
				b=false;
				System.out.println("Coloration du graph :");
				g1.Coloriage();
			}
			else {
				System.out.print("et le sommet : ");
				int y = sc.nextInt();
				g1.addEdge(x, y);
			}
			
		}
//		g1.addEdge(0, 1);
//		g1.addEdge(0, 2);
//		g1.addEdge(0, 3);
//		g1.addEdge(1, 2);
//		g1.addEdge(1, 3);
//		g1.addEdge(2, 3);
//		g1.addEdge(3, 4);
//		System.out.println("Coloration du graph 1");
//		g1.Coloriage();

//		System.out.println();
//		Graph g2 = new Graph(5);
//		g2.addEdge(0, 1);
//		g2.addEdge(0, 2);
//		g2.addEdge(1, 2);
//		g2.addEdge(1, 4);
//		g2.addEdge(2, 4);
//		g2.addEdge(4, 3);
//		System.out.println("Coloration du graph 2 ");
//		g2.Coloriage();
	}
}
