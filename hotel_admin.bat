set MYSQLUSER=root
set MYSQLPASS=1111
set HOST=localhost

mysql -u %MYSQLUSER% -p %MYSQLPASS% -h %HOST%  hotel_admin< db.sql
Pause