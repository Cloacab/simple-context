package com.yuri.service;

import com.yuri.service.announcer.Announcer;
import com.yuri.service.policeman.Policeman;
import com.yuri.model.Room;

import java.io.Serializable;

/**
 * This class used only for disinfecting the room (SRP)
 *
 * @author yuri
 */
@Deprecated
public class CoronaDisinfector implements Serializable {

    @InjectByType
    private transient Announcer announcer;
    @InjectByType
    private transient Policeman policeman;

    public void start(Room room) {
        announcer.announce("Starting to disinfect this room (get the fuck out of here): " + room);
        policeman.makePeopleLeaveRoom();
        disinfect(room);
        announcer.announce("Try it bitch. Now it's clear... (or not idk)");
    }

    private void disinfect(Room room) {
        System.out.println("Disinfecting room from COVID.");
    }
}
