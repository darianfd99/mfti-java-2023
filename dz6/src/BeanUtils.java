import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

        for (Method fromMethod : fromMethods){
            if (!isGetter(fromMethod)) continue;
            if(!fromMethod.canAccess(from)) continue;

            for(Method toMethod : toMethods){
                if(!isSetter(toMethod)) continue;
                if(!toMethod.canAccess(to)) continue;
                if(!(extractFieldToGetOrSet(fromMethod.getName()).equals(extractFieldToGetOrSet(toMethod.getName())))) continue;
                if (!toMethod.getParameterTypes()[0].isAssignableFrom(fromMethod.getReturnType())) continue;
                Object returnGetValue = fromMethod.invoke(from);
                toMethod.invoke(to, returnGetValue);
            }
        }
    }

    private static String extractFieldToGetOrSet(String methodName){
        return methodName.substring(3);
    }

    public static boolean isGetter(Method method){
        if(!method.getName().startsWith("get"))      return false;
        if(method.getParameterTypes().length != 0)   return false;
        return !void.class.equals(method.getReturnType());
    }

    public static boolean isSetter(Method method){
        if(!method.getName().startsWith("set")) return false;
        return method.getParameterTypes().length == 1;
    }
}
