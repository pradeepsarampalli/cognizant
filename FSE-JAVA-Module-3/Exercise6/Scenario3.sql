DECLARE
   CURSOR c_loans IS
      SELECT LoanID,
             InterestRate
      FROM Loans;

   v_loan_id Loans.LoanID%TYPE;
   v_rate    Loans.InterestRate%TYPE;

BEGIN

   OPEN c_loans;

   LOOP

      FETCH c_loans
      INTO v_loan_id,v_rate;

      EXIT WHEN c_loans%NOTFOUND;

      IF v_rate < 10 THEN

         UPDATE Loans
         SET InterestRate = InterestRate + 0.5
         WHERE LoanID = v_loan_id;

      END IF;

   END LOOP;

   CLOSE c_loans;

   COMMIT;

END;
/