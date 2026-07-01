BEGIN
   for rec in (
      select CustomerID from Customers where trunc(months_between(sysdate,dob)/12) > 60
   )
   loop
   update loans
   set InterestRate  = InterestRate  - 1
   where customerid = rec.customerid;
   end loop;
   commit;
END;
/
