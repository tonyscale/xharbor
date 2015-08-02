/**
 * 
 */
package org.jocean.xharbor.booter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author isdom
 *
 */
public class ZKMainLite {
    
    public static void main(String[] args) throws Exception {
        
        @SuppressWarnings({ "unused", "resource" })
        final ApplicationContext ctx =
                new ClassPathXmlApplicationContext(
                        new String[]{"xharbor/zkxharborlite.xml"});
    }

}
