INSERT INTO user_role (role_name)
VALUES('admin');
INSERT INTO user_role (role_name)
VALUES('user');

INSERT INTO system_user (uname, upass, role_id)
VALUES('mbhdra','$2a$12$04Imudz0AEA8fOvWTttbSuj9EDo3PibOYzGqzjo7hojH/bvvthXi2', 1);

INSERT INTO gender (gender_name)
VALUES('men');
INSERT INTO gender (gender_name)
VALUES('women');

INSERT INTO division (division_name)
VALUES('U16');
INSERT INTO division (division_name)
VALUES('U18');
INSERT INTO division (division_name)
VALUES('Regional');
INSERT INTO division (division_name)
VALUES('Super');

INSERT INTO season (season_name)
VALUES('1994-1995 Season');
INSERT INTO season (season_name)
VALUES('2011-2012 Season');
INSERT INTO season (season_name)
VALUES('2021-2022 Season');
INSERT INTO season (season_name)
VALUES('2022-2023 Season');

INSERT INTO club (club_name)
VALUES('Fenerbahçe');
INSERT INTO club (club_name)
VALUES('Anadolu Efes');
INSERT INTO club (club_name)
VALUES('Türk Telekom');
INSERT INTO club (club_name)
VALUES('Galatasaray');

INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('1994-1995 Season Men U16 League', 1, 1, 1);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('1994-1995 Season Women U16 League', 1, 1, 2);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('1994-1995 Season Men U18 League', 1, 2, 1);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('1994-1995 Season Women U18 League', 1, 2, 2);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('1994-1995 Season Men Regional League', 1, 3, 1);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('1994-1995 Season Women Regional League', 1, 3, 2);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('1994-1995 Season Men Super League', 1, 4, 1);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('1994-1995 Season Women Super League', 1, 4, 2);

INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2011-2012 Season Men U16 League', 2, 1, 1);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2011-2012 Season Women U16 League', 2, 1, 2);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2011-2012 Season Men U18 League', 2, 2, 1);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2011-2012 Season Women U18 League', 2, 2, 2);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2011-2012 Season Men Regional League', 2, 3, 1);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2011-2012 Season Women Regional League', 2, 3, 2);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2011-2012 Season Men Super League', 2, 4, 1);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2011-2012 Season Women Super League', 2, 4, 2);

INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2021-2022 Season Men U16 League', 3, 1, 1);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2021-2022 Season Women U16 League', 3, 1, 2);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2021-2022 Season Men U18 League', 3, 2, 1);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2021-2022 Season Women U18 League', 3, 2, 2);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2021-2022 Season Men Regional League', 3, 3, 1);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2021-2022 Season Women Regional League', 3, 3, 2);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2021-2022 Season Men Super League', 3, 4, 1);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2021-2022 Season Women Super League', 3, 4, 2);

INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2022-2023 Season Men U16 League', 4, 1, 1);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2022-2023 Season Women U16 League', 4, 1, 2);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2022-2023 Season Men U18 League', 4, 2, 1);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2022-2023 Season Women U18 League', 4, 2, 2);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2022-2023 Season Men Regional League', 4, 3, 1);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2022-2023 Season Women Regional League', 4, 3, 2);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2022-2023 Season Men Super League', 4, 4, 1);
INSERT INTO league(league_name, season_id, division_id, gender_id)
VALUES('2022-2023 Season Women Super League', 4, 4, 2);

INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Fenerbahçe Men U16 League Team', 1, 1, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Fenerbahçe Women U16 League Team', 1, 1, 2);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Fenerbahçe Men U18 League Team', 1, 2, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Fenerbahçe Women U18 League Team', 1, 2, 2);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Fenerbahçe Men Regional League Team', 1, 3, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Fenerbahçe Women Regional League Team', 1, 3, 2);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Fenerbahçe Men Super League Team', 1, 4, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Fenerbahçe Women Super League Team', 1, 4, 2);

INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Anadolu Efes Men U16 League Team', 2, 1, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Anadolu Efes Women U16 League Team', 2, 1, 2);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Anadolu Efes Men U18 League Team', 2, 2, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Anadolu Efes Women U18 League Team', 2, 2, 2);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Anadolu Efes Men Regional League Team', 2, 3, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Anadolu Efes Women Regional League Team', 2, 3, 2);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Anadolu Efes Men Super League Team', 2, 4, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Anadolu Efes Women Super League Team', 2, 4, 2);

INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Türk Telekom Men U16 League Team', 3, 1, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Türk Telekom Women U16 League Team', 3, 1, 2);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Türk Telekom Men U18 League Team', 3, 2, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Türk Telekom Women U18 League Team', 3, 2, 2);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Türk Telekom Men Regional League Team', 3, 3, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Türk Telekom Women Regional League Team', 3, 3, 2);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Türk Telekom Men Super League Team', 3, 4, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Türk Telekom Women Super League Team', 3, 4, 2);

INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Galatasaray Men U16 League Team', 4, 1, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Galatasaray Women U16 League Team', 4, 1, 2);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Galatasaray Men U18 League Team', 4, 2, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Galatasaray Women U18 League Team', 4, 2, 2);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Galatasaray Men Regional League Team', 4, 3, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Galatasaray Women Regional League Team', 4, 3, 2);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Galatasaray Men Super League Team', 4, 4, 1);
INSERT INTO team(team_name, club_id, division_id, gender_id)
VALUES('Galatasaray Women Super League Team', 4, 4, 2);