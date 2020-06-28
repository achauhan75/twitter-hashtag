package src;

import src.impl.ExtractHashTagsImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the main entry point which reads tweets present in tweets.txt file in resources folder.
 * Main method take an input integer TopN which is used to calculate top N hashTags present across all the tweets mentioned in tweets.txt file.
 */
public class TwitterHashtagApplication {

    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            //read topN variable from console
            System.out.println("Please enter a valid number to fetch trending hashtags.");
            int topN = Integer.parseInt(reader.readLine());
            if(topN <= 0) {
                System.out.println("Please enter a valid positive number to fetch trending hashtags");
                return;
            }
            reader = new BufferedReader(new FileReader("src/main/resources/tweets.txt"));
            String line = reader.readLine();
            List<String> tweets = new ArrayList<>();
            while (line != null) {
                tweets.add(line);
                line = reader.readLine();
            }

            // ExtractHashTags is an interface and ExtractHashTagsImpl is a class which implements all the business logic to find out all the top N tweets.
            ExtractHashTags object = new ExtractHashTagsImpl();
            object.getTopNHashTags(topN, tweets);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
