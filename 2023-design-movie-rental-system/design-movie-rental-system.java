class MovieRentingSystem {
    class Entry{
        int s,m,p;
        Entry(int s,int m,int p){
            this.s=s;
            this.m=m;
            this.p=p;
        }
        @Override
        public boolean equals(Object o) {
            if(this==o) return true;
            if(o==null||getClass()!=o.getClass()) return false;
            Entry e=(Entry)o;
            return s==e.s&&m==e.m;
        }
        @Override
        public int hashCode() {
            return Objects.hash(s,m);
        }
    }
    private TreeMap<Integer,TreeSet<Entry>> map;
    private HashMap<Entry,Integer> map2;
    private TreeSet<Entry> set;
    public MovieRentingSystem(int n, int[][] entries) {
        map=new TreeMap<>();
        map2=new HashMap<>();
        set=new TreeSet<>((a,b)->{
            if(a.p!=b.p) return a.p-b.p;
            else{
                if(a.s!=b.s) return a.s-b.s;
                else return a.m-b.m;
            }
        });
        for(int[] entry:entries){
            int s=entry[0],m=entry[1],p=entry[2];
            Entry e=new Entry(s,m,p);
            if(!map.containsKey(m)) map.put(m,new TreeSet<>((a,b)->{
                if(a.p!=b.p) return a.p-b.p;
                else return a.s-b.s;
            }));
            map2.put(e,p);
            map.get(m).add(e);
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> ans=new ArrayList<>();
        if(!map.containsKey(movie)) return ans;
        for(Entry e:map.get(movie)){
            ans.add(e.s);
            if(ans.size()==5) return ans;
        }
        return ans;
    }
    
    public void rent(int shop, int movie) {
        int price=map2.get(new Entry(shop,movie,0));
        Entry e=new Entry(shop,movie,price);
        map.get(movie).remove(e);
        set.add(e);
    }
    
    public void drop(int shop, int movie) {
        int price=map2.get(new Entry(shop,movie,0));
        Entry e=new Entry(shop,movie,price);
        map.get(movie).add(e);
        set.remove(e);
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> ans=new ArrayList<>();
        for(Entry e:set){
            List<Integer> a=new ArrayList<>();
            a.add(e.s);
            a.add(e.m);
            ans.add(a);
            if(ans.size()==5) return ans;
        }
        return ans;
    }
}