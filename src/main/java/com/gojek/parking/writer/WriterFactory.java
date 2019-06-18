package com.gojek.parking.writer;

public class WriterFactory {

	private static final WriterFactory INSTANCE = new WriterFactory();

	public static WriterFactory getInstance() {
		return INSTANCE;
	}

	public Writer getWriter(WriterType type) {
		if (WriterType.CONSOLE == type) {
			return new ConsoleWriter();
		}
		return null;
	}
}
