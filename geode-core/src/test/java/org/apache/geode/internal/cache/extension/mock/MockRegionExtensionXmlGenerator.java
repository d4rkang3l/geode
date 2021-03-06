/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.apache.geode.internal.cache.extension.mock;

import static org.apache.geode.internal.cache.extension.mock.MockExtensionXmlParser.*;
import static org.apache.geode.internal.cache.xmlcache.XmlGeneratorUtils.*;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import org.apache.geode.cache.Region;
import org.apache.geode.internal.cache.xmlcache.CacheXmlGenerator;
import org.apache.geode.internal.cache.xmlcache.XmlGenerator;

/**
 * {@link MockRegionExtension} {@link XmlGenerator}.
 * 
 *
 * @since GemFire 8.1
 */
public final class MockRegionExtensionXmlGenerator
    extends AbstractMockExtensionXmlGenerator<Region<?, ?>> {
  public MockRegionExtensionXmlGenerator(MockRegionExtension extension) {
    super(extension);
  }

  @Override
  public void generate(CacheXmlGenerator cacheXmlGenerator) throws SAXException {
    final ContentHandler handler = cacheXmlGenerator.getContentHandler();

    try {
      handler.startPrefixMapping(PREFIX, NAMESPACE);

      final AttributesImpl atts = new AttributesImpl();
      addAttribute(atts, ATTRIBUTE_VALUE, extension.getValue());
      emptyElement(handler, PREFIX, ELEMENT_REGION, atts);
    } finally {
      handler.endPrefixMapping(PREFIX);
    }
  }
}
