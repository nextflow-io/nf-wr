/*
 * Copyright 2020-2021, Seqera Labs
 * Copyright 2013-2019, Centre for Genomic Regulation (CRG)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nextflow.wr.s3

import com.upplication.s3fs.S3Path
import groovy.transform.CompileStatic
import nextflow.util.PathSerializer
import nextflow.util.SerializerRegistrant
import org.pf4j.Extension

/**
 * Register the S3Path serializer
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */
@Extension
@CompileStatic
class S3PathSerializer implements SerializerRegistrant  {
    @Override
    void register(Map<Class, Object> serializers) {
        serializers.put(S3Path, PathSerializer)
    }
}
