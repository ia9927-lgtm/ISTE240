INSERT INTO teams (name, nationality, principal, championships) VALUES
                                                                    ('Red Bull Racing', 'Austrian', 'Christian Horner', 6),
                                                                    ('Ferrari', 'Italian', 'Frederic Vasseur', 16),
                                                                    ('Mercedes', 'German', 'Toto Wolff', 8),
                                                                    ('McLaren', 'British', 'Andrea Stella', 8),
                                                                    ('Aston Martin', 'British', 'Mike Krack', 0);

INSERT INTO drivers (first_name, last_name, nationality, driver_number, team_id) VALUES
                                                                                     ('Max', 'Verstappen', 'Dutch', 1, 1),
                                                                                     ('Charles', 'Leclerc', 'Monegasque', 16, 2),
                                                                                     ('Lewis', 'Hamilton', 'British', 44, 3),
                                                                                     ('Lando', 'Norris', 'British', 4, 4),
                                                                                     ('Fernando', 'Alonso', 'Spanish', 14, 5);

INSERT INTO races (grand_prix_name, circuit, country, race_date, season) VALUES
                                                                             ('Bahrain Grand Prix', 'Bahrain International Circuit', 'Bahrain', '2025-03-02', 2025),
                                                                             ('Saudi Arabian Grand Prix', 'Jeddah Corniche Circuit', 'Saudi Arabia', '2025-03-09', 2025),
                                                                             ('Australian Grand Prix', 'Albert Park Circuit', 'Australia', '2025-03-23', 2025);

INSERT INTO results (raceid, driverid, finishing_position, points_earned, fastest_lap_time) VALUES
                                                                                                (1, 1, 1, 25, '1:34.567'),
                                                                                                (1, 2, 2, 18, '1:34.891'),
                                                                                                (2, 3, 1, 25, '1:31.234');