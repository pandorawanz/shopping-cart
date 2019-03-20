package com.wanz.Session.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SessionManager {
    private HashMap<Integer, Session> sessions = new HashMap<>();

    public HashMap<Integer, Session> getSessions() {
        return sessions;
    }

    public void setSessions(HashMap<Integer, Session> sessions) {
        this.sessions = sessions;
    }
}
