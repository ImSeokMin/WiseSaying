package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    Scanner scanner = new Scanner(System.in);

    int WiseSayingLastId = 0;
    List<WiseSaying> wiseSayings = new ArrayList<>();

    void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionWrite();
            } else if (cmd.equals("목록")) {
                actionList();
            }
        }
        scanner.close();
    }

    void actionWrite() {
        System.out.print("명언 : ");
        String WiseSayingContent = scanner.nextLine().trim();

        System.out.print("작가 : ");
        String WiseSayingAuthor = scanner.nextLine().trim();

        WiseSayingLastId++;
        WiseSaying newWiseSaying = new WiseSaying(WiseSayingLastId, WiseSayingContent, WiseSayingAuthor);
        wiseSayings.add(newWiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", WiseSayingLastId);
    }

    void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
        }
    }

}
