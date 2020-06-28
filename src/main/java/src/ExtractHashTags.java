package src;

import java.util.List;

/**
 * this interface can be to do manipulations on tweets for extracting any necessary details about tweets
 */
public interface ExtractHashTags {
    /**
     *
     * @param n Number of hashTags to be extracted
     * @param tweets list of all the tweets for extrapolation of data
     */
    void getTopNHashTags(int n, List<String> tweets);
}
