
-- tbl_board 테이블 번호에 들어갈 시퀀스 생성
CREATE SEQUENCE seq_board;

-- tbl_board 생성
CREATE TABLE tbl_board(
    bno number(10,0),
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(2000) NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    regdate DATE DEFAULT SYSDATE,
    updatedate DATE DEFAULT SYSDATE
);

-- tbl_board primary key 지정
ALTER TABLE tbl_board ADD CONSTRAINT pk_board
PRIMARY KEY (bno);


-- tbl_board에 더미 데이터 생성
INSERT INTO tbl_board (bno, title, content, writer)
VALUES (seq_board.nextval, '테스트 제목', '테스트 내용', 'user00');

COMMIT;

SELECT * FROM tbl_board;