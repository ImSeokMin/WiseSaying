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
            } else if (cmd.startsWith("삭제")) {
                actionDelete(cmd);
            } else if (cmd.startsWith("수정")) {
                actionModify(cmd);
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

    void actionDelete(String cmd) {

        int idToDelete = parseIdCommand(cmd);

        if (idToDelete == -1) {
            return;
        }

        WiseSaying foundWiseSaying = findWiseSayingById(idToDelete);

        if (foundWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", idToDelete);
            return;
        }

        wiseSayings.removeIf(ws -> ws.getId() == idToDelete);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", idToDelete);
    }

    void actionModify(String cmd) {

        int idToModify = parseIdCommand(cmd);

        if (idToModify == -1) {
            return;
        }

        WiseSaying foundWiseSaying = findWiseSayingById(idToModify);

        if (foundWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", idToModify);
            return;
        }

        System.out.printf("명언(기존) : %s\n", foundWiseSaying.getContent());
        System.out.print("명언 : ");
        String newContent = scanner.nextLine().trim();

        System.out.printf("작가(기존) : %s\n", foundWiseSaying.getAuthor());
        System.out.print("작가 : ");
        String newAuthor = scanner.nextLine().trim();

        foundWiseSaying.setContent(newContent);
        foundWiseSaying.setAuthor(newAuthor);
    }

    WiseSaying findWiseSayingById(int id) {
        for (WiseSaying ws : wiseSayings) {
            if (ws.getId() == id) {
                return ws;
            }
        }
        return null;
    }

    private int parseIdCommand(String cmd) {
        String[] cmdParts = cmd.split("\\?id=", 2);

        if (cmdParts.length < 2) {
            System.out.println("id를 입력해주세요.");
            return -1;
        }

        if (cmdParts[1] == null) {
            System.out.println("id 값이 유효하지 않습니다.");
            return -1;
        }

        int parsedId;
        try {
            parsedId = Integer.parseInt(cmdParts[1]);
        } catch (NumberFormatException e) {
            System.out.println("id는 정수로 입력해주세요.");
            return -1;
        }

        return parsedId;
    }
}
