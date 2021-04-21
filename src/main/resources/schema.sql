CREATE TABLE user_info(
    user_id CHAR(50),
    user_password CHAR (200)
);
CREATE TABLE user_memo(
    user_id CHAR(50) PRIMARY KEY,
    memo_item CHAR(200),
    write_date DATE
);
