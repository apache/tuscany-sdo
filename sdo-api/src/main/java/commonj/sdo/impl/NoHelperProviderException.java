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

package commonj.sdo.impl;

/**
 * Exception indicating that a HelperProvider could not be located or instantiated.
 * The message will be set to the name of the implementation class; a null value
 * indicates that the name of the implementation could not be determined.
 * The cause will be set to the Throwable that prevented the provider from being
 * located or created.
 *
 * @version $Revision$ $Date$
 */
public class NoHelperProviderException extends RuntimeException {
    private static final long serialVersionUID = 727646133930924084L;

    public NoHelperProviderException() {
    }

    public NoHelperProviderException(String message) {
        super(message);
    }

    public NoHelperProviderException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoHelperProviderException(Throwable cause) {
        super(cause);
    }

    /**
     * Return the name of the implementation class that could not be provided.
     *
     * @return the name of the implementation class; may be null if not known
     */
    public String getImplementationName() {
        return getMessage();
    }
}
