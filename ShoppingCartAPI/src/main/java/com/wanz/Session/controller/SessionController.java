package com.wanz.Session.controller;

import com.wanz.Session.model.Session;
import com.wanz.Session.model.SessionManager;
import com.wanz.Session.view.LoginRequest;
import com.wanz.user.model.User;
import com.wanz.user.model.UserDao;
import com.wanz.user.view.UserView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
public class SessionController {
    private static final String SESSION_TOKEN = "session_token";
    private static final String USER_ID = "user_id";
    private SessionManager sessionManager;
    private UserDao userDao;

    public SessionController(SessionManager sessionManager, UserDao userDao) {
        this.sessionManager = sessionManager;
        this.userDao = userDao;
    }

    /*
     * Login
     */
    @PostMapping("/session")
    public ResponseEntity login(HttpServletResponse response, @RequestBody LoginRequest login) {
        User user = userDao.getByName(login.getName());

        if (user == null || !user.getPassword().equals(login.getPassword())) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        // 添加Session
        String token = UUID.randomUUID().toString();
        sessionManager.getSessions().put(user.getId(), new Session(user.getId(), token));

        // 设置cookie
        response.addCookie(new Cookie(USER_ID, Integer.toString(user.getId())));
        response.addCookie(new Cookie(SESSION_TOKEN, token));

        return new ResponseEntity(HttpStatus.CREATED);
    }

    /*
     * current user
     */
    @GetMapping("/current")
    public ResponseEntity<UserView> current(@CookieValue(name = USER_ID, defaultValue = "0") int userId, @CookieValue(name = SESSION_TOKEN, defaultValue = "") String token) {
        Session session = sessionManager.getSessions().get(userId);

        if (session == null || !session.getToken().equals(token)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        User user = userDao.getById(session.getUserId());
        return new ResponseEntity<>(new UserView(user.getId(), user.getName()), HttpStatus.OK);
    }

    /*
     * Logout
     */
    @DeleteMapping("/session")
    public ResponseEntity logout(@CookieValue(name = USER_ID, defaultValue = "0") int userId, @CookieValue(name = SESSION_TOKEN, defaultValue = "") String token) {
        Session session = sessionManager.getSessions().get(userId);


        if (session == null || !session.getToken().equals(token)) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }

        // 删除Session
        sessionManager.getSessions().remove(userId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
