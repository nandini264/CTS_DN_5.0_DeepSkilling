CREATE TABLE bankAccounts (
    accountID NUMBER PRIMARY KEY,
    customerName VARCHAR2(20),
    balance NUMBER
);

INSERT INTO bankAccounts VALUES (101,'Aruna',10000);
INSERT INTO bankAccounts VALUES (102,'Nandini',5000);

COMMIT;

select * from bankAccounts;

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_fromAccount IN NUMBER,
    p_toAccount IN NUMBER,
    p_amount IN NUMBER
)
IS
    v_balance NUMBER;
BEGIN
    SELECT balance
    INTO v_balance
    FROM bankAccounts
    WHERE accountID = p_fromAccount;

    IF v_balance >= p_amount THEN

        UPDATE bankAccounts
        SET balance = balance - p_amount
        WHERE accountID = p_fromAccount;

        UPDATE bankAccounts
        SET balance = balance + p_amount
        WHERE accountID = p_toAccount;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Transfer Successful');

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient Balance');

    END IF;
END;
/

EXEC TransferFunds(101,102,3000);
select * from BANKACCOUNTS