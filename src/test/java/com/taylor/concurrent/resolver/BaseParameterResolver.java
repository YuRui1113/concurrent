/*
 * File: src\test\java\com\taylor\concurrent\resolver\BaseParameterResolver.java
 * Project: concurrent
 * Created Date: Friday, November 10th 2023, 11:00:29 am
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Wednesday, 27th March 2024 9:22:11 am
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

import java.util.Random;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class BaseParameterResolver implements ParameterResolver {

    protected static final int SIZE = 10_000_000;
    protected static int[] array = createRandomArray();

    private static int[] createRandomArray() {
        int[] array = new int[SIZE];

        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        throw new UnsupportedOperationException("Unimplemented method 'supportsParameter'");
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        throw new UnsupportedOperationException("Unimplemented method 'resolveParameter'");
    }
}