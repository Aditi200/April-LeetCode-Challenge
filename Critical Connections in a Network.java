class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph=new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(i,new ArrayList<>());
         BuildGraph(connections);
        
        parent=new int[n]; // will hold parent of ith node
        low=new int[n];  // lowest time node I can reach without going through parent node
        disc=new int[n]; // will hold discovery time of  node
        
        Arrays.fill(parent,-1);
        Arrays.fill(low,-1);
        Arrays.fill(disc,-1);
        
        ans=new ArrayList<>();
       
        visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]) Dfs(i,0);
        }
        return ans;
    }
     
    private List<List<Integer>> ans;
    private boolean[] visited;
    
    private int[] parent;
    private int[] low;
    private int[] disc;
    
    private void addEdge(int u,int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
   
    private ArrayList<ArrayList<Integer>> graph;
    
    private void BuildGraph(List<List<Integer>> Connections){
        for(List<Integer> pair:Connections){
            int u=pair.get(0);
            int v=pair.get(1);
            addEdge(u,v);
        }
    }
    
    private void Dfs(int u,int time){
        visited[u]=true;
        disc[u]=low[u]=time;
        time+=1;
        
        for(int nbr:graph.get(u)){
            if(!visited[nbr]){
                parent[nbr]=u;
                Dfs(nbr,time);
                low[u]=Math.min(low[u],low[nbr]);
                
                if(low[nbr]>disc[u]){  // no backedge
                    List<Integer> conflict=new ArrayList<>();
                    conflict.add(u);
                    conflict.add(nbr);
                    ans.add(conflict);
                }
            }
            else if(nbr!=parent[u]){  // avoiding to go on my parent
                low[u]=Math.min(low[u],disc[nbr]);
            }
        }
    } 
}