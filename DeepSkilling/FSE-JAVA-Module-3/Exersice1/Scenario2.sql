BEGIN
   for rec in (
      select customerid from customers where BALANCE > 10000
   )
   loop 
   update customers
   set isvip = 'true'
   where customerid = rec.customerid;
   end loop;
   commit;
END;
/
