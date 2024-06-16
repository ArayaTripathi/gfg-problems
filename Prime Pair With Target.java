class Solution {
    public static ArrayList<Integer> getPrimes(int n) {
        // code here
        boolean[] prime = new boolean[n + 1];
        for(int i = 2; i<=n; ++i){
            prime[i] = true;
        }
        for(int i = 2; i * i <= n; ++i){
            if(prime[i]){
                for(int j = i * i; j<= n; j += i){
                    prime[j] = false;
                }
            }
        }
        boolean found = false;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 2; i <= n; ++i){
            if(prime[i] && prime[n - i]){
                res.add(i);
                res.add(n - i);
                found = true;
                break;
            }
        }
        if(!found){
            res.add(-1);
            res.add(-1);
        }
        return res;
    }
}
