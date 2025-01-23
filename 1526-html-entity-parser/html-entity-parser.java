class Solution {
    
    public String entityParser(String text) {
        StringBuilder res = new StringBuilder();
        HashMap<String, Character> map = new HashMap<>();

        map.put("&quot;", '"');
        map.put("&apos;", '\'');
        map.put("&amp;", '&');
        map.put("&gt;", '>');
        map.put("&lt;", '<');
        map.put("&frasl;", '/');

        for(int i = 0; i < text.length(); i++){
            char c = text.charAt(i);

            if(c == '&'){
                int p1 = checkEntity(text, i);
                if(p1 != -1){
                    String entity = text.substring(i, p1+1);
                    if(map.containsKey(entity)){
                        Character symbol = map.get(entity);
                        res.append(symbol);
                        
                        int lengthOfEntity = entity.length() - 1;
                        i += lengthOfEntity;
                    }else res.append(c);
                } else res.append(c);
            }
            else res.append(c);
        }

        return res.toString();
    }

    private int checkEntity(String text, int index){
        int p1 = index;
        boolean isEntity = true;
        while(text.charAt(p1) != ';' && p1 != text.length() - 1){
            p1++;
            if(p1 - index > 6){
                isEntity = false;
                break;
            }
        }

        return  isEntity ? p1 : -1;
    }
}