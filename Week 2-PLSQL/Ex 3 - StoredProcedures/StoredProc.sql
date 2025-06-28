CREATE TABLE Employees (
  EmployeeID NUMBER PRIMARY KEY,
  Name VARCHAR2(100),
  Position VARCHAR2(50),
  Salary NUMBER,
  Department VARCHAR2(50),
  HireDate DATE
);

INSERT INTO Employees VALUES (1, 'Arjun', 'Manager', 50000, 'Sales', SYSDATE - 365);
INSERT INTO Employees VALUES (2, 'Divya', 'Analyst', 40000, 'HR', SYSDATE - 200);
INSERT INTO Employees VALUES (3, 'Ravi', 'Executive', 35000, 'Sales', SYSDATE - 100);
COMMIT;

CREATE TABLE Customers (
  CustomerID NUMBER PRIMARY KEY,
  Name VARCHAR2(100),
  Age NUMBER
);

INSERT INTO Customers VALUES (1, 'Ravi', 65);
INSERT INTO Customers VALUES (2, 'Priya', 45);
INSERT INTO Customers VALUES (3, 'Arun', 30);
COMMIT;


CREATE TABLE Accounts (
  AccountID NUMBER PRIMARY KEY,
  CustomerID NUMBER,
  AccountType VARCHAR2(20),
  Balance NUMBER,
  LastModified DATE,
  FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

INSERT INTO Accounts VALUES (101, 1, 'Savings', 10000, SYSDATE);
INSERT INTO Accounts VALUES (102, 2, 'Savings', 20000, SYSDATE);
INSERT INTO Accounts VALUES (103, 3, 'Current', 5000, SYSDATE);
COMMIT;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
  v_old_balance NUMBER;
  v_new_balance NUMBER;
BEGIN
  FOR acc IN (
    SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'Savings'
  ) LOOP
    v_old_balance := acc.Balance;
    v_new_balance := acc.Balance + (acc.Balance * 0.01);

    -- Update balance
    UPDATE Accounts
    SET Balance = v_new_balance,
        LastModified = SYSDATE
    WHERE AccountID = acc.AccountID;

    -- Print update details
    DBMS_OUTPUT.PUT_LINE('Account ID: ' || acc.AccountID || 
                         ' | Old Balance: ' || v_old_balance ||
                         ' | New Balance: ' || v_new_balance);
  END LOOP;

  COMMIT;
END;

SET SERVEROUTPUT ON;

EXEC ProcessMonthlyInterest;

SELECT * FROM Accounts;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  dept IN VARCHAR2,
  bonus_percent IN NUMBER
) IS
  v_old_salary NUMBER;
  v_new_salary NUMBER;
BEGIN
  FOR emp IN (
    SELECT EmployeeID, Name, Salary 
    FROM Employees 
    WHERE Department = dept
  ) LOOP
    v_old_salary := emp.Salary;
    v_new_salary := emp.Salary + (emp.Salary * bonus_percent / 100);

    -- Update salary
    UPDATE Employees
    SET Salary = v_new_salary
    WHERE EmployeeID = emp.EmployeeID;

    -- Print details
    DBMS_OUTPUT.PUT_LINE('Employee: ' || emp.Name || 
                         ' | Old Salary: ' || v_old_salary ||
                         ' | New Salary: ' || v_new_salary);
  END LOOP;

  COMMIT;
END;
SET SERVEROUTPUT ON;

EXEC UpdateEmployeeBonus('Sales', 10);
SELECT * FROM Employees;

CREATE OR REPLACE PROCEDURE TransferFunds (
  from_acc IN NUMBER,
  to_acc IN NUMBER,
  amount IN NUMBER
) IS
  v_from_balance_before NUMBER;
  v_to_balance_before NUMBER;
  v_from_balance_after NUMBER;
  v_to_balance_after NUMBER;
BEGIN
  -- Get balance of sender
  SELECT Balance INTO v_from_balance_before FROM Accounts WHERE AccountID = from_acc;

  -- Check if enough balance
  IF v_from_balance_before >= amount THEN

    -- Get balance of receiver
    SELECT Balance INTO v_to_balance_before FROM Accounts WHERE AccountID = to_acc;

    -- Perform Transfer
    UPDATE Accounts
    SET Balance = Balance - amount,
        LastModified = SYSDATE
    WHERE AccountID = from_acc;

    UPDATE Accounts
    SET Balance = Balance + amount,
        LastModified = SYSDATE
    WHERE AccountID = to_acc;

    -- Get updated balances
    SELECT Balance INTO v_from_balance_after FROM Accounts WHERE AccountID = from_acc;
    SELECT Balance INTO v_to_balance_after FROM Accounts WHERE AccountID = to_acc;

    -- Print output
    DBMS_OUTPUT.PUT_LINE(' Transfer Successful!');
    DBMS_OUTPUT.PUT_LINE('From Account ID: ' || from_acc ||
                         ' | Old Balance: ' || v_from_balance_before ||
                         ' | New Balance: ' || v_from_balance_after);
    DBMS_OUTPUT.PUT_LINE('To Account ID: ' || to_acc ||
                         ' | Old Balance: ' || v_to_balance_before ||
                         ' | New Balance: ' || v_to_balance_after);

    COMMIT;
  ELSE
    DBMS_OUTPUT.PUT_LINE('❌ Transfer Failed: Insufficient Balance in Account ID ' || from_acc);
  END IF;
END;

SET SERVEROUTPUT ON;

EXEC TransferFunds(101, 102, 5000);

SELECT * FROM Accounts;