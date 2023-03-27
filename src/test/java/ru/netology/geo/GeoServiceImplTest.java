package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.mockito.ArgumentMatchers.anyString;


class GeoServiceImplTest {
    GeoService geoService = Mockito.spy(GeoServiceImpl.class);

    @Test
    void byIpRussiaMockito() {
        String ip = "172.";
        Location expected = geoService.byIp(ip);
        Mockito.when(geoService.byIp(anyString()))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        Location result = geoService.byIp(anyString());
        Mockito.verify(geoService, Mockito.times(2)).byIp(anyString());
        Assertions.assertEquals(result.getCountry(), expected.getCountry());

    }

    @Test
    void byIpUSAMockito() {
        String ip = "96.25.54.12";
        Location expected = geoService.byIp(ip);
        Mockito.when(geoService.byIp(anyString()))
                .thenReturn(new Location("New York", Country.USA, null, 0));
        Location result = geoService.byIp(anyString());
        Mockito.verify(geoService, Mockito.times(2)).byIp(anyString());
        Assertions.assertEquals(result.getCountry(), expected.getCountry());

    }

    @Test
    void byIpRussia() {
        Location result = geoService.byIp("172.25.79.48");
        Location expected = new Location("Moscow", Country.RUSSIA, null, 0);
        Assertions.assertEquals(result.getCountry(), expected.getCountry());
    }

    @Test
    void byIpUSA() {
        Location result = geoService.byIp("96.0.0.12");
        Location expected = new Location("New York", Country.USA, null, 0);
        Assertions.assertEquals(result.getCountry(), expected.getCountry());
    }

    @Test
    void byIpMoscow() {
        Location result = geoService.byIp(GeoServiceImpl.MOSCOW_IP);
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Assertions.assertEquals(result.getCity(), expected.getCity());
    }
}