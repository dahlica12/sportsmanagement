package com.james.sportsmanagementws.coachmanagementsubdomain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Integer> {

    Coach findByCoachIdentifier_CoachId(String coachId);
}
