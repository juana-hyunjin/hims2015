INSERT INTO MEMBER VALUES ('user01', 'user01', '사용자1', '01011111111', '', 'user01@user01.com', '111111', 'G', '0');
INSERT INTO MEMBER VALUES ('user02', 'user02', '사용자2', '01012222222', '', 'user02@user02.com', '222222', 'S', '6');
INSERT INTO MEMBER VALUES ('user03', 'user03', '사용자3', '01033333333', '', 'user03@user03.com', '333333', 'A', '11');
INSERT INTO MEMBER VALUES ('user04', 'user04', '사용자4', '01044444444', '', 'user04@user04.com', '444444', 'G', '1');
INSERT INTO MEMBER VALUES ('user05', 'user05', '사용자5', '01055555555', '', 'user05@user05.com', '555555', 'G', '3');
INSERT INTO MEMBER VALUES ('user06', 'user06', '사용자6', '01066666666', '', 'user06@user06.com', '666666', 'AP', '3');
INSERT INTO MEMBER VALUES ('admin', 'admin', '사용자7', '01077777777', '', 'user07@user07.com', '777777', 'M', '3');


INSERT INTO ROOM_TYPE VALUES(1, 'SINGLE ROOM', '싱글베드1', '80,000', 1);
INSERT INTO ROOM_TYPE VALUES(2, 'TWIN ROOM', '싱글베드2', '150,000', 2);
INSERT INTO ROOM_TYPE VALUES(3, 'DOUBLE ROOM', '더블베드1', '150,000', 2);
INSERT INTO ROOM_TYPE VALUES(4, 'DELUX ROOM', '퀸베드1', '200,000', 2);
INSERT INTO ROOM_TYPE VALUES(5, 'SUITE ROOM', '킹베드1, 싱글1', '450,000', 3);
INSERT INTO ROOM_TYPE VALUES(6, 'PRESIDENT ROOM', '킹베드1, 퀸베드1', '900,000', 4);

INSERT INTO ROOM VALUES(401, '4', 'O', 1);
INSERT INTO ROOM VALUES(402, '4', 'X', 2);
INSERT INTO ROOM VALUES(403, '4', 'O', 2);
INSERT INTO ROOM VALUES(404, '4', 'O', 3);
INSERT INTO ROOM VALUES(405, '4', 'X', 3);
INSERT INTO ROOM VALUES(406, '4', 'O', 4);
INSERT INTO ROOM VALUES(407, '4', 'O', 4);
INSERT INTO ROOM VALUES(408, '4', 'O', 4);
INSERT INTO ROOM VALUES(409, '4', 'X', 5);
INSERT INTO ROOM VALUES(410, '4', 'O', 5);
INSERT INTO ROOM VALUES(411, '4', 'O', 6);

INSERT INTO RESERVATION VALUES('20151129001', 'user01', 1, 1, '2015-11-13', '2015-11-16', '' ,'');
INSERT INTO RESERVATION VALUES('20151129002', 'user02', 2, 2, '2015-12-16', '2015-12-25', '아이가 있습니다.' ,'');
INSERT INTO RESERVATION VALUES('20151129003', 'user03', 3, 2, '2015-12-11', '2015-12-15', '' ,'');
INSERT INTO RESERVATION VALUES('20151129004', 'user04', 4, 2, '2015-11-06', '2015-11-11', '' ,'');
INSERT INTO RESERVATION VALUES('20151129005', 'user05', 5, 3, '2015-11-06', '2015-11-11', '' ,'');
INSERT INTO RESERVATION VALUES('20151129006', 'user05', 6, 3, '2015-11-06', '2015-11-11', '' ,'');

INSERT INTO TIME_EVENT VALUES( 1, '편의점', '12:00', 'user01');
INSERT INTO TIME_EVENT VALUES( 2, '레스토랑', '17:00', 'user02');
INSERT INTO TIME_EVENT VALUES( 3, '피트니스센터', '23:00', 'user03');
INSERT INTO TIME_EVENT VALUES( 4, '마사지샵', '21:00', 'user04');
INSERT INTO TIME_EVENT VALUES( 5, '카페', '18:00', 'user05');
INSERT INTO TIME_EVENT VALUES( 1, '편의점', '08:00', 'user06');