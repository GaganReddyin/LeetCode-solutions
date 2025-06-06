class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
  
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int[] courses : prerequisites){
            adj[courses[0]].add(courses[1]);
        }
        
     
        HashSet<Integer>[] dependencySet = new HashSet[numCourses];
        for(int course = 0; course < numCourses; course++){
            dependencySet[course] = new HashSet<Integer>();
        }
        
        
        List<Boolean> result  = new ArrayList();

        for(int[] query : queries){
       
            int currentCourse = query[0];
            
            int requiredCourse = query[1];
            
            if(adj[currentCourse].size() > 0 && dependencySet[currentCourse].size() == 0){
                dfs(currentCourse, adj, dependencySet);
            }
            
            boolean isPrerequisite = dependencySet[currentCourse].contains(requiredCourse);
            
            result.add(isPrerequisite);
        }

        return result;
    }
    
    private List<Integer> dfs(int currentCourse, ArrayList<Integer>[] adj, HashSet<Integer>[] dependencySet){
     
        if(adj[currentCourse].size() == 0){
            return new ArrayList<Integer>();
        }
        
        if(dependencySet[currentCourse].size() > 0) {
            return new ArrayList<Integer>(dependencySet[currentCourse]);
        }
        
    
        for(int directPrerequisite : adj[currentCourse]){
            dependencySet[currentCourse].add(directPrerequisite);
            
            for(int inDirectPrerequisite : dfs(directPrerequisite, adj, dependencySet)){
                dependencySet[currentCourse].add(inDirectPrerequisite);
            }
        }
        
        return new ArrayList<Integer>(dependencySet[currentCourse]);
    }
}