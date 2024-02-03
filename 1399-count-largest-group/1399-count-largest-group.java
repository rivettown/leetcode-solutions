// class Solution{
//         public int countLargestGroup(int n) {
//         int maxFreq = 0, dp[] = new int[n + 1], res = 1;
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int i = 1; i <= n; i++) {
//             dp[i] = i % 10 + dp[i / 10];
//             map.put(dp[i], map.getOrDefault(dp[i], 0) + 1);
//         }
//         for (int key : map.keySet()) {
//             if (map.get(key) > maxFreq) {
//                 maxFreq = map.get(key);
//                 res = 1;
//             } else if (map.get(key) == maxFreq) res++;
//         }
//         return res;
//     }
// }

class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int res = 0;
        for(int i =1;i<=n;i++){
            int x = sum(i);
            map.put(x, map.getOrDefault(x, 0) + 1);
            max = Math.max(max, map.get(x));
        }
        for(int key: map.keySet()){
            if(map.get(key) == max)
                res++;
        }
        return res;
        
    }
    public int sum(int x){
        int sum = 0;
        while(x > 0){
            sum += x % 10;
            x = x /10;
        }
        return sum;
    }
}