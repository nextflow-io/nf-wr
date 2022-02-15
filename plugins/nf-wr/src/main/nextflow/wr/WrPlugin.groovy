package nextflow.wr

import com.upplication.s3fs.S3FileSystemProvider
import groovy.transform.CompileStatic
import nextflow.Global
import nextflow.Session
import nextflow.file.FileHelper
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

    @Override
    void start() {
        super.start()
        FileHelper.getOrInstallProvider(S3FileSystemProvider)
    }

    @Override
    void stop() {
        super.stop()
        // shutdown s3 uploader
        final session = (Global.session as Session)
        final aborted = session ? session.isAborted() : false
        S3FileSystemProvider.shutdown(aborted)
    }
}
