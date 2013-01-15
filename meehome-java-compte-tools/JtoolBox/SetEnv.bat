@echo off

set CONFIGURATION_FILE=configuration.properties

@REM Applications
@REM : Directory : lieu ou la console se place à l'ouverture ( je l'ai mis sur mon project par exemple )
FOR /F "eol=; tokens=2,2 delims==" %%i IN ('findstr /i "DIRECTORY" %CONFIGURATION_FILE%') DO set DIRECTORY=%%i

@REM : JAVA_HOME : Permet de switch d'une JDK 1.5 à une autre 1.7 par exemple
FOR /F "eol=; tokens=2,2 delims==" %%i IN ('findstr /i "JAVA_HOME" %CONFIGURATION_FILE%') DO set JAVA_HOME=%%i

@REM : M2_HOME : Permet de switch d'un maven 2.2.1 à un maven 3.0 par exemple
FOR /F "eol=; tokens=2,2 delims==" %%i IN ('findstr /i "M2_HOME" %CONFIGURATION_FILE%') DO set M2_HOME=%%i

@REM : SVN_HOME : Configuration de svn
FOR /F "eol=; tokens=2,2 delims==" %%i IN ('findstr /i "SVN_HOME" %CONFIGURATION_FILE%') DO set SVN_HOME=%%i

@REM : Configuration de maven en terme de proxy, repo distant tout ça ( à venir ) pour le moment ne mettez rien ça gene pas
FOR /F "eol=; tokens=2,2 delims==" %%i IN ('findstr /i "GLOBAL_SETTINGS" %CONFIGURATION_FILE%') DO set GLOBAL_SETTINGS=%%i
FOR /F "eol=; tokens=2,2 delims==" %%i IN ('findstr /i "USER_SETTINGS" %CONFIGURATION_FILE%') DO set USER_SETTINGS=%%i

@REM Options maven
set MAVEN_OPTS=-Xms256m %MAVEN_OPTS%
set MAVEN_OPTS=-Xmx512m %MAVEN_OPTS%
set MAVEN_OPTS=-XX:PermSize=64m %MAVEN_OPTS%
set MAVEN_OPTS=-XX:MaxPermSize=512m %MAVEN_OPTS%
set MAVEN_OPTS=-Duser.language=fr %MAVEN_OPTS%
set MAVEN_OPTS=-Duser.locale=fr %MAVEN_OPTS%
@REM set MAVEN_OPTS=-Duser.home=%JTBOX_INST_USER_SETTINGS_DIR% %MAVEN_OPTS%
set MAVEN_OPTS=-Dorg.apache.maven.global-settings=%GLOBAL_SETTINGS% %MAVEN_OPTS%
set MAVEN_OPTS=-Dorg.apache.maven.user-settings=%USER_SETTINGS% %MAVEN_OPTS%

set PATH=%JAVA_HOME%\bin;%M2_HOME%\bin;%SVN_HOME%\bin;%PATH%
cd %DIRECTORY%
