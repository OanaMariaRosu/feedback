INSERT INTO EMPLOYEE(id, name, surname, user_name, password, position, date_of_employment, next_review_date) 
	VALUES(1, 'Burlacu', 'Dorin', 'dburlacu', '1234', 'SSD1', PARSEDATETIME('17/12/2015', 'DD/MM/YYYY'), PARSEDATETIME('17/05/2017', 'DD/MM/YYYY'));

INSERT INTO TEAM(id, project_name, team_leader_id) VALUES(1, 'unite', 1);
update employee set team_id=1 where id=1;

INSERT INTO EMPLOYEE(id, name, surname, user_name, password, position, date_of_employment, next_review_date, team_id) 
	VALUES(2, 'Arusoaie', 'Emilian', 'earusoaie', '2345', 'JSD2', PARSEDATETIME('17/02/2017', 'DD/MM/YYYY'), PARSEDATETIME('17/08/2017', 'DD/MM/YYYY'), 1);
INSERT INTO EMPLOYEE(id, name, surname, user_name, password, position, date_of_employment, next_review_date, team_id) 
	VALUES(3, 'Mihalcea', 'Andreea', 'amihalcea', '3456', 'SD1', PARSEDATETIME('22/01/2016', 'DD/MM/YYYY'), PARSEDATETIME('22/01/2018', 'DD/MM/YYYY'), 1);


INSERT INTO CATEGORY(id, name, description) VALUES (1, 'Technical Expertise', 'Know-how regarding the technology, the tools, the framework ');
INSERT INTO CATEGORY(id, name, description) VALUES (2, 'Analytical Thinking', 'Assesment of problem solving skills: understanding requirements, thinking-up and 	optimizing ideas, implementing and testing the code');
INSERT INTO CATEGORY(id, name, description) VALUES (3, 'Work Quality', 'Compliance to quality standards (whether it is coding / testing standards compliance like clean code etc., or quality standards specific for the role)');
INSERT INTO CATEGORY(id, name, description) VALUES (4, 'Autonomy', 'Support required in delivering assigned tasks');
INSERT INTO CATEGORY(id, name, description) VALUES (5, 'Learning and Adaptability', 'The speed needed to assimilate new information, and adaption to changes');
INSERT INTO CATEGORY(id, name, description) VALUES (6, 'Time Management', 'The prioritization of work');
INSERT INTO CATEGORY(id, name, description) VALUES (7, 'Communication Skills', 'Argumentation of decision, presentation skills, ability to give feedback');
INSERT INTO CATEGORY(id, name, description) VALUES (8, 'Team Work', 'Helping someone, team orientation - support for team, cooperation, coaching');

INSERT INTO PENDING_FEEDBACK(id, feedback_for, feedback_from, due_date) VALUES (1, 1, 1, PARSEDATETIME('17/05/2017', 'DD/MM/YYYY'));
INSERT INTO PENDING_FEEDBACK(id, feedback_for, feedback_from, due_date) VALUES (2, 1, 2, PARSEDATETIME('17/05/2017', 'DD/MM/YYYY'));
INSERT INTO PENDING_FEEDBACK(id, feedback_for, feedback_from, due_date) VALUES (3, 1, 3, PARSEDATETIME('17/05/2017', 'DD/MM/YYYY'));

INSERT INTO FEEDBACK(id, given_at, given_by, given_to) VALUES (1, PARSEDATETIME('13/01/2016', 'DD/MM/YYYY'), 1, 3);
INSERT INTO FEEDBACK(id, given_at, given_by, given_to) VALUES (2, PARSEDATETIME('14/01/2016', 'DD/MM/YYYY'), 3, 3);

INSERT INTO RATING(id, message, score, category_id, feedback_id) VALUES (1, 'As expected', 2, 1, 1);
INSERT INTO RATING(id, message, score, category_id, feedback_id) VALUES (2, 'As expected', 0, 2, 1);
INSERT INTO RATING(id, message, score, category_id, feedback_id) VALUES (3, 'As expected', 2, 3, 1);
INSERT INTO RATING(id, message, score, category_id, feedback_id) VALUES (4, 'As expected', 1, 4, 1);
INSERT INTO RATING(id, message, score, category_id, feedback_id) VALUES (5, 'As expected', 3, 5, 1);
INSERT INTO RATING(id, message, score, category_id, feedback_id) VALUES (6, 'As expected', 1, 6, 1);
INSERT INTO RATING(id, message, score, category_id, feedback_id) VALUES (7, 'As expected', 0, 7, 1);
INSERT INTO RATING(id, message, score, category_id, feedback_id) VALUES (8, 'As expected', 0, 8, 1);
INSERT INTO RATING(id, message, score, category_id, feedback_id) VALUES (9, 'Message1', 1, 1, 2);
INSERT INTO RATING(id, message, score, category_id, feedback_id) VALUES (10, 'Message2', 1, 2, 2);
INSERT INTO RATING(id, message, score, category_id, feedback_id) VALUES (11, 'Message3', 1, 3, 2);
INSERT INTO RATING(id, message, score, category_id, feedback_id) VALUES (12, 'Message4', 1, 4, 2);
INSERT INTO RATING(id, message, score, category_id, feedback_id) VALUES (13, 'Message5', 2, 5, 2);
INSERT INTO RATING(id, message, score, category_id, feedback_id) VALUES (14, 'Message6', 1, 6, 2);
INSERT INTO RATING(id, message, score, category_id, feedback_id) VALUES (15, 'Message7', 0, 7, 2);
INSERT INTO RATING(id, message, score, category_id, feedback_id) VALUES (16, 'Message8', 1, 8, 2);

COMMIT;
