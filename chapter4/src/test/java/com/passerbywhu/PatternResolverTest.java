package com.passerbywhu;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertNotNull;

public class PatternResolverTest {
    @Test
    public void getResources() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resources[] = resolver.getResources("classpath*:com/passerbywhu/**/*.xml");
        assertNotNull(resources);
        System.out.println("resources num " + resources.length);
        for(Resource resource : resources) {
            System.out.println(resource.getDescription());
        }
    }
}
