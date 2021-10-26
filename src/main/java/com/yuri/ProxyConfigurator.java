package com.yuri;

public interface ProxyConfigurator {
    Object replaceProxyIfNeeded(Object t, Class implClass);
}
