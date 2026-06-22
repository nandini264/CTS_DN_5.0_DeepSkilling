CREATE TABLE employees (
    employeeID NUMBER PRIMARY KEY,
    employeeName VARCHAR2(20),
    department VARCHAR2(20),
    salary NUMBER
);

INSERT INTO employees VALUES (1,'Uzma','IT',50000);
INSERT INTO employees VALUES (2,'Nandini','HR',40000);
INSERT INTO employees VALUES (3,'Komali','IT',60000);

COMMIT;

-- select * from employees;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonusPercent IN NUMBER
)
IS
BEGIN
    UPDATE employees
    SET salary = salary + (salary * p_bonusPercent / 100)
    WHERE department = p_department;

    COMMIT;
END;
/

EXEC UpdateEmployeeBonus('IT',10);
select * from employees;