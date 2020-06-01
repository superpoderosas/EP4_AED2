import java.io.IOException;
import java.io.File;
import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;

public class AiQueFrio {

    public static void main(String[] args) throws IOException {
        
        LinkedList<LinkedList<Integer>> grafo = ProcessaDados();  
        FileWriter file = new FileWriter("LevamosBronca.txt");
        PrintWriter saida = new PrintWriter(file);

        for(int i = 0; i < grafo.size(); i++){
            System.out.println("Vendo as distancias do vertice " + i);
            int [] distancias = Busca(grafo, i);
            for(int a = i+1; a < distancias.length; a ++){

                if(distancias[a] != -1) saida.println(distancias[a]);
            }
        }

        saida.close();

    }

    private static int[] Busca(LinkedList<LinkedList<Integer>> grafo, int vertice) {

        int cont = 0;

        int [] num = new int [grafo.size()];
        for(int i = 0; i < num.length; i++) num[i] = -1;

        LinkedList<Integer> fila = new LinkedList<>();
        num[vertice] = cont++;
        fila.add(vertice);

        while(!fila.isEmpty()){
            
            int v = fila.getFirst();
            fila.removeFirst();

            for(int c : grafo.get(v)){
                if(num[c] == -1){

                    num[c] = cont++;
                    fila.addLast(c);
                }
            }
        }

        fila.clear();
        return num;
    }


    private static LinkedList<LinkedList<Integer>> ProcessaDados() throws IOException {

        String caminho = "/home/lorenabraghini/Documents/Arquivos Faculdade/EPs/AED/traducao1.txt"; 

        File graph = new File(caminho);
        Scanner sc = new Scanner(graph);
                
        LinkedList<LinkedList<Integer>> nosss = new LinkedList<LinkedList<Integer>>();
        
        for(int i = 0; i < 61839; i++) nosss.add(new LinkedList<Integer>());
                
        sc.nextLine();
        sc.nextLine();
        int m = 0;
        while(sc.hasNext()){
            m++;
            System.out.println(m);
            String afff = sc.nextLine();
            String [] saco = afff.split(" ");
            
            int maria = Integer.parseInt(saco[1]);
            
            nosss.get(maria).add(Integer.parseInt(saco[0]));
        }
        sc.close();

        return nosss;   
    }    
}