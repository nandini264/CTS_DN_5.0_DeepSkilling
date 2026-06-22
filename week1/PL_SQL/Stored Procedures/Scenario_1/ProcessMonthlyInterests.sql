CREATE TABLE Accounts (
    accountID NUMBER PRIMARY KEY,
    customerName VARCHAR2(20),
    accountType VARCHAR2(10),
    balance NUMBER
);

INSERT INTO Accounts VALUES (1,'Nandini','Savings',10000);
INSERT INTO Accounts VALUES (2,'Uzma','Current',15000);
INSERT INTO Accounts VALUES (3,'Komali','Savings',20000);

COMMIT;
-- select * from Accounts;


CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
    UPDATE accounts
    SET balance = balance + (balance * 0.01)
    WHERE accountType = 'Savings';

    COMMIT;
END;
/
EXEC ProcessMonthlyInterest;