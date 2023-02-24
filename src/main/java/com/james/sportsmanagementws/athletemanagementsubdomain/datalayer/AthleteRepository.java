package com.james.sportsmanagementws.athletemanagementsubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Integer> {
}
