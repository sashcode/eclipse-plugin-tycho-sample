package samplegroovy

import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.ui.plugin.AbstractUIPlugin
import org.osgi.framework.BundleContext

class ActivatorGroovy extends AbstractUIPlugin{
    static String PLUGIN_ID = "samplegroovy"; //$NON-NLS-1$
    private static ActivatorGroovy plugin;
    void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }
    void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    static ActivatorGroovy getDefault() {
        return plugin;
    }

    static ImageDescriptor getImageDescriptor(String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }
}
