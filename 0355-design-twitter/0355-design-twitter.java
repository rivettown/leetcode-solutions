import java.util.*;

class Twitter {
    Map<Integer, int[]> tweets = new HashMap<>();
    Map<Integer, List<Integer>> followers = new LinkedHashMap<>();
    int count = 1;
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.put(count++, new int[]{userId, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> dates = new ArrayList<>();
        for(Map.Entry<Integer, int[]> entry: tweets.entrySet())
            dates.add(entry.getKey());
        dates = dates.reversed();
        List<Integer> res = new ArrayList<>();
        int countOfTweets = 1;
        
        for(Integer d : dates){
            if(countOfTweets == 11)
                break;
            int[] tweet = tweets.get(d);
            if(tweet[0] == userId || 
                (followers.get(userId) != null && followers.get(userId).contains(tweet[0]))
               ){
                countOfTweets++;
                res.add(tweets.get(d)[1]);
            }
                 
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followers.computeIfAbsent(followerId, k -> new ArrayList<>());
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.get(followerId) != null && followers.get(followerId).contains(followeeId)){
            int idx = followers.get(followerId).indexOf(followeeId);
            followers.get(followerId).remove(idx);
        }

    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */