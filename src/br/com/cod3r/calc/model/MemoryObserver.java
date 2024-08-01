package br.com.cod3r.calc.model;

@FunctionalInterface
public interface MemoryObserver {

	void changedValue(String newValue);
	
}
