begin
    for rec in (
        select c.Name , l.enddate , l.LoanID  from customers c join Loans l on c.customerid = l.customerid
        where l.enddate <= sysdate+30
    )
    loop
    dbms_output.put_line(
        'Reminder'
        || rec.Name || 'Loan due'
        || rec.enddate
    );
    end loop;
end;
/