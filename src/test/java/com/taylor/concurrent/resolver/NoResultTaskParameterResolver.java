/*
 * File: src\test\java\com\taylor\concurrent\parameter-resolver\NoResultTaskParameterResolver.java
 * Project: concurrent
 * Created Date: Friday, November 10th 2023, 10:58:11 am
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Wednesday, 27th March 2024 9:22:29 am
 * Modified By: Rui Yu (yurui_113@hotmail.com>)
 * -----
 * Copyright (c) 2023 Rui Yu
 * -----
 * HISTORY:
 * Date                     	By       	Comments
 * -------------------------	---------	----------------------------------------------------------
 * Friday, November 10th 2023	Rui Yu		Initial version
 */

package com.taylor.concurrent.resolver;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;

import com.taylor.concurrent.task.NoResultTask;

public class NoResultTaskParameterResolver extends BaseParameterResolver {

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        NoResultTask noResultTask = new NoResultTask(array, 0, SIZE);

        return noResultTask;
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == NoResultTask.class;
    }
}