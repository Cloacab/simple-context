package com.yuri.service.announcer;

import com.yuri.service.InjectByType;

@Lazy
public class ConsoleAnnouncer implements Announcer {
    @InjectByType
    private Recommender recommender;

    public ConsoleAnnouncer() {
        System.out.println("Announcer was created.");
    }

    @Override
    public void announce(String message) {
        System.out.println(message);
        recommender.recommend();
    }
}
