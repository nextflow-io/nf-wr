package nextflow.wr

import groovy.transform.CompileStatic
import nextflow.plugin.BasePlugin
import org.pf4j.PluginWrapper

/**
 * WR plugin entry point
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */
@CompileStatic
class WrPlugin extends BasePlugin {
    WrPlugin(PluginWrapper wrapper) {
        super(wrapper)
    }
}
