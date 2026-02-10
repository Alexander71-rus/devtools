package ru.mentee.power.devtools.progress;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тестирование ProgressTracker")
class ProgressLoopTest {

    @Test
    @DisplayName("Должен корректно вычислить суммарный прогресс когда передан массив mentee")
    void shouldCalculateTotalProgress_whenMultipleMentees() {
        // given - подготовка данных
        ru.mentee.power.devtools.progress.ProgressTracker tracker = new ru.mentee.power.devtools.progress.ProgressTracker();
        ru.mentee.power.devtools.progress.Mentee[] mentees = {
                new ru.mentee.power.devtools.progress.Mentee("Иван", "Москва", "Backend разработка", 5, 12),
                new ru.mentee.power.devtools.progress.Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
                new ru.mentee.power.devtools.progress.Mentee("Пётр", "Казань", "Java Backend", 12, 12)
        };

        // when - выполнение действия
        String result = tracker.calculateTotalProgress(mentees);

        // then - проверка результата с assertJ
        assertThat(result)
                .contains("пройдено 25 из 36 уроков")
                .contains("осталось 11 уроков");
    }

    @Test
    @DisplayName("Должен корректно обработать массив когда все mentee завершили курс")
    void shouldCalculateTotalProgress_whenAllMenteesCompleted() {
        // given
        ru.mentee.power.devtools.progress.ProgressTracker tracker = new ru.mentee.power.devtools.progress.ProgressTracker();
        ru.mentee.power.devtools.progress.Mentee[] mentees = {
                new ru.mentee.power.devtools.progress.Mentee("Иван", "Москва", "Backend", 12, 12),
                new ru.mentee.power.devtools.progress.Mentee("Мария", "СПб", "Fullstack", 12, 12)
        };

        // when
        String result = tracker.calculateTotalProgress(mentees);

        // then
        assertThat(result)
                .contains("пройдено 24 из 24 уроков")
                .contains("осталось 0 уроков");
    }
}
