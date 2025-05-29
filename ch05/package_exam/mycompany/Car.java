package ch05.package_exam.mycompany;

import ch05.package_exam.hankook.*;
import ch05.package_exam.hankook.Tire;
import ch05.package_exam.hyundai.Engine;
import ch05.package_exam.kumho.*;

public class Car {
	Tire tire1 = new Tire(); // 한국타이어
	SnowTire tire2 = new SnowTire(); // 한국 스노우타이어
	Engine engine1 = new Engine(); // 현대 엔진
	BigWidthTire tire3 = new BigWidthTire(); // 금호 빅폭타이어
	ch05.package_exam.kumho.Tire tire4 = new ch05.package_exam.kumho.Tire(); // 금호 타이어
	ch05.package_exam.kia.Engine engine2 = new ch05.package_exam.kia.Engine(); // 기아 엔진
	SportsTire tire5 = new SportsTire(); // 금호 스포츠타이어

}
