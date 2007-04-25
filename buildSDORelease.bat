rem
rem   Licensed to the Apache Software Foundation (ASF) under one
rem   or more contributor license agreements.  See the NOTICE file
rem   distributed with this work for additional information
rem   regarding copyright ownership.  The ASF licenses this file
rem   to you under the Apache License, Version 2.0 (the
rem   "License"); you may not use this file except in compliance
rem   with the License.  You may obtain a copy of the License at
rem     http://www.apache.org/licenses/LICENSE-2.0
rem  
rem   Unless required by applicable law or agreed to in writing,
rem   software distributed under the License is distributed on an
rem   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
rem   KIND, either express or implied.  See the License for the
rem   specific language governing permissions and limitations
rem   under the License.
rem   
set RELEASE_VERSION=beta1
set RELEASE_CANDIDATE=RC1
set ROOT=C:\Development\beta1\BR2
set GPG_KEY_PW=%1
set SIGNER=kelvingoodson@apache.org

set ZIPEXE=C:\ProgFiles\7-Zip\7z.exe
set TAREXE=%ZIPEXE%
set GZIPEXE=%ZIPEXE%

set ZIPCREATEARGS=a -r -tzip
set ZIPEXTRACTARGS=x -r
set TARCREATEARGS=a -r -ttar
set GZIPARGS=a -tgzip 



set RELEASE=1.0-incubating-%RELEASE_VERSION%
set APISRCROOT=%ROOT%\export\api\tuscany-sdo-%RELEASE%
set IMPLSRCROOT=%ROOT%\export\impl\tuscany-sdo-%RELEASE%
set SAMPLESRCROOT=%ROOT%\export\sample\tuscany-sdo-%RELEASE%
set DISTROROOT=%ROOT%\distro
set TESTROOT=%ROOT%\testRelease

set TAG=https://svn.apache.org/repos/asf/incubator/tuscany/tags/java/sdo/%RELEASE%

echo *** Generating source distributions ***


mkdir %APISRCROOT%
mkdir %IMPLSRCROOT%
mkdir %SAMPLESRCROOT%
mkdir %DISTROROOT%
mkdir %TESTROOT%
                                       
svn export %TAG%/sdo-api %APISRCROOT%\sdo-api
svn export %TAG%/sdo %IMPLSRCROOT%\sdo
svn export %TAG%/sdo/sample %SAMPLESRCROOT%\sample

rem tidy up spurious status files -- need removing from svn
rm %APISRCROOT%\sdo-api\STATUS.txt %SAMPLESRCROOT%\sample\STATUS.txt  %IMPLSRCROOT%\sdo\STATUS


svn export https://svn.apache.org/repos/asf/incubator/tuscany/STATUS %APISRCROOT%\sdo-api\STATUS
copy %APISRCROOT%\sdo-api\STATUS %IMPLSRCROOT%\sdo\STATUS
copy %APISRCROOT%\sdo-api\STATUS %SAMPLESRCROOT%\sample\STATUS

                
cd %APISRCROOT%\..
%TAREXE% %TARCREATEARGS%  %DISTROROOT%\apache-tuscany-sdo-api-%RELEASE%-src.tar    tuscany-sdo-%RELEASE%
%GZIPEXE% %GZIPARGS%      %DISTROROOT%\apache-tuscany-sdo-api-%RELEASE%-src.tar.gz %DISTROROOT%\apache-tuscany-sdo-api-%RELEASE%-src.tar
del %DISTROROOT%\apache-tuscany-sdo-api-%RELEASE%-src.tar
%ZIPEXE% %ZIPCREATEARGS%  %DISTROROOT%\apache-tuscany-sdo-api-%RELEASE%-src.zip    tuscany-sdo-%RELEASE%


cd %IMPLSRCROOT%\..       
rmdir /s /q tuscany-sdo-%RELEASE%\sdo\sample
%TAREXE% %TARCREATEARGS%  %DISTROROOT%\apache-tuscany-sdo-impl-%RELEASE%-src.tar    tuscany-sdo-%RELEASE%
%GZIPEXE% %GZIPARGS%      %DISTROROOT%\apache-tuscany-sdo-impl-%RELEASE%-src.tar.gz %DISTROROOT%\apache-tuscany-sdo-impl-%RELEASE%-src.tar
del %DISTROROOT%\apache-tuscany-sdo-impl-%RELEASE%-src.tar
%ZIPEXE% %ZIPCREATEARGS%  %DISTROROOT%\apache-tuscany-sdo-impl-%RELEASE%-src.zip    tuscany-sdo-%RELEASE%


cd %APISRCROOT%\sdo-api
call mvn clean
call mvn


call mvn javadoc:javadoc

touch %ROOT%\a

cd %IMPLSRCROOT%\sdo
call mvn clean
call mvn
call mvn package javadoc:javadoc assembly:assembly

touch %ROOT%\b

rem delayed this step until the javadoc can be copied in
cd %SAMPLESRCROOT%\sample
call mvn javadoc:javadoc
move %SAMPLESRCROOT%\sample\target\site\apidocs %SAMPLESRCROOT%\sample\javadoc
call mvn clean


touch %ROOT%\c

cd %SAMPLESRCROOT%\..
%TAREXE% %TARCREATEARGS% %DISTROROOT%\apache-tuscany-sdo-sample-%RELEASE%-src.tar    tuscany-sdo-%RELEASE%
%GZIPEXE% %GZIPARGS%     %DISTROROOT%\apache-tuscany-sdo-sample-%RELEASE%-src.tar.gz %DISTROROOT%\apache-tuscany-sdo-sample-%RELEASE%-src.tar
del %DISTROROOT%\apache-tuscany-sdo-sample-%RELEASE%-src.tar
%ZIPEXE% %ZIPCREATEARGS% %DISTROROOT%\apache-tuscany-sdo-sample-%RELEASE%-src.zip    tuscany-sdo-%RELEASE%

touch %ROOT%\d

rem fix up the binary archives
cd %IMPLSRCROOT%\sdo\target
mkdir tmp
cd tmp
%ZIPEXE% x -r ..\tuscany-sdo-%RELEASE%-bin.zip
del tuscany-sdo-%RELEASE%\lib\asm-2.2.jar
del tuscany-sdo-%RELEASE%\lib\junit-3.8.1.jar                      
%ZIPEXE% %ZIPCREATEARGS% %DISTROROOT%\apache-tuscany-sdo-%RELEASE%-bin.zip .
%TAREXE% %TARCREATEARGS% %DISTROROOT%\apache-tuscany-sdo-%RELEASE%-bin.tar .
%GZIPEXE% %GZIPARGS%     %DISTROROOT%\apache-tuscany-sdo-%RELEASE%-bin.tar.gz %DISTROROOT%\apache-tuscany-sdo-%RELEASE%-bin.tar 
del %DISTROROOT%\apache-tuscany-sdo-%RELEASE%-bin.tar

touch %ROOT%\e


cd %DISTROROOT%

gpg -sa -bau %SIGNER% apache-tuscany-sdo-%RELEASE%-bin.tar.gz
gpg -sa -bau %SIGNER% apache-tuscany-sdo-%RELEASE%-bin.zip
gpg -sa -bau %SIGNER% apache-tuscany-sdo-api-%RELEASE%-src.tar.gz
gpg -sa -bau %SIGNER% apache-tuscany-sdo-api-%RELEASE%-src.zip
gpg -sa -bau %SIGNER% apache-tuscany-sdo-impl-%RELEASE%-src.tar.gz
gpg -sa -bau %SIGNER% apache-tuscany-sdo-impl-%RELEASE%-src.zip
gpg -sa -bau %SIGNER% apache-tuscany-sdo-sample-%RELEASE%-src.tar.gz
gpg -sa -bau %SIGNER% apache-tuscany-sdo-sample-%RELEASE%-src.zip


md5sums -u apache-tuscany-sdo-%RELEASE%-bin.tar.gz        > apache-tuscany-sdo-%RELEASE%-bin.tar.gz.md5   
md5sums -u apache-tuscany-sdo-%RELEASE%-bin.zip           > apache-tuscany-sdo-%RELEASE%-bin.zip.md5          
md5sums -u apache-tuscany-sdo-api-%RELEASE%-src.tar.gz    > apache-tuscany-sdo-api-%RELEASE%-src.tar.gz.md5   
md5sums -u apache-tuscany-sdo-api-%RELEASE%-src.zip       > apache-tuscany-sdo-api-%RELEASE%-src.zip.md5      
md5sums -u apache-tuscany-sdo-impl-%RELEASE%-src.tar.gz   > apache-tuscany-sdo-impl-%RELEASE%-src.tar.gz.md5  
md5sums -u apache-tuscany-sdo-impl-%RELEASE%-src.zip      > apache-tuscany-sdo-impl-%RELEASE%-src.zip.md5     
md5sums -u apache-tuscany-sdo-sample-%RELEASE%-src.tar.gz > apache-tuscany-sdo-sample-%RELEASE%-src.tar.gz.md5
md5sums -u apache-tuscany-sdo-sample-%RELEASE%-src.zip    > apache-tuscany-sdo-sample-%RELEASE%-src.zip.md5   


mkdir bin
move *-bin* bin
mkdir api
move *-api* api
mkdir impl
move *-impl* impl
mkdir sample
move *-sample* sample

%ZIPEXE% %ZIPCREATEARGS% %RELEASE_CANDIDATE%.zip .

cd %ROOT%

rem capturing the command to manually deploy files to a staging repository
rem C:\Documents and Settings\ibm_user\.m2\repository\org\apache\tuscany\sdo\tuscany-sdo-impl\1.0-incubating-beta1>mvn deploy:deploy-file -DgroupId=org.apache.tuscany.sdo -DartifactId=tuscany-sdo-impl -Dversion=1.0-incubating-beta1 -Dpackaging=jar -Dfile=tuscany-sdo-impl-1.0-incubating-beta1.jar -DrepositoryId=people.apache.org -Durl=scp://people.apache.org/home/kelvingoodson/public_html/repo -DgeneratePom=false -DpomFile=tuscany-sdo-impl-1.0-incubating-beta1.pom



