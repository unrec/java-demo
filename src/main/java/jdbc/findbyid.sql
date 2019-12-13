DELIMITER //

CREATE PROCEDURE findbyid (IN u_id INT(10), OUT p_name VARCHAR(45))
BEGIN
SELECT user_name INTO p_name FROM users WHERE user_id = u_id;
END //

DELIMITER ;