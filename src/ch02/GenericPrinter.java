package ch02;

public class GenericPrinter<T> {

	// T 라는 대체 문자를 사용, E - element, K - key, V - value (사실은 아무 문자나 가능하기는 하다.)
	// 자료형 매개변수(type parameter)
	// 이 클래스를 사용하는 시점에서 실제 사용 될 자료형이 결정된다.
	
	private T material; // T 대체 문자형으로 변수를 선언 (type parameter)
	
	
	// get, set
	public T getMaterial() {
		return material;
	}
	
	public void setMaterial(T material) {
		this.material = material;
	}
	
	// GenericPrinter<T>의 참조변수를 sysout(참조변수)를 찍으면, 나의 멤버 material에 toString()설계함.
	@Override
	public String toString() {
		return material.toString();
	}
	
}
