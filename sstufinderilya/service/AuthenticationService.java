package com.diplom.sstufinder.service;

public interface AuthenticationService {

    Long getUserIdByToken(String token);
    String startSession(Long userId);
    void stopSession(String token);

}
