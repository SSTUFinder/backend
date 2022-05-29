package com.sstufinder.main.repository;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public interface StudentInfo {
    long getId();
    String getLogin();
    String getFirstname();
    String getLastname();
    String getEmail();
    String getRecordBookNumber();
    String getReason();
    boolean getUpgradeTier();
}
