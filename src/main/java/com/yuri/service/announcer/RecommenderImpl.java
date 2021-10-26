package com.yuri.service.announcer;

@Singleton
@Lazy
@Deprecated
public class RecommenderImpl implements Recommender {
    @InjectProperty(value = "whiskey")
    private String alcohol;

    public RecommenderImpl() {
        System.out.println("Recommender was created.");
    }

    @Override
    public void recommend() {
        System.out.println("ADVERTISEMENT: drink " + alcohol);
    }
}
