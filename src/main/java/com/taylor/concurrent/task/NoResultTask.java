/*
 * File: src\main\java\com\taylor\concurrent\task\NoResultTask.java
 * Project: jpa
 * Created Date: Friday, November 10th 2023, 10:49:26 am
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Friday, 10th November 2023 10:55:30 am
 * Modified By: Rui Yu (yurui_113@hotmail.com>)
 * -----
 * Copyright (c) 2023 Rui Yu
 * -----
 * HISTORY:
 * Date                     	By       	Comments
 * -------------------------	---------	----------------------------------------------------------
 * Friday, November 10th 2023	Rui Yu		Initial version
 */

package com.taylor.concurrent.task;

import java.util.concurrent.RecursiveAction;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class NoResultTask extends RecursiveAction {

    @Getter
    private int[] array;
    private int start;
    private int end;

    private static final int NUMBER = 3;
    private static final int THRESHOLD = 100_000;

    @Override
    protected void compute() {
        if (end - start < THRESHOLD) {
            computeDirectly();
        } else {
            int middle = (start + end) / 2;

            NoResultTask subTask1 = new NoResultTask(array, start, middle);
            NoResultTask subTask2 = new NoResultTask(array, middle, end);

            invokeAll(subTask1, subTask2);
        }
    }

    private void computeDirectly() {
        for (int i = start; i < end; i++) {
            array[i] = array[i] * NUMBER;
        }
    }
}