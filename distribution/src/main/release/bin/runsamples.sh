#  Licensed to the Apache Software Foundation (ASF) under one
#  or more contributor license agreements.  See the NOTICE file
#  distributed with this work for additional information
#  regarding copyright ownership.  The ASF licenses this file
#  to you under the Apache License, Version 2.0 (the
#  "License"); you may not use this file except in compliance
#  with the License.  You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing,
#  software distributed under the License is distributed on an
#  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
#  KIND, either express or implied.  See the License for the
#  specific language governing permissions and limitations
#  under the License.

export BINARY_BASE=change this value to be a valid path to your binary distribution root
export RELEASE=${sdo.version}
export LIB=$BINARY_BASE/lib
export CLASSPATH=$LIB/sample-sdo-$RELEASE.jar;$LIB/tuscany-sdo-api-r2.1-$RELEASE.jar;$LIB/tuscany-sdo-lib-$RELEASE.jar;$LIB/tuscany-sdo-impl-$RELEASE.jar;$LIB/tuscany-sdo-tools-$RELEASE.jar;$LIB/codegen-ecore-2.2.3.jar;$LIB/codegen-2.2.3.jar;$LIB/ecore-2.2.3.jar;$LIB/ecore-change-2.2.3.jar;$LIB/ecore-xmi-2.2.3.jar;$LIB/common-2.2.3.jar;$LIB/xsd-2.2.3.jar;$LIB/stax-api-1.0.1.jar
java org.apache.tuscany.samples.sdo.ExecuteSamples