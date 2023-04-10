public interface ILights { // используется, когда нужно описать небольшое действие;
						   // интерфейс содержит просто набор методов, которые можно реализовать.
						   // почти как абстрактный класс;
						   // также здесь можно описывать константы; НО ТОЛЬКО КОНСТАНТЫ ИЗ ПЕРЕМЕННЫХ;

	void SetLight(boolean set);
	void BlinkLight();
}