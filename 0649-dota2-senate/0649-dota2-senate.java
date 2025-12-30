class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> r = new ArrayDeque<>();
        Queue<Integer> d = new ArrayDeque<>();

        //put the indices of each party into separate queues
        for(int i = 0; i < n; i++){
            if(senate.charAt(i) == 'R') r.offer(i);
            else d.offer(i);
        }

        //Simulate rounds: 
        //The senator with the smaller index acts first and bans the other 
        //the winner (smaller index) re-queues with index + n to act in a future round
        while(!r.isEmpty() && !d.isEmpty()){
            int ri = r.poll();
            int di = d.poll();

            if(ri < di){
                //Radiant acts first, bans this dire senator
                r.offer(ri + n);
            }else{
                //Dire acts first, bans this Radiant senator
                d.offer(di + n);
            }
        }

        return r.isEmpty() ? "Dire" : "Radiant";
    }
}