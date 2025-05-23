package com.back;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");


        Scanner scanner = new Scanner(System.in);

        int wise_saying_count = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<String> contents = new ArrayList<>();
        ArrayList<String> authors = new ArrayList<>();

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String wise_saying_content = scanner.nextLine().trim();

                System.out.print("작가 : ");
                String wise_saying_author = scanner.nextLine().trim();

                wise_saying_count++;
                numbers.add(wise_saying_count);
                contents.add(wise_saying_content);
                authors.add(wise_saying_author);

                System.out.printf("%d번 명언이 등록되었습니다.\n", wise_saying_count);
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = numbers.size() - 1; i >= 0; i--) {
                    System.out.printf("%d / %s / %s\n", numbers.get(i), authors.get(i), contents.get(i));
                }
            }
        }
        scanner.close();
    }
}