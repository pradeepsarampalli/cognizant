create or replace package CustomerManagement as
procedure AddCustomer(
    p_cusomerid in number,
    p_name in varchar2,
    p_dob in date,
    p_balance in number,
    p_isvip in varchar2
);
procedure UpdateCustomer(
    p_cusomerid in number,
    p_name in varchar2,
);
function GetCustomerBalance(
    p_cusomerid in number,
)
return number;
end CustomerManagement;
/
