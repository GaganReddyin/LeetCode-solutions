class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new LinkedList<>();
        int first = 1,second = 1;

        // generating Fibonacci sequence upto k
        list.add(first);
        list.add(second);
        while(first+second<=k){
            int next = first + second;
            list.add(next);
            first = second;
            second = next;
        }

        //using greedy approach to minimize number of Fibonacci numbers
        int count = 0;
        int index = list.size()-1;
        while(index>=0){
            //if current list element is <=k, subtract it from k and count it
            if(list.get(index)<=k){
                count++;
                k-=list.get(index);
            }
            index--;
        }
        return count;
    }
}