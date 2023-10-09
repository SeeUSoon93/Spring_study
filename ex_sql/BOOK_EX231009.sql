
-- tbl_board ���̺� ��ȣ�� �� ������ ����
CREATE SEQUENCE seq_board;

-- tbl_board ����
CREATE TABLE tbl_board(
    bno number(10,0),
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(2000) NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    regdate DATE DEFAULT SYSDATE,
    updatedate DATE DEFAULT SYSDATE
);

-- tbl_board primary key ����
ALTER TABLE tbl_board ADD CONSTRAINT pk_board
PRIMARY KEY (bno);


-- tbl_board�� ���� ������ ����
INSERT INTO tbl_board (bno, title, content, writer)
VALUES (seq_board.nextval, '�׽�Ʈ ����', '�׽�Ʈ ����', 'user00');

COMMIT;

SELECT * FROM tbl_board;