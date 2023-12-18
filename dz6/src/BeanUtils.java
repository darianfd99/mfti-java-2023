import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

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
 * @param to Object which properties will be set.
 * @param from Object which properties will be used to get values.
 */
    public static void assign(Object to, Object from) throws InvocationTargetException, IllegalAccessException {
        Method[] fromMethods  = from.getClass().getMethods();
        Method[] toMethods  = to.getClass().getMethods();

        Arrays.stream(fromMethods)
                .filter(method -> isValidGetterForAssigning(method, from))
                .forEach(getter -> assignGetter(getter, toMethods, from, to));
    }
    private static void invokeAssign(Method getter, Method setter, Object from, Object to){
        try {
            Object returnGetValue = getter.invoke(from);
            setter.invoke(to, returnGetValue);
        } catch (Exception ignored){}
    }

    private static void assignGetter(Method getter, Method[] toMethods, Object fromObject ,Object toObject){
        Arrays.stream(toMethods)
                .filter(toMethod -> isValidAssigning(getter, toMethod, toObject))
                .forEach(setter -> invokeAssign(getter, setter, fromObject, toObject));
    }

    private static boolean isValidGetterForAssigning(Method m, Object o){
        return m.canAccess(o) && isGetter(m);
    }
    private static boolean isValidAssigning(Method from, Method to, Object toObject){
        if(!isSetter(to)) return false;
        if(!to.canAccess(toObject)) return false;
        if(!(extractFieldToGetOrSet(from.getName()).equals(extractFieldToGetOrSet(to.getName())))) return false;
        return to.getParameterTypes()[0].isAssignableFrom(from.getReturnType());
    }

    private static String extractFieldToGetOrSet(String methodName){
        return methodName.substring(3);
    }

    public static boolean isGetter(Method method){
        if(!method.getName().startsWith("get")) return false;
        if(method.getParameterTypes().length != 0) return false;
        return !void.class.equals(method.getReturnType());
    }

    public static boolean isSetter(Method method){
        if(!method.getName().startsWith("set")) return false;
        return method.getParameterTypes().length == 1;
    }
}
