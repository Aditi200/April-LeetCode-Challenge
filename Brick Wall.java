public int leastBricks(List<List<Integer>> wall) {
       HashMap<Integer,Integer> map=new HashMap<>(); // key:xcoordinate value:count
        int maxbrickSkip=0;
        
        for(int r=0;r<wall.size();r++){
            int xcoordinate=0;
            for(int c=0;c<wall.get(r).size()-1;c++){  //wall.get(r).size()-1 because we dont want to include last  brick .  
                xcoordinate+=wall.get(r).get(c);      
              map.put(xcoordinate,map.getOrDefault(xcoordinate,0)+1);
                maxbrickSkip=Math.max(map.get(xcoordinate),maxbrickSkip);
            }
        }
        
        int ans=wall.size()-maxbrickSkip;
        return ans;   
    }