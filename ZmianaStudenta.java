import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZmianaStudenta {
    private List<Student> studenci = new ArrayList<>();

    public void dodajStudenta(Student student) {
        studenci.add(student);
    }

    public void usunStudenta(int id) {
        studenci.removeIf(student -> student.getId() == id);
    }

    public void edytujStudenta(int id, String nazwisko, int wiek, String imie) {
        for (Student student : studenci) {
            if (student.getId() == id) {
                student.setImie(imie);
                student.setNazwisko(nazwisko);
                student.setWiek(wiek);
                break;
            }
        }
    }

    public void wyswietlStudentow() {
        for (Student student : studenci) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        ZmianaStudenta manager = new ZmianaStudenta();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Witamy, co chciałbyś zrobić?");
            System.out.println("1. Dodać studenta");
            System.out.println("2. Usunąć studenta");
            System.out.println("3. Edytowac dane o studencie");
            System.out.println("4. Wyświetlić studentów");
            System.out.println("5. Wyjść");

            int wybor = scanner.nextInt();
            scanner.nextLine();
            switch (wybor) {
                case 1:
                    System.out.println("Podaj id studenta:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Podaj imię studenta:");
                    String imie = scanner.nextLine();
                    System.out.println("Podaj nazwisko studenta:");
                    String nazwisko = scanner.nextLine();
                    System.out.println("Podaj wiek studenta:");
                    int wiek = scanner.nextInt();
                    scanner.nextLine();
                    manager.dodajStudenta(new Student(id, nazwisko, wiek, imie));
                    break;
                case 2:
                    System.out.println("Podaj id studenta którego chciałbyś usunąć:");
                    int idUsun = scanner.nextInt();
                    scanner.nextLine();
                    manager.usunStudenta(idUsun);
                    break;
                case 3:
                    System.out.println("Podaj id studenta do edycji:");
                    int idEdytuj = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Podaj nowe imię:");
                    String noweImie = scanner.nextLine();
                    System.out.println("Podaj nowe nazwisko:");
                    String noweNazwisko = scanner.nextLine();
                    System.out.println("Podaj nowy wiek:");
                    int nowyWiek = scanner.nextInt();
                    scanner.nextLine();
                    manager.edytujStudenta(idEdytuj, noweNazwisko, nowyWiek, noweImie);
                    break;
                case 4:
                    System.out.println("Wszyscy studenci:");
                    manager.wyswietlStudentow();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Wybierz od 1-5, tyle ile na jednej ręce.");
                    break;
            }
        }

        scanner.close();
    }
}
