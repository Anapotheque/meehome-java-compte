@echo off

@REM Applications
@REM : Directory : lieu ou la console se place à l'ouverture ( je l'ai mis sur mon project par exemple )
set DIRECTORY=D:\My\my-Java\meehome-java-compte

@REM : JAVA_HOME : Permet de switch d'une JDK 1.5 à une autre 1.7 par exemple
set JAVA_HOME=D:\dev\softs\5.0.1\apps\jdk\1.6.0-18

@REM : M2_HOME : Permet de switch d'un maven 2.2.1 à un maven 3.0 par exemple
set M2_HOME=D:\My\tools\apache-maven-3.0.4

@REM : SVN_HOME : Configuration de svn
set SVN_HOME=D:\jtb\softs\5.0.1\apps\svn-win32-1.6.6

@REM : Configuration de maven en terme de proxy, repo distant tout ça ( à venir ) pour le moment ne mettez rien ça gene pas
set GLOBAL_SETTINGS=D:\My\tools\conf\maven\global\settings.xml
set USER_SETTINGS=D:\My\tools\conf\maven\users\settings.xml

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

@echo on
@echo --------------------------------------------------------------
@echo -  JTOOLBOX                                                  -
@echo --------------------------------------------------------------
@echo off
cd %DIRECTORY%
cmd.exe