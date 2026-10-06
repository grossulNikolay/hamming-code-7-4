import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВведите Ваше сообщение (7 символов, бинарная запись): ");
            String input = scanner.nextLine();

            if (input.length() != 7) {
                System.out.println("\nВаше число должно содержать строго 7 символов.");
                continue;
            }

            boolean error = false;
            int index = input.length() - 1;
            while (index >= 0) {
                char ch = input.charAt(index);
                if (ch != '0' && ch != '1') {
                    error = true;
                    break;
                }
                index--;
            }

            if (error) {
                System.out.println("\nИзвините, работаю только с бинарными числами (бит = 0 или 1).");
                continue;
            }

            System.out.println("\nВведённое сообщение корректно!");

            int r1 = input.charAt(0) - '0'; //метод возвращает не значение бита 0|1, а ASCII-код. '0'=48, '1'=49
            int r2 = input.charAt(1) - '0'; //поэтому 49-48=1, 48-48=0
            int i1 = input.charAt(2) - '0';
            int r3 = input.charAt(3) - '0';
            int i2 = input.charAt(4) - '0';
            int i3 = input.charAt(5) - '0';
            int i4 = input.charAt(6) - '0';
            int s1 = 0;
            int s2 = 0;
            int s3 = 0;

            s1 = r1 ^ i1 ^ i2 ^ i4;
            s2 = r2 ^ i1 ^ i3 ^ i4;
            s3 = r3 ^ i2 ^ i3 ^ i4;

            if (s1 != 0 || s2 != 0 || s3 != 0) {
                int errorBit = s3*4 + s2*2 + s1;
                System.out.println("\nОшибка в " + errorBit + " бите.");

                switch (errorBit) {
                    case 1: r1 ^= 1; break;
                    case 2: r2 ^= 1; break;
                    case 3: i1 ^= 1; break;
                    case 4: r3 ^= 1; break;
                    case 5: i2 ^= 1; break;
                    case 6: i3 ^= 1; break;
                    case 7: i4 ^= 1; break;
                }
                System.out.println("\nПравильное сообщение (только информационные биты): " + i1 + i2 + i3 + i4);
            } else {
                System.out.println("\nСообщение " + input + " без ошибок! Только информационные биты: "
                        + i1 + i2 + i3 + i4);
            }

            while (true) {
                System.out.println("\nХотите проверить другое сообщение? (y/n):");
                String reload = scanner.nextLine();

                if (reload.equalsIgnoreCase("n") || reload.equalsIgnoreCase("н")) {
                    System.out.println("\nЛадно... До свидания!");
                    return; //окончание программы
                } else if (reload.equalsIgnoreCase("y") || reload.equalsIgnoreCase("д")) {
                    System.out.println("\nХорошо!");
                    break; //перезапуск программы
                } else {
                    System.out.println("\nПожалуйста, введите 'y' ('д') или 'n' ('н'). Я не понимаю другие символы :(");
                } //цикл начинается с начала, пока в консоль не введут 'y'|'n'
            }
        }
    }
}
