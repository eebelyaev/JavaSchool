package lesson06.task07;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) {
        // создадим список сеттеров
        // предполагаем, что они начинаются с "set" и имеют один параметр
        List<Method> listSetters = Arrays.stream(to.getClass().getMethods())
                .filter(x -> x.getName().startsWith("set")
                        && x.getParameterCount() == 1)
                .collect(Collectors.toList());
        // пройдем по всем публичным методам объекта from
        for (Method method : from.getClass().getMethods()) {
            // найдем все методы, являющиеся геттерами
            // предполагаем, что они начинаются с "get" и не имеют параметров
            if (method.getName().startsWith("get")
                    && method.getParameterCount() == 0) {
                // запомним тип возвращаемого значения
                Class<?> returnType = method.getReturnType();
                // сгенерируем имя сеттера, заменив "get" на "set"
                String nameSetter = "s" + method.getName().substring(1);
                // пройдем по всем предполагаемым сеттерам из listSetters
                for (Method setter : listSetters) {
                    // проверим соответствие имен
                    if (setter.getName().equals(nameSetter)) {
                        // запомним тип значения параметра
                        Class<?> parameterType = setter.getParameters()[0].getType();
                        // проверим, что parameterType равен или является суперклассом returnType
                        if (parameterType.isAssignableFrom(returnType)) {
                            try {
                                setter.invoke(to, method.invoke(from));
                            } catch (InvocationTargetException | IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}