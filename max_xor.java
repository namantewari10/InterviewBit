class abc {
    class Node{
        Node[] child;
        Node(){
            child=new Node[2];
        }
    }

    public static void main(String[] args) {
        int[] nums={25, 10, 2, 8, 5, 3};
        System.out.println(new nonCP().findMaximumXOR(nums));
    }
    public int findMaximumXOR(int[] nums) {
        Node root=new Node();
        for(int i=0;i<nums.length;i++)
            insert(root, nums[i]);
        int max_xor=0;
        for(int i=0;i<nums.length;i++)
        {
            int c_xor=0;
            int num=nums[i];
            Node curr=root;
            for(int j=1<<30;j>0;j>>=1)
            {
                int bit=(num&j)>0?1:0;
                if(bit==1)
                {
                    if(curr.child[0]!=null)
                    {
                        c_xor+=j;
                        curr=curr.child[0];
                    }
                    else
                    {
                        curr=curr.child[1];

                    }

                }
                else
                {
                    if(curr.child[1]!=null)
                    {
                        c_xor+=j;
                        curr=curr.child[1];

                    }
                    else
                    {
                        curr=curr.child[0];
                    }

                }

            }
            if(c_xor>max_xor)
                max_xor=c_xor;
        }

        return max_xor;

    }
    public void insert(Node root, int x){
        for(int i=1<<30;i>0;i=i>>1)
        {
            int index=(x&i)>0?1:0;
            if(root.child[index]==null)
                root.child[index]=new Node();
            root=root.child[index];
        }
    }
}