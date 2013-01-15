@echo off
call setEnv.bat
mvn clean install && eclipse:eclipse