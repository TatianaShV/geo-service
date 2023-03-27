package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
    LocalizationService localizationService;

    @BeforeEach
    void setUp() {
        localizationService = new LocalizationServiceImpl();
    }

    @Test
    void localeRussianText() {
        String result = localizationService.locale(Country.RUSSIA);
        String expected = "Добро пожаловать";
        Assertions.assertEquals(result, expected);
    }
    @Test
    void localeNotRussianTextBrazil() {
        String result = localizationService.locale(Country.BRAZIL);
        String expected = "Welcome";
        Assertions.assertEquals(result, expected);

    } @Test
    void localeNotRussianTextUSA() {
        String result = localizationService.locale(Country.USA);
        String expected = "Welcome";
        Assertions.assertEquals(result, expected);

    }@Test
    void localeNotRussianTextGermany() {
        String result = localizationService.locale(Country.GERMANY);
        String expected = "Welcome";
        Assertions.assertEquals(result, expected);

    }
}