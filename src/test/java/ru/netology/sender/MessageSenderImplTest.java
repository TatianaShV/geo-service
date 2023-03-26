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
import static org.mockito.Matchers.anyString;

class MessageSenderImplTest {

    MessageSender messageSender;
   LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
   GeoService geoService = Mockito.mock(GeoService.class);

//LocalizationService localizationService = new LocalizationServiceImpl();
//GeoService geoService = new GeoServiceImpl();


    ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

    @BeforeEach
    void setUp() {
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }

    @Test
    void send() {
      /*  Mockito.when(MessageSenderImpl.IP_ADDRESS_HEADER).thenReturn("172.123.12.19");
        String result = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals(result,);
        *//*Map<String, String> headers = new HashMap<String, String>();
        headers.put();*/
    }

    @Test
    void sendLanguageRussian() {
        /*Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");*/
       /* Mockito.when(geoService.byIp(anyString()))
                .thenReturn (new Location("Moscow", Country.RUSSIA, null, 0));*/
        String expected = localizationService.locale(geoService.byIp("172.123.12.19").getCountry());

        String result = localizationService.locale(Country.RUSSIA);

        Assertions.assertEquals(expected, result);
    }

}