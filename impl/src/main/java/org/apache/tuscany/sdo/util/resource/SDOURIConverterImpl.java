/**
 *
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.tuscany.sdo.util.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.URIConverterImpl;

public class SDOURIConverterImpl extends URIConverterImpl {
    /**
     * Disable going out to the wire.
     */
    protected InputStream createURLInputStream(URI uri) throws IOException {
        String scheme = uri.scheme();
        if ("http".equals(scheme) || "https".equals(scheme)) {
            // TUSCANY 2240: We need to compromise if the remote loading is allowed or not
            String ext = uri.fileExtension();
            if (!"wsdl".equalsIgnoreCase(ext) && !"xsd".equalsIgnoreCase(ext)) {
                throw new Resource.IOWrappedException(new RuntimeException("Reading remote URL not supported: " + uri));
            }
        }
        return super.createURLInputStream(uri);
    }

    /**
     * Disable going out to the wire.
     */
    protected OutputStream createURLOutputStream(URI uri) throws IOException {
        String scheme = uri.scheme();
        if ("http".equals(scheme) || "https".equals(scheme)) {
            // TUSCANY 2240: We need to compromise if the remote loading is allowed or not
            String ext = uri.fileExtension();
            if (!"wsdl".equalsIgnoreCase(ext) && !"xsd".equalsIgnoreCase(ext)) {
                throw new Resource.IOWrappedException(new RuntimeException("Reading remote URL not supported: " + uri));
            }
        }
        return super.createURLOutputStream(uri);
    }
}
