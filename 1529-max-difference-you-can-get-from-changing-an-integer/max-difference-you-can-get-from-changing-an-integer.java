class Solution {
    public int maxDiff(int num) {
        List<Integer> minnum = new ArrayList<>(), maxnum = new ArrayList<>();

        while(num > 0){
            minnum.add(num%10);
            maxnum.add(num%10);
            num /= 10;
        }
        int change = 9;

        for(int i = maxnum.size()-1;i >= 0;i--){
            if(maxnum.get(i) == 9){
                continue;
            }
            change = maxnum.get(i);
            break;
        }
        for(int i = 0;i < maxnum.size();i++){
            if(change == maxnum.get(i)){
                maxnum.set(i, 9);
            }
        }

        if(minnum.get(minnum.size()-1) == 1){
            change = 0;
            for(int i = minnum.size()-1;i >= 0;i--){
                if(minnum.get(i) <= 1){
                    continue;
                }
                change = minnum.get(i);
                break;
            }
            for(int i = 0;i < minnum.size();i++){
                if(change == minnum.get(i)){
                    minnum.set(i, 0);
                }
            }
        }
        else{
            change = minnum.get(minnum.size()-1);
            for(int i = 0;i < minnum.size();i++){
                if(change == minnum.get(i)){
                    minnum.set(i, 1);
                }
            }
        }

        int max = 0, min = 0;

        for(int i = maxnum.size()-1;i >= 0;i--){
            max *= 10;
            max += maxnum.get(i);
        }
        for(int i = minnum.size()-1;i >= 0;i--){
            min *= 10;
            min += minnum.get(i);
        }

        return max-min;

    }
}