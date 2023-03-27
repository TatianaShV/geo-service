package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;


class MessageSenderImplTest {

    MessageSender messageSender;
      LocalizationService localizationService = new LocalizationServiceImpl();
    GeoService geoService = new GeoServiceImpl();

    @BeforeEach
    void setUp() {
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }

    @Test
    void sendLanguageRussian() {

        String expected = localizationService.locale(geoService.byIp("172.123.12.19").getCountry());
        String result = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void sendLanguageNotRussian() {
        String expected = localizationService.locale(geoService.byIp("96.123.12.19").getCountry());
        String result = localizationService.locale(Country.USA);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void sendLanguageMockito() {
        String ip = "96.15.145.45";
        LocalizationService localizationService = new LocalizationServiceImpl();
        GeoService geoService = Mockito.spy(GeoServiceImpl.class);
        messageSender = new MessageSenderImpl(geoService, localizationService);

        String result = localizationService.locale(geoService.byIp(ip).getCountry());
        Mockito.when(geoService.byIp(anyString()))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        String expected = localizationService.locale(geoService.byIp(anyString()).getCountry());
        Mockito.verify(geoService, Mockito.times(2)).byIp(anyString());
        Assertions.assertNotEquals(result, expected);
    }

}

