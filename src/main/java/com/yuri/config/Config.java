package com.yuri.config;

public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> ifc);

    org.reflections.Reflections getScanner();
}
