INSERT INTO gender (gender_name)
VALUES('men');
INSERT INTO gender (gender_name)
VALUES('women');

INSERT INTO user_role (role_name)
VALUES('admin');
INSERT INTO user_role (role_name)
VALUES('user');

INSERT INTO system_user (uname, upass, role_id)
VALUES('mbhdra','$2a$12$04Imudz0AEA8fOvWTttbSuj9EDo3PibOYzGqzjo7hojH/bvvthXi2', 1);

INSERT INTO division (division_name)
VALUES('U18');
INSERT INTO division (division_name)
VALUES('Super League');
INSERT INTO division (division_name)
VALUES('U17');
INSERT INTO division (division_name)
VALUES('First Division');

INSERT INTO season (season_name)
VALUES('1994-1995 Season');
INSERT INTO season (season_name)
VALUES('2003-2004 Season');
INSERT INTO season (season_name)
VALUES('2021-2022 Season');
INSERT INTO season (season_name)
VALUES('1990-1991 Season');

INSERT INTO club (club_name)
VALUES('Fenerbahçe');
INSERT INTO club (club_name)
VALUES('Anadolu Efes');
INSERT INTO club (club_name)
VALUES('Türk Telekom');
INSERT INTO club (club_name)
VALUES('Galatasaray');

INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('1994-1995 Season U18 Men League', 1, 1, 1);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2003-2004 Season First Division Women League', 2, 4, 2);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2021-2022 Season U17 Women League', 3, 3, 2);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('1990-1991 Season Super League Men League', 4, 2, 1);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('1990-1991 Season Super League Women League', 4, 2, 2);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2003-2004 Season First Division Men League', 2, 4, 1);

INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Fenerbahçe U18 Men Team', 1, 1, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Anadolu Efes U18 Men Team', 2, 1, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Türk Telekom U18 Men Team', 3, 1, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Galatasaray U18 Men Team', 4, 1, 1);

INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Fenerbahçe Super League Women Team', 1, 2, 2);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Anadolu Efes Super League Women Team', 2, 2, 2);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Türk Telekom Super League Women Team', 3, 2, 2);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Galatasaray Super League Women Team', 4, 2, 2);

INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Galatasaray U17 Men Team', 4, 3, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Galatasaray U17 Women Team', 4, 3, 2);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Fenerbahçe U17 Women Team', 1, 3, 2);

INSERT INTO team_league (team_id, league_id)
VALUES(1, 1);
INSERT INTO team_league (team_id, league_id)
VALUES(10, 3);