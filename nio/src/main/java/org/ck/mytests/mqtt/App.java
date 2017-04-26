package org.ck.mytests.mqtt;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        int i = callMe("test", Integer.class);
    }

    public static <T> T callMe(String key, Class<T> type) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("int", Integer.valueOf(1));

        return (T) map.get(key);
    }
}
