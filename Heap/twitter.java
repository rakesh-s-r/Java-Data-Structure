package Heap;

import java.util.*;

class Twitter {
    int count = 0;
    HashMap<Integer, List<int[]>> tweets = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> followsList = new HashMap<>();

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }
        count++;
        tweets.get(userId).add(new int[] { count, tweetId });

    }

    public List<Integer> getNewsFeed(int userId) {
        if (!followsList.containsKey(userId)) {
            followsList.put(userId, new HashSet<>());
        }
        followsList.get(userId).add(userId);

        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        for (int following : followsList.get(userId)) {
            if (tweets.containsKey(following)) {
                int index = tweets.get(following).size() - 1;
                int[] val = tweets.get(following).get(index);
                q.offer(new int[] { val[0], val[1], following, index - 1 });
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while (!q.isEmpty() && res.size() < 10) {
            int[] popped = q.poll();
            res.add(popped[1]);
            int index = popped[3];

            if (index >= 0) {
                int[] val = tweets.get(popped[2]).get(index);
                q.offer(new int[] { val[0], val[1], popped[2], index - 1 });
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!followsList.containsKey(followerId)) {
            followsList.put(followerId, new HashSet<>());
        }
        followsList.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followsList.containsKey(followerId)) {
            followsList.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter.getNewsFeed(1); // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2); // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        System.out.println(twitter.getNewsFeed(1)); // User 1's news feed should return a list with 2 tweet ids -> [6,
                                                    // 5]. Tweet id
        // 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2); // User 1 unfollows user 2.
        System.out.println(twitter.getNewsFeed(1)); // User 1's news feed should return a list with 1 tweet id -> [5],
                                                    // since user 1
        // is no longer following user 2.

    }
}
