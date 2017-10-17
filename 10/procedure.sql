CREATE PROCEDURE lb10Procedure(IN v VARCHAR(10), IN n VARCHAR(50))
  BEGIN
    INSERT INTO `values` (value, note) VALUES (v, n);
  END;
