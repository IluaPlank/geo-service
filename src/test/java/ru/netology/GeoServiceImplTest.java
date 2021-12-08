package ru.netology;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {
    GeoService sut;

    @BeforeEach
    public void init() {
        sut = new GeoServiceImpl();
        System.out.println("Начало тестирования");
    }

    @BeforeAll
    public static void started() {
        System.out.println("Начало теста");
    }

    @AfterEach
    public void finished() {
        System.out.println("\nКонец теста");
    }

    @AfterAll
    public static void finshedAll() {
        System.out.println("Окончания тестирования");
    }

    @ParameterizedTest
    @MethodSource("source")
    void testByIp(String ip , Country country) {
        //assert
        Assertions.assertEquals(country,sut.byIp(ip).getCountry());
    }
    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of("96.44.183.149",Country.USA),
                Arguments.of("172.0.32.11",Country.RUSSIA)
        );
    }
}