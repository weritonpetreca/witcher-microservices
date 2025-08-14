@echo off
echo Loading Witcher data into PostgreSQL...
echo.

REM Execute the SQL scripts in the PostgreSQL container
docker exec -i witcher-postgres psql -U witcher_user -d witcher_db < witcher-data.sql
docker exec -i witcher-postgres psql -U witcher_user -d witcher_db < contracts-data.sql

echo.
echo Data loading completed!
echo.
echo To verify the data was loaded:
echo docker exec -it witcher-postgres psql -U witcher_user -d witcher_db -c "SELECT COUNT(*) FROM items;"
echo docker exec -it witcher-postgres psql -U witcher_user -d witcher_db -c "SELECT COUNT(*) FROM monsters;"
echo docker exec -it witcher-postgres psql -U witcher_user -d witcher_db -c "SELECT COUNT(*) FROM contracts;"
echo docker exec -it witcher-postgres psql -U witcher_user -d witcher_db -c "SELECT COUNT(*) FROM contract_items;"
pause