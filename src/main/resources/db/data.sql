insert into user_tb(username, password, email) values('ssar', '$2a$10$DDJOwWzVI3VE4jtDgc.OcOQymy1sbksVfA0uJ9tVF.p/WZiP1X3qy', 'ssar@nate.com');
insert into user_tb(username, password, email, height, weight) values('cos', '$2a$10$DDJOwWzVI3VE4jtDgc.OcOQymy1sbksVfA0uJ9tVF.p/WZiP1X3qy', 'cos@nate.com', 170, 70);
insert into user_tb(username, password, email) values('love', '$2a$10$DDJOwWzVI3VE4jtDgc.OcOQymy1sbksVfA0uJ9tVF.p/WZiP1X3qy', 'love@nate.com');


insert into category_tb(name) values('부위1');
insert into category_tb(name) values('부위2');
insert into category_tb(name) values('부위3');
insert into category_tb(name) values('부위4');
insert into category_tb(name) values('부위5');


insert into fitness_tb(fitness_name, category_id, image_url, content) values('운동1', 1, '이미지경로1', '운동1의 내용');
insert into fitness_tb(fitness_name, category_id, image_url, content) values('운동2', 2, '이미지경로2', '운동2의 내용');
insert into fitness_tb(fitness_name, category_id, image_url, content) values('운동3', 3, '이미지경로3', '운동3의 내용');
insert into fitness_tb(fitness_name, category_id, image_url, content) values('운동4', 4, '이미지경로4', '운동4의 내용');
insert into fitness_tb(fitness_name, category_id, image_url, content) values('운동5', 5, '이미지경로5', '운동5의 내용');
insert into fitness_tb(fitness_name, category_id, image_url, content) values('운동6', 5, '이미지경로6', '운동6의 내용');
insert into fitness_tb(fitness_name, category_id, image_url, content) values('운동7', 5, '이미지경로7', '운동7의 내용');
insert into fitness_tb(fitness_name, category_id, image_url, content) values('운동8', 2, '이미지경로8', '운동8의 내용');
insert into fitness_tb(fitness_name, category_id, image_url, content) values('운동9', 1, '이미지경로9', '운동9의 내용');
insert into fitness_tb(fitness_name, category_id, image_url, content) values('운동10', 4, '이미지경로10', '운동10의 내용');
insert into fitness_tb(fitness_name, category_id, image_url, content) values('운동11', 2, '이미지경로11', '운동11의 내용');
insert into fitness_tb(fitness_name, category_id, image_url, content) values('운동12', 1, '이미지경로12', '운동12의 내용');
insert into fitness_tb(fitness_name, category_id, image_url, content) values('운동13', 3, '이미지경로13', '운동13의 내용');
insert into fitness_tb(fitness_name, category_id, image_url, content) values('운동14', 2, '이미지경로14', '운동14의 내용');
insert into fitness_tb(fitness_name, category_id, image_url, content) values('운동15', 5, '이미지경로15', '운동15의 내용');


insert into plan_tb(user_id, fitness_id, day_of_week, exercise_set, repeat, weight) values(1, 1, '월', 3, 5, 50);
insert into plan_tb(user_id, fitness_id, day_of_week, exercise_set, repeat, weight) values(1, 2, '월', 3, 5, 50);
insert into plan_tb(user_id, fitness_id, day_of_week, exercise_set, repeat, weight) values(1, 3, '월', 3, 5, 50);
insert into plan_tb(user_id, fitness_id, day_of_week, exercise_set, repeat, weight) values(1, 4, '월', 3, 5, 50);
insert into plan_tb(user_id, fitness_id, day_of_week, exercise_set, repeat, weight) values(1, 5, '화', 3, 5, 50);
insert into plan_tb(user_id, fitness_id, day_of_week, exercise_set, repeat, weight) values(1, 1, '화', 3, 5, 50);
insert into plan_tb(user_id, fitness_id, day_of_week, exercise_set, repeat, weight) values(1, 1, '수', 3, 5, 50);




