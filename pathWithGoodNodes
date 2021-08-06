public class Solution {
    int count=0;
    public int solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B, int C) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList(A.size());
        int[] arr=new int[A.size()];
        for(int i=0;i<A.size();i++)
            arr[i]=A.get(i);
        for(int i=0;i<A.size();i++)
            adj.add(new ArrayList<Integer>());
        for(int i=0;i<B.size();i++)
        {
            addInGraph(adj, B.get(i).get(0)-1, B.get(i).get(1)-1);
        }
        //sanity check
        // for(int i=0;i<adj.size();i++)
        // {
        //     for(int j=0;j<adj.get(i).size();j++)
        //         System.out.print(adj.get(i).get(j)+" ");
        //     System.out.println();
        // }
        boolean[] visited=new boolean[A.size()];
        visited[0]=true;
        for(int i=0;i<adj.get(0).size();i++)
            DFSUtil(adj, arr, C-arr[0], adj.get(0).get(i), visited);
        return count;
    }
    public void addInGraph(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public void DFSUtil(ArrayList<ArrayList<Integer>> adj, int[] arr, int C, int num, boolean[] visited)
    {
        visited[num]=true;
        // if(isLeaf(num) && C==0 && A.get(num)==0)
        //     count++;
        if(C<0 || (C==0&&arr[num]==1)) return;
        boolean isLeaf=true;
        for(int u:adj.get(num))
        {
            if(!visited[u])
            {
                isLeaf=false;
                break;
            }
        }
          
        if(isLeaf)
        {
            if(C>=1 || (C==0&& arr[num]==0))
            {
                count++;
                return;
            }
        }
        if(arr[num]==1)
            C--; 
        for(int u:adj.get(num))
        {
            if(!visited[u])
                DFSUtil(adj, arr, C, u, visited);
        }
        return;
    }
}
