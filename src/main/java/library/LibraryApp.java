package library;

import library.config.LibraryConfig;
import library.controller.LibraryController;
import library.repository.LibraryStorage;
import library.service.LibraryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * 2 концепции спринга
 * 1. DI - dependency injection
 * Ioc Container - inversion of control container - управление жизненым циклов бинов
 * реализация Ioc Container в Spring - ApplicationContext
 *
 * 2. IoC - inversion of control
 * Dependency injection - внедрение бинов
 * 1) Inject By Field
 * 2) Construction injection
 * 3) Setter injection
 *
 * Виды конфигураций Spring
 * 1. XML config - XML конфигурация (надо прописывать бины в файле настроек)
 * 2. Annotation config - конфигурация с Java аннотациями (в файле настроек надо написать тег сканирование пакета и его подпакета +
 *    + те классы, которые нужно создать как бины, помечая аннотайией @Component)
 *
 * @Component - базовая аннотация для отметки класса как spring bean
 *
 * @Service - аннотация для отметки классов с бизнес логикой сервис как spring bean
 * (@Service == @Component) внутри @Service находится @Component
 *
 * @Controller - аннотация для отметки классов с бизнес логикой контроллер как spring bean
 * (@Controller == @Component) внутри @Controller находится @Component
 *
 * @Repository - аннотация для отметки классов, работающих с базой данных как spring bean
 * Внутри @Repository находится @Component, но эти классы могут выбрасывать исключение DataAccessException
 *
 * @Configuration - указывает спиригу, что у этом классе прописываются настройки бинов
 * внутри аннотации @Configuration находится @Component
 *
 * 3. Java config - конфигурация только на Java классах и аннотациях, без xml
 * a) Автоматический поиск бинов через сканирование пакетов AnnotationConfigApplicationContext("library")
 * b) Самостоятельное указание файла конфигурации и описание бинов:
 *    класс конфигураций с аннотацией @Configuration и внутри него методы с аннотацийе @Bean
 * с) = a) + b)
 **/

public class LibraryApp {
    public static void main(String[] args) {
        //0. Создание зависимостей без Spring
        System.out.println("------- Without context -------");
        LibraryStorage libraryStorage = new LibraryStorage();
        LibraryService libraryService = new LibraryService(libraryStorage);
        LibraryController libraryController = new LibraryController(libraryService);
        System.out.println(libraryController.getBook());

        // Создание объектов с зависимостями при помощи Spring, все бины с зависимостями должны быьь прописаны в beans.xml
        // 1. XML конфигурация Spring
        System.out.println("------- Context XML Configuration -------");
        ApplicationContext context1 =
                new ClassPathXmlApplicationContext("nestedBeans.xml");

        LibraryController controller = (LibraryController) context1.getBean("libraryController"); // получить бин по имени
        LibraryController controller1 = context1.getBean(LibraryController.class); // получить бин по типу

        System.out.println(controller1.getBook());
        String[] beanDefinitionNames1 = context1.getBeanDefinitionNames();
        int[] count = new int[]{1};
        Arrays.stream(beanDefinitionNames1).forEach(name -> System.out.println("Bean " + count[0]++ + " : " + name));

        // 2. XML конфигурация Spring с Java аннотациями
        System.out.println("------- Context Annotation Configuration-------");
        ApplicationContext context2 =
                new ClassPathXmlApplicationContext("annotationBeans.xml");

        LibraryController controller2 = context2.getBean(LibraryController.class);
        System.out.println(controller2.getBook());
        String[] beanDefinitionNames2 = context2.getBeanDefinitionNames();
        count[0] = 1;
        Arrays.stream(beanDefinitionNames2).forEach(name -> System.out.println("Bean " + count[0]++ + " : " + name));

        // 3. Java config
        System.out.println("------- Context Java Configuration -------");

        ApplicationContext context3 =
//                new AnnotationConfigApplicationContext();
//                new AnnotationConfigApplicationContext("library");
                new AnnotationConfigApplicationContext(LibraryConfig.class);

        LibraryController controller3 = context3.getBean(LibraryController.class);
        System.out.println(controller3.getBook());
        String[] beanDefinitionNames3 = context3.getBeanDefinitionNames();
        count[0] = 1;
        Arrays.stream(beanDefinitionNames3).forEach(name -> System.out.println("Bean " + count[0]++ + " : " + name));

    }
}
