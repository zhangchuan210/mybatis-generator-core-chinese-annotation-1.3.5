/**
 * Copyright 2006-2016 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mybatis.generator.config;

import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

/**
 *
 * @author Jeff Butler
 *
 */
public class PluginConfiguration extends TypedPropertyHolder {
    public PluginConfiguration() {
    }

    public XmlElement toXmlElement() {
        XmlElement answer = new XmlElement("plugin"); //$NON-NLS-1$
        if (getConfigurationType() != null) {
            answer.addAttribute(new Attribute("type", getConfigurationType())); //$NON-NLS-1$
        }

        addPropertyXmlElements(answer);

        return answer;
    }

    public void validate(List<String> errors, String contextId) {
        if (!stringHasValue(getConfigurationType())) {
            errors.add(getString("ValidationError.17", //$NON-NLS-1$
                    contextId));
        }
    }
}
