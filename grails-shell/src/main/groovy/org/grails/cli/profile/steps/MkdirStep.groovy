/*
 * Copyright 2014 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.grails.cli.profile.steps

import groovy.transform.CompileStatic
import org.grails.cli.profile.AbstractStep
import org.grails.cli.profile.CommandException
import org.grails.cli.profile.ExecutionContext
import org.grails.cli.profile.ProfileCommand

/**
 * A step that makes a directory
 *
 * @author Graeme Rocher
 * @since 3.0
 */
@CompileStatic
class MkdirStep extends AbstractStep {

    public static final String NAME = "mkdir"

    String location

    MkdirStep(ProfileCommand command, Map<String, Object> parameters) {
        super(command, parameters)
        location = parameters.location
        if(location) {
            throw new CommandException("Location not specified for mkdir step")
        }
    }

    @Override
    String getName() { NAME }

    @Override
    boolean handle(ExecutionContext context) {
        return new File(context.baseDir, location).mkdirs()
    }
}
