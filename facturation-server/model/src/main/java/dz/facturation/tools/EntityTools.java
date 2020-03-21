package dz.facturation.tools;


import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class EntityTools {

    /**
     * private construtor
     */
    private EntityTools() {

    }

    /**
     * init bean with values
     * @param values map of values
     * @param object bean to init
     * @param <T> type return object
     * @return bean initialised
     */
    public static <T> T updateObjectFromMap(Map<String, Object> values, T object) {
        if (object != null) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                try {
                    BeanUtils.setProperty(object, entry.getKey(), entry.getValue());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }
        return object;
    }


}
