create or replace trigger UpdateCustomerLastModified 
before update on Customers
for each row
begin
    :NEW.lastModified := SYSDATE;
end;
/
