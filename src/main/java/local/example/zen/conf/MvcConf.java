/**
 *
 * Copyright 2019 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.zen.conf;

import freemarker.template.TemplateException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;

@Configuration
public class MvcConf
        implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        var freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setCache(true);
        freeMarkerViewResolver.setPrefix("");
        freeMarkerViewResolver.setSuffix(".ftl ");
        freeMarkerViewResolver.setContentType("text/html; charset=utf-8");
        return freeMarkerViewResolver;
    }

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() throws IOException {
        var freeMarkerConfigurationFactory = new FreeMarkerConfigurationFactory();
        freeMarkerConfigurationFactory.setTemplateLoaderPaths("classpath:templates", "src/main/resources/templates");
        freeMarkerConfigurationFactory.setDefaultEncoding("utf-8");
        var freeMarkerConfigurer = new FreeMarkerConfigurer();
        try {
            freeMarkerConfigurer.setConfiguration(freeMarkerConfigurationFactory.createConfiguration());
        } catch (TemplateException templateException) {
            templateException.getMessage();
        }
        return freeMarkerConfigurer;
    }
}
