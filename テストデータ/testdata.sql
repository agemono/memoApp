CREATE DATABASE memoAppDB;
USE memoAppDB;

GRANT ALL ON memoAppDB.* TO 'memoAppManeger'@'your_client_host';

CREATE TABLE user_info(
    user_id CHAR(50),
    user_password CHAR (50)
);
INSERT INTO user_info
    VALUES('testuser','logintest')
;

CREATE TABLE user_memo(
    user_id CHAR(50),
    memo_item CHAR(200)
);
