package src.impl;

import src.ExtractHashTags;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static src.utils.TwitterHashTagUtils.sortByValue;

/**
 * ExtractHashTagsImpl contains all the logic to extrapolate tweets read and fetch trending hashTags.
 */
public class ExtractHashTagsImpl implements ExtractHashTags {

    /**
     * HashMap is the primary Data structure being used to store the hashtags and their respective counts.
     */
    private HashMap<String, Integer> map = new HashMap<>();

    public ExtractHashTagsImpl() {}

    /**
     * Method Displays Top n tweets
     * @param n Number of hashTags to be extracted
     * @param tweets list of all the tweets for extrapolation of data
     */
    public void getTopNHashTags(int n, List<String> tweets) {
        getAllHashtags(tweets);
        if(map.isEmpty())
            System.out.println("No hashTag is trending right now!");
        map = sortByValue(map);
        int i = 0;
        System.out.println(String.format("TOP %s hashTags are: ", n));
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            i++;
            if(i == n)
                break;
        }
    }

    /**
     * Method to fetch hashTags present in all the tweets fed to this application.
     * @param tweets
     */
    public void getAllHashtags(List<String> tweets) {
        if (tweets.isEmpty())
            System.out.println("No hashTag is trending right now!");

        for(String tweet: tweets) {
            List<String> hashTags = getHashtagsInSingleTweet(tweet);
            hashTags.forEach(x -> {
                if(map.containsKey(x)) {
                    map.replace(x, map.get(x) + 1);
                }
                else map.put(x, 1);
            });
        }
    }

    /**
     * Method to fetch hashTags present in a single tweet.
     * @param tweet
     * @return
     */
    private List<String> getHashtagsInSingleTweet(String tweet) {
        List<String> hashtagsInSingleTweet = new ArrayList<>();
        if(tweet.isEmpty()) return hashtagsInSingleTweet;

        //all the owrkds which start with a hastag special charater are stored in a hashmap which
        // would later be used to find out trending hashtags from a series of tweets.
        String regex = "#\\w+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(tweet);
        while (m.find()) {
            hashtagsInSingleTweet.add(m.group());
        }
        return hashtagsInSingleTweet;
    }
}
