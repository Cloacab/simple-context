package com.yuri.service.announcer;

public class AlternativeAnnoncer implements Announcer {
    public AlternativeAnnoncer() {
        System.out.println("Announcer was created");
    }

    @Override
    public void announce(String message) {
        System.out.println("---This is alternative announcer used if main one is down---\n"
            + message);
    }
}
