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
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
    LocalizationService sut;

    @BeforeEach
    public void init() {
        sut = new LocalizationServiceImpl();
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
    @Test
    public void locateTest(){
        //act
        String text = sut.locale(Country.RUSSIA);
        //assert
        Assertions.assertEquals("Добро пожаловать",text);
    }


}
