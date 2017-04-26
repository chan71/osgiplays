package org.ck.mytests;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

/**
 * Created by ck40283 on 7/19/15.
 */
@Command(scope = "servicetester", name = "lookup", description = "Lookup for a service given as argument.")
public class ServiceTester extends OsgiCommandSupport {

    @Argument(index = 0, name = "arg", description = "The command argument", required = false, multiValued = false)
    String arg = null;

    @Override
    protected Object doExecute() throws Exception {
        System.out.println("Service Tester executed. Looking up for service ... Please wait a minute.");
        System.out.println("Service name: " + arg);
        BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
        ServiceReference serviceReference = bundleContext.getServiceReference(arg);
        if (serviceReference != null) {
            Object service = bundleContext.getService(serviceReference);
            if (service != null) { //Class.forName(arg).isInstance(service)
                System.out.println(String.format("Service %s: FOUND.", arg));
            }
            else {
                System.out.println(String.format("Service %s: NOT FOUND.", arg));
            }
        }
        else {
            System.out.println(String.format("ServiceReference for %s: NOT FOUND.", arg));
        }
        return null;
    }
}
