package com.kakaruto.test.calcTest;

public interface LineCallback<T> {
	T doSomethingWithLine(String line, T value);
}
