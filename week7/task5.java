class MyHashSet {
    int index=0;
    int[] MyHash=new int[1000001];
    public MyHashSet() {
    }
    
    public void add(int key) {
        if(!contains(key))
        MyHash[index++]=key;

    }
    
    public void remove(int key) {
        int ind=index(key);
        if(ind==-1)return;
        for(int i=ind;i<index;i++)MyHash[i]=MyHash[i+1];
        index--;
    }
    public int index(int key) {
        for(int i=0;i<index;i++){
            if(MyHash[i]==key)return i;
        }
        return -1;
    }
    public boolean contains(int key) {
        for(int i=0;i<index;i++){
            if(MyHash[i]==key)return true;
        }
        return false;
    }
}
