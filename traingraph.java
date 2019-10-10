import java.util.*;
public class trainGraph
{
    private final int vertexCount;
    Map<String, Integer> data = new HashMap<String, Integer>();
    Map<Integer, String> reversedata = new HashMap<Integer, String>();
    private double graph[][];
    final static double INF = 999999; //Our max value for this program
    public trainGraph(int verticies)
    {
        vertexCount = verticies;
        graph = new double[vertexCount][vertexCount];
        for(int i = 0; i < vertexCount; i++)
           {
               for(int j = 0; j < vertexCount; j++)
                   graph[i][j] = INF;
               graph[i][i] = 0;
           }
    }
    
    public void addEdge(int to, int from, int weight) {
        graph[to][from]= weight; //Directed Graph
    }
    public void evaluatePaths() 
    { 
        int i, j, k; 
        for (k = 0; k < vertexCount; k++) 
        { 
            for (i = 0; i < vertexCount; i++) 
            { 
                for (j = 0; j < vertexCount; j++) 
                { 
                    if (graph[i][k] + graph[k][j] < graph[i][j]) 
                        graph[i][j] = graph[i][k] + graph[k][j]; 
                } 
            } 
        } 
    } 
    public void printGraph()
    {
        System.out.println("\n\n\n\nAdjacency matrix - INF represents no edge: ");
        for (int i = 0; i < vertexCount; i++) 
        {
            for (int j = 0; j <vertexCount ; j++) 
             {
                if(graph[i][j] >= 0 && graph[i][j] != INF)
                {
                    System.out.print(graph[i][j] + "  ");
                }
                else if(graph[i][j] == INF)
                    System.out.print("INF   ");
            }
            System.out.println();
        }
    }
    public void printConnections()
    {
        for (int i = 0; i < vertexCount; i++) 
        {
            String name = reversedata.get(i);
            System.out.print("Station " + name + " (index "+i+ ") is connected to: ");
            for (int j = 0; j <vertexCount ; j++) 
            {

                if(graph[i][j] != INF && graph[i][j] != 0)
                {
                    System.out.print(reversedata.get(j) + ", ");
                }
            }
            System.out.println();
        }
    }
    public double getShortest(String source, String destination)
    {
        source = source.toUpperCase();
        destination = destination.toUpperCase();
        if(!data.containsKey(source) || !data.containsKey(destination))
            return -2;
        int sourceValue = data.get(source);
        int destinationValue = data.get(destination);
        if(graph[sourceValue][destinationValue] == INF)
            return -1;
        return graph[sourceValue][destinationValue];
    }
    
    public void printList()
    {
        for (String key: data.keySet())
        {
            System.out.println(key );
        } 
    }

    public void initializeData()
    {
        data.put("HARTFORD", 0);
        data.put("NEW YORK CITY", 1);
        data.put("BOSTON", 2);
        data.put("TRENTON",3);
        data.put("WASHINGTON DC", 4);
        data.put("PROVIDENCE",5);
        data.put("PORTLAND", 6);
        data.put("DURHAM",7);
        data.put("RANDOLPH",8);
        data.put("PHILADELPHIA", 9);
        data.put("BALTIMORE", 10);
        addEdge(0,8,285);
        addEdge(0,1,150);
        addEdge(0,5,105);
        addEdge(0,2,120);
        addEdge(0,3,225);
        addEdge(0,4,400);
        addEdge(0,9,285);
        addEdge(0,10,365);
        addEdge(1,0,150);
        addEdge(1,3,60);
        addEdge(1,9,87);
        addEdge(1,10,180);
        addEdge(1,4,215);
        addEdge(1,5,186);
        addEdge(1,8,443);
        addEdge(2,7,85);
        addEdge(2,6,150);
        addEdge(2,8,225);
        addEdge(2,0,120);
        addEdge(2,9,360);
        addEdge(2,10,684);
        addEdge(2,3,340);
        addEdge(2,5,40);
        addEdge(3,0,225);
        addEdge(3,9,30);
        addEdge(3,10,110);
        addEdge(3,5,280);
        addEdge(3,4,150);
        addEdge(3,2,340);
        addEdge(3,1,60);
        addEdge(4,0,400);
        addEdge(4,9,120);
        addEdge(4,10,30);
        addEdge(4,5,450);
        addEdge(4,3,150);
        addEdge(4,1,215);
        addEdge(4,8,669);
        addEdge(5,0,105);
        addEdge(5,3,280);
        addEdge(5,9,290);
        addEdge(5,10,350);
        addEdge(5,2,40);
        addEdge(5,1,186);
        addEdge(6,7,65);
        addEdge(6,2,85);
        addEdge(7,6,65);
        addEdge(7,0,265);
        addEdge(8,2,225);
        addEdge(8,0,330);
        addEdge(8,10,626);
        addEdge(8,4,669);
        addEdge(8,3,517);
        addEdge(8,9,548);
        addEdge(8,1,444);
        addEdge(9,3,30);
        addEdge(9,1,87);
        addEdge(9,2,360);
        addEdge(9,5,290);
        addEdge(9,10,90);
        addEdge(9,0,285);
        addEdge(9,4,120);
        addEdge(10,3,110);
        addEdge(10,1,180);
        addEdge(10,8,626);
        addEdge(10,2,684);
        addEdge(10,9,90);
        addEdge(10,5,408);
        addEdge(10,0,365);
        for (String key: data.keySet())
        {
            reversedata.put(data.get(key), key); //Used for connections list
        } 
    } 
}