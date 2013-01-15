@echo off
call SetEnv.bat
mvn clean && eclipse:clean
pause