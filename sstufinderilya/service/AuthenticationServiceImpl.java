package com.diplom.sstufinder.service;

import com.diplom.sstufinder.SstuFinderApplication;
import com.diplom.sstufinder.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final Logger logger = LoggerFactory.getLogger(SstuFinderApplication.class);

    @Autowired
    UserRepository userRepository;

    private Map<String, SessionData> authenticatedUsers = new HashMap<>();

    @Override
    public Long getUserIdByToken(String token) {
        SessionData sessionData = authenticatedUsers.get(token);

        logger.info("YA TUT");
//        logger.info(sessionData.toString());

//        logger.error(sessionData.userId.toString());
//        if (sessionData == null || sessionData.expiresAt.before(new Date())) {
//            return null;
//        }

//        logger.info("%d",sessionData.userId);
        if (authenticatedUsers.isEmpty()){

            logger.info("MAP IS EMPTY");
        }
        logger.info(sessionData.toString());
        return sessionData.userId;
    }

    @Override
    public String startSession(Long userId) {
        String token = RandomStringUtils.randomAlphabetic(20);

        Date expiresAt = DateUtils.addHours(new Date(), 2);
        SessionData sessionData = new SessionData(userId, expiresAt);

        authenticatedUsers.put(token, sessionData);

        logger.info(authenticatedUsers.get(token).toString());

        return token;
    }

    @Override
    public void stopSession(String token) {
        authenticatedUsers.remove(token);
    }


    static class SessionData {
        private Long userId;
        private Date expiresAt;

        public SessionData(Long userId, Date expiresAt) {
            this.userId = userId;
            this.expiresAt = expiresAt;
        }

        @Override
        public String toString() {
            return "SessionData{" +
                    "userId=" + userId +
                    ", expiresAt=" + expiresAt +
                    '}';
        }
    }
}
