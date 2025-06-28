CREATE TABLE customers (
  customer_id NUMBER PRIMARY KEY,
  name VARCHAR2(50),
  age NUMBER,
  balance NUMBER,
  IsVIP VARCHAR2(5)
);
INSERT INTO customers VALUES (1, 'Ravi', 65, 12000, 'FALSE');
INSERT INTO customers VALUES (2, 'Priya', 45, 9000, 'FALSE');
INSERT INTO customers VALUES (3, 'Kumar', 70, 8000, 'FALSE');
INSERT INTO customers VALUES (4, 'Anu', 30, 15000, 'FALSE');
COMMIT;
CREATE TABLE loans (
  loan_id NUMBER PRIMARY KEY,
  customer_id NUMBER,
  interest_rate NUMBER(5,2),
  due_date DATE,
  FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
INSERT INTO loans VALUES (101, 1, 10.5, SYSDATE + 10);
INSERT INTO loans VALUES (102, 2, 11.0, SYSDATE + 40);
INSERT INTO loans VALUES (103, 3, 9.5, SYSDATE + 5);
INSERT INTO loans VALUES (104, 4, 8.0, SYSDATE + 20);
COMMIT;

-- Scenario 1
SET SERVEROUTPUT ON;

BEGIN
  FOR cust IN (
    SELECT c.customer_id, l.loan_id
    FROM customers c
    JOIN loans l ON c.customer_id = l.customer_id
    WHERE c.age > 60
  )
  LOOP
    UPDATE loans
    SET interest_rate = interest_rate - 1
    WHERE loan_id = cust.loan_id;
  END LOOP;

  COMMIT;
END;
SELECT * FROM loans;

-- Scenario 2
SET SERVEROUTPUT ON;

BEGIN
  FOR cust IN (SELECT customer_id FROM customers WHERE balance > 10000)
  LOOP
    UPDATE customers
    SET IsVIP = 'TRUE'
    WHERE customer_id = cust.customer_id;
  END LOOP;

  COMMIT;
END;
SELECT * FROM customers;

-- Scenario 3
SET SERVEROUTPUT ON;

BEGIN
  FOR loan_rec IN (
    SELECT loan_id, customer_id, due_date
    FROM loans
    WHERE due_date <= SYSDATE + 30
  )
  LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Customer ID ' || loan_rec.customer_id ||
                         ' has a loan due on ' || TO_CHAR(loan_rec.due_date, 'DD-MON-YYYY'));
  END LOOP;
END;
SELECT * FROM loans;