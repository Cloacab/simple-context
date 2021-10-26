package com.yuri.service.policeman;

import com.yuri.service.InjectByType;
import com.yuri.service.announcer.Recommender;
import com.yuri.service.announcer.Singleton;

@Singleton
public class PolicemanImpl implements Policeman {
    @InjectByType
    private Recommender recommender;

    public PolicemanImpl() {
        System.out.println("Policeman was created.");
    }

    @PostConstruct
    public void init() {
        System.out.println(recommender.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Clear the room please. (policeman)");
    }
}
