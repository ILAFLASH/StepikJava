/*В этой задаче вам нужно реализовать метод, настраивающий параметры логирования. Конфигурирование в коде позволяет выполнить более тонкую и хитрую настройку, чем при помощи properties-файла.

        Требуется выставить такие настройки, чтобы:

        Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
        Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
        Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java", независимо от серьезности
        сообщения печатались в консоль в формате XML (*) и не передавались вышестоящим обработчикам на уровнях
        "org.stepic", "org" и "".
        Не упомянутые здесь настройки изменяться не должны.

        (*) В реальных программах мы бы конечно печатали XML не в консоль, а в файл. Но проверяющая система не
        разрешает создавать файлы на диске, поэтому придется так.

        Подсказки:

        Level есть не только у Logger, но и у Handler.
        Передача сообщения на обработку родительскому Handler'у регулируется свойством useParentHandlers.*/

package com.stepik.lesson6;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Logging {
    private static void configureLogging() {
        final Logger logger1 = Logger.getLogger("org.stepic.java.logging.ClassA");
        final Logger logger2 = Logger.getLogger("org.stepic.java.logging.ClassB");
        final Logger logger3 = Logger.getLogger("org.stepic.java");

        logger1.setLevel(Level.ALL);
        logger2.setLevel(Level.WARNING);

        logger3.setLevel(Level.ALL);
        ConsoleHandler consoleHandler3 = new ConsoleHandler();
        consoleHandler3.setLevel(Level.ALL);
        XMLFormatter xmlFormatter3 = new XMLFormatter();
        consoleHandler3.setFormatter(xmlFormatter3);
        logger3.addHandler(consoleHandler3);
        logger3.setUseParentHandlers(false);
    }
}
