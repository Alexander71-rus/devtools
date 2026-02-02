package ru.mentee.power;

public class ProgressDemo {
    public static void main(String[] args) {
        // Создаем объект с ТОЧНО такими же данными
        var progress = new ru.mentee.power.MenteeProgress(
                "Имя студента", // < ТОЧНО "Имя студента" (как в примере)
                0, // номер спринта 1
                6 // запланированные часы 6
        );

        // Вывод ТОЧНО как в примере
        System.out.println(progress.summary());

        // Проверяем готовность и выводим статус
        if (progress.readyForSprint()) {
            System.out.println("Status: sprint ready");
        } else {
            System.out.println("Status: backlog first");
        }
    }
}