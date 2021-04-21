
GRANT ALL ON memoAppDB.* TO 'springuser'@'localhost';


INSERT INTO user_info(user_id, user_password)
    VALUES('testuser','logintest')
;

INSERT INTO user_memo(user_id, memo_item)
    VALUES('testuser','テストメモ')
;