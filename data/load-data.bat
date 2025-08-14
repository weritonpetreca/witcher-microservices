@echo off
echo Loading Witcher data into PostgreSQL...
echo.

REM Execute the SQL script in the PostgreSQL container
docker exec -i witcher-postgres psql -U witcher_user -d witcher_db < witcher-data.sql

echo.
echo Data loading completed!
echo.
echo To verify the data was loaded:
echo docker exec -it witcher-postgres psql -U witcher_user -d witcher_db -c "SELECT COUNT(*) FROM items;"
echo docker exec -it witcher-postgres psql -U witcher_user -d witcher_db -c "SELECT COUNT(*) FROM monsters;"
pause