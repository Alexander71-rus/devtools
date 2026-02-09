package ru.mentee.power.devtools.progress;

public class ProgressTracker {

    /**
     * Вычисляет суммарный прогресс группы mentee.
     *
     * @param mentees массив mentee
     * @return строка с информацией о суммарном прогрессе (пройдено/осталось уроков)
     */
    public String calculateTotalProgress(ru.mentee.power.devtools.progress.Mentee[] mentees) {
        // 1. Проверить валидность массива (null, пустой)
        if (mentees == null || mentees.length == 0) {
            return "Нет данных о mentee для расчёта прогресса";
        }

        // 2. Инициализировать аккумуляторы: totalCompleted = 0, totalTotal = 0, index = 0
        int totalCompleted = 0;
        int totalTotal = 0;
        int index = 0;

        // 3. Использовать цикл while (index < mentees.length) для перебора массива
        while (index < mentees.length) {
            // 4. На каждой итерации:
            // totalCompleted += mentees[index].completedLessons(),
            // totalTotal += mentees[index].totalLessons(),
            // index++
            totalCompleted += mentees[index].completedLessons();
            totalTotal += mentees[index].totalLessons();
            index++;
        }

        // 5. Вычислить оставшиеся: totalRemaining = totalTotal - totalCompleted
        int totalRemaining = totalTotal - totalCompleted;

        // 6. Вернуть строку формата: "Суммарно: пройдено X из Y уроков, осталось Z уроков"
        return String.format(
                "Суммарно: пройдено %d из %d уроков, осталось %d уроков",
                totalCompleted, totalTotal, totalRemaining
        );
    }

    public static void main(String[] args) {
        ProgressTracker tracker = new ProgressTracker();

        // Создаём массив mentee (продолжение DVT-2: добавляем прогресс к личной карточке)
        ru.mentee.power.devtools.progress.Mentee[] mentees = {
                new ru.mentee.power.devtools.progress.Mentee("Иван", "Москва", "Backend разработка", 5, 12),
                new ru.mentee.power.devtools.progress.Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
                new ru.mentee.power.devtools.progress.Mentee("Пётр", "Казань", "Java Backend", 12, 12)
        };

        String progress = tracker.calculateTotalProgress(mentees);
        System.out.println(progress);
    }
}