-- creating a sample customers table
CREATE TABLE Customers (
    customerID NUMBER PRIMARY KEY,
    customerName VARCHAR2(20),
    age NUMBER,
    loanInterest NUMBER,
    isVip CHAR(1),
    balance NUMBER
);

-- inserting data into the table
INSERT INTO Customers VALUES (1,'Ravi',65,8,'N',15000);
INSERT INTO Customers VALUES (2,'Sita',45,9,'N',8000);
INSERT INTO Customers VALUES (3,'Kiran',70,7,'N',12000);

COMMIT;

-- Task1
BEGIN
    FOR custmr IN (
        SELECT customerID, age
        FROM Customers
    )
    LOOP
        IF custmr.age > 60 THEN
            UPDATE Customers
            SET loanInterest = loanInterest * 0.99
            WHERE customerID = custmr.customerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/

-- to retrieve updated data for sc1
-- SELECT * FROM Customers;
-- ----------------------------------------------------------------

-- executing task2
BEGIN
    FOR custmr IN (
        SELECT customerID, balance
        FROM Customers
    )
    LOOP
        IF custmr.balance > 10000 THEN
            UPDATE Customers
            SET isVip = 'Y'
            WHERE customerID = custmr.customerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/

-- to retrieve updated data for sc2
-- SELECT * FROM Customers;

-- -------------------------------------------------------------------

-- Creating Loans table for sample data and output
CREATE TABLE Loans (
    loanID NUMBER PRIMARY KEY,
    customerID NUMBER,
    dueDate DATE
);

INSERT INTO Loans VALUES (101,1,SYSDATE+10);
INSERT INTO Loans VALUES (102,2,SYSDATE+40);
INSERT INTO Loans VALUES (103,3,SYSDATE+20);

COMMIT;
-- Executing Task3
BEGIN
    FOR loan_rec IN (
        SELECT loanID, customerID, dueDate
        FROM Loans
        WHERE dueDate <= SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan ID ' ||
            loan_rec.loanID ||
            ' is due on ' ||
            TO_CHAR(loan_rec.dueDate,'DD-MON-YYYY')
        );
    END LOOP;
END;
/
-- to retrieve updated data for sc3
SELECT * FROM Customers;