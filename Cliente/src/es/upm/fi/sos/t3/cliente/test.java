package es.upm.fi.sos.t3.cliente;

import java.io.IOException;
import java.rmi.RemoteException;

import es.upm.fi.sos.t3.cliente.UserManagementWSStub.*;

public class test {

	private static void Prueba1(UserManagementWSStub stub, Login login, User us1)
			throws RemoteException, IOException {
		System.out.println("\nPrueba 1: Login superUser");
		login.setArgs0(us1);
		boolean response = stub.login(login).get_return().localResponse;
		System.out.println(response);
		if (response == true) {
			System.out.println("Prueba SUPERADA");
		} else {
			System.out.println("Prueba FALLIDA");
		}
	}

	private static void Prueba2(UserManagementWSStub stub, User us,
			AddUser adduser) throws RemoteException, IOException {
		System.out.println("\nPrueba 2: Añadir usuario");
		adduser.setArgs0(us);
		if (stub.addUser(adduser).get_return().localResponse) {
			System.out.println("Prueba SUPERADA");
		} else {
			System.out.println("Prueba FALLIDA");
		}
	}

	private static void Prueba3(UserManagementWSStub stub, Login login, User us)
			throws RemoteException, IOException {
		System.out.println("\nPrueba 3: Loguear con otro usuario");
		login.setArgs0(us);
		if (!stub.login(login).get_return().localResponse) {
			System.out.println("Prueba SUPERADA");
		} else {
			System.out.println("Prueba FALLIDA");
		}
	}

	private static void Prueba4(UserManagementWSStub stub, Logout logout)
			throws RemoteException, IOException {
		System.out.println("\nPrueba 4: Desloguear");
		stub.logout(logout);
		System.out.println("Prueba SUPERADA");
	}

	private static void Prueba5(UserManagementWSStub stub, Login login, User us)
			throws RemoteException, IOException {
		System.out.println("\nPrueba 5: Login U2");
		login.setArgs0(us);
		if (stub.login(login).get_return().localResponse) {
			System.out.println("Prueba SUPERADA");
		} else {
			System.out.println("Prueba FALLIDA");
		}
	}

	private static void Prueba6(UserManagementWSStub stub,
			ChangePassword changePass, PasswordPair passwordPair)
			throws RemoteException, IOException {
		System.out.println("\nPrueba 6: Cambiar contraseña de U2");
		changePass.setArgs0(passwordPair);
		if (stub.changePassword(changePass).get_return().localResponse) {
			System.out.println("Prueba SUPERADA");
		} else {
			System.out.println("Prueba FALLIDA");
		}
	}

	private static void Prueba7(UserManagementWSStub stub, Login login,
			User us, Logout logout) throws IOException {
		System.out.println("\nPrueba 7: Loguear con contraseña antigua");
		stub.logout(logout);
		login.setArgs0(us);
		if (!stub.login(login).get_return().localResponse) {
			System.out.println("Prueba SUPERADA");
		} else {
			System.out.println("Prueba FALLIDA");
		}
	}

	private static void Prueba8(UserManagementWSStub stub, User us, Login login)
			throws IOException {
		System.out.println("\nPrueba 8: Loguearse con contraseña nueva");
		us.setPwd("12");
		login.setArgs0(us);
		if (stub.login(login).get_return().localResponse) {
			System.out.println("Prueba SUPERADA");
		} else {
			System.out.println("Prueba FALLIDA");
		}
	}

	private static void Prueba9(UserManagementWSStub stub,
			RemoveUser removeUser, Username username) throws IOException {
		System.out.println("\nPrueba 9: Eliminar usuario a si mismo");
		removeUser.setArgs0(username);
		if (stub.removeUser(removeUser).get_return().localResponse) {
			System.out.println("Prueba SUPERADA");
		} else {
			System.out.println("Prueba FALLIDA");
		}
	}

	private static void Prueba10(UserManagementWSStub stub, User us, Login login)
			throws IOException {
		System.out.println("\nPrueba 10: Loguearse con usuario borrado");
		login.setArgs0(us);
		if (!stub.login(login).get_return().localResponse) {
			System.out.println("Prueba SUPERADA");
		} else {
			System.out.println("Prueba FALLIDA");
		}
	}

	private static void Prueba11(UserManagementWSStub stub, User us, User us1,
			Login login, AddUser adduser, Logout logout, Course c,
			ShowCourses course) throws IOException {
		System.out.println("\nPrueba 11: Ver las asignaturas de 4º");
		login.setArgs0(us);
		stub.login(login);
		adduser.setArgs0(us1);
		stub.addUser(adduser);
		stub.logout(logout);
		login.setArgs0(us1);
		stub.login(login);
		course.setArgs0(c);
		if (stub.showCourses(course).get_return().getResult()) {
			stub.showCourses(course);
			System.out.println("Prueba SUPERADA");
		} else {
			System.out.println("Prueba FALLIDA");
		}
	}

	private static void Prueba12(UserManagementWSStub stub,
			AddCourseGrade courseGrade, CourseGrade n) throws IOException {
		System.out.println("\nPrueba 12: Meter nota en asignatura de 4º");
		courseGrade.setArgs0(n);
		if (stub.addCourseGrade(courseGrade).get_return().getResponse()) {
			System.out.println("Prueba SUPERADA");
		} else {
			System.out.println("Prueba FALLIDA");
		}
	}

	private static void Prueba13(UserManagementWSStub stub, CourseGrade n,
			AddCourseGrade courseGrade) throws IOException {
		System.out.println("\nPrueba 13: Meter otra nota en asignatura de 4º");
		courseGrade.setArgs0(n);
		if (stub.addCourseGrade(courseGrade).get_return().getResponse()) {
			System.out.println("Prueba SUPERADA");
		} else {
			System.out.println("Prueba FALLIDA");
		}
	}

	private static void Prueba14(UserManagementWSStub stub,
			AddCourseGrade courseGrade, CourseGrade n) throws IOException {
		System.out.println("\nPrueba 14: Intenar meter nota fuera del rango");
		courseGrade.setArgs0(n);
		if (!stub.addCourseGrade(courseGrade).get_return().getResponse()) {
			System.out.println("Prueba SUPERADA");
		} else {
			System.out.println("Prueba FALLIDA");
		}
	}

	private static void Prueba15(UserManagementWSStub stub,
			AddCourseGrade courseGrade, CourseGrade n) throws IOException {
		System.out
				.println("\nPrueba 15: Intenar meter nota en asignatura que no existe");
		courseGrade.setArgs0(n);
		if (!stub.addCourseGrade(courseGrade).get_return().getResponse()) {
			System.out.println("Prueba SUPERADA");
		} else {
			System.out.println("Prueba FALLIDA");
		}
	}

	private static void Prueba16(UserManagementWSStub stub,
			ShowAllGrades showAllGrades) throws IOException {
		System.out.println("\nPrueba 16: Ver notas");
		if (stub.showAllGrades(showAllGrades).get_return().getResult()) {
			stub.showAllGrades(showAllGrades);
			stub.showAllGrades(showAllGrades);
			System.out.println("Prueba SUPERADA");
		} else {
			System.out.println("Prueba FALLIDA");
		}
	}

	private static void Prueba17(UserManagementWSStub stub,
			AddCourseGrade courseGrade, ShowAllGrades showAllGrades,
			CourseGrade n) throws IOException {
		System.out
				.println("\nPrueba 17: Meter nota intermedia para ver que se ordena de mayor a menor");
		courseGrade.setArgs0(n);
		stub.addCourseGrade(courseGrade);
		if (stub.showAllGrades(showAllGrades).get_return().getResult()) {
			stub.showAllGrades(showAllGrades);
			stub.showAllGrades(showAllGrades);
			System.out.println("Prueba SUPERADA");
		} else {
			System.out.println("Prueba FALLIDA");
		}
	}

	public static void main(String[] args) throws Exception {

		UserManagementWSStub stub = new UserManagementWSStub();
		stub._getServiceClient().engageModule("addressing");
		stub._getServiceClient().getOptions().setManageSession(true);

		User arturo = new User();
		arturo.setName("arturo");
		arturo.setPwd("123456");

		User quique = new User();
		quique.setName("enrique");
		quique.setPwd("123123");

		PasswordPair passwordPair1 = new PasswordPair();
		passwordPair1.setOldpwd("admin");
		passwordPair1.setNewpwd("adminnueva");

		PasswordPair passwordPair2 = new PasswordPair();
		passwordPair2.setOldpwd("hola");
		passwordPair2.setNewpwd("12");

		Username username1 = new Username();
		username1.setUsername("loren");
		Username username2 = new Username();
		username2.setUsername("arturo");
		Course c1 = new Course();
		c1.setCourse(1);
		Course c2 = new Course();
		c2.setCourse(2);
		Course c3 = new Course();
		c3.setCourse(3);
		Course c4 = new Course();
		c4.setCourse(4);
		CourseGrade n1 = new CourseGrade();
		n1.setGrade(8.50);
		n1.setCourse("SISTEMAS DINÁMICOS, CAOS Y FRACTALES");
		CourseGrade n2 = new CourseGrade();
		n2.setGrade(4.50);
		n2.setCourse("ROBÓTICA Y PERCEPCIÓN COMPUTACIONAL");
		CourseGrade n3 = new CourseGrade();
		n3.setGrade(14.50);
		n3.setCourse("SISTEMAS DINÁMICOS, CAOS Y FRACTALES");
		CourseGrade n4 = new CourseGrade();
		n4.setGrade(6.50);
		n4.setCourse("ROBÓTICA");
		CourseGrade n5 = new CourseGrade();
		n5.setGrade(6.50);
		n5.setCourse("SISTEMAS ORIENTADOS A SERVICIOS");
		Login login1 = new Login();
		AddUser adduser1 = new AddUser();
		Logout logout = new Logout();
		ChangePassword changePass1 = new ChangePassword();
		RemoveUser removeUser1 = new RemoveUser();
		ShowCourses course1 = new ShowCourses();
		AddCourseGrade courseGrade1 = new AddCourseGrade();
		ShowAllGrades showAllGrades1 = new ShowAllGrades();

		User admin = new User();
		admin.setName("admin");
		admin.setPwd("admin");
		Prueba1(stub, login1, admin);

		User loren = new User();
		loren.setName("loren");
		loren.setPwd("hola");
		Prueba2(stub, loren, adduser1);
		Prueba3(stub, login1, loren);
		Prueba4(stub, logout);

		Prueba5(stub, login1, loren);
		Prueba6(stub, changePass1, passwordPair2);
		Prueba7(stub, login1, loren, logout);
		loren.setPwd("12");
		Prueba8(stub, loren, login1);
		Prueba9(stub, removeUser1, username1);
		Prueba10(stub, loren, login1);
		Prueba11(stub, admin, arturo, login1, adduser1, logout, c4, course1);
		Prueba12(stub, courseGrade1, n1);
		Prueba13(stub, n2, courseGrade1);
		Prueba14(stub, courseGrade1, n3);
		Prueba15(stub, courseGrade1, n4);
		Prueba16(stub, showAllGrades1);
		Prueba17(stub, courseGrade1, showAllGrades1, n5);
	}

}
