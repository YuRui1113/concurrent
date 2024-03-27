/*
 * File: src\test\java\com\taylor\concurrent\resolver\ReturnResultTaskParameterResolver.java
 * Project: concurrent
 * Created Date: Friday, November 10th 2023, 11:21:36 am
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Wednesday, 27th March 2024 9:22:32 am
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

import com.taylor.concurrent.task.ReturnResultTask;

public class ReturnResultTaskParameterResolver extends BaseParameterResolver {

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        ReturnResultTask returnResultTask = new ReturnResultTask(array, 0, SIZE);

        return returnResultTask;
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == ReturnResultTask.class;
    }
}