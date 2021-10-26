package com.yuri;

import com.yuri.service.announcer.InjectProperty;
import org.junit.Assert;
import org.junit.Test;

public class InjectionTest {
    class A {
        @InjectProperty(value = "whiskey")
        String field;
    }

    @Test
    public void shouldTestInjectProperty() {
        InjectPropertyAnnotationObjectConfigurator configurator = new InjectPropertyAnnotationObjectConfigurator();
        A a = new A();
        configurator.configure(a, null);
        Assert.assertEquals("singleton", a.field);
    }
}
