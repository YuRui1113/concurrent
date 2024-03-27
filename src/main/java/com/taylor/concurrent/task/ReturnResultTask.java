/*
 * File: src\main\java\com\taylor\concurrent\task\ReturnResultTask.java
 * Project: concurrent
 * Created Date: Friday, November 10th 2023, 11:17:59 am
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Wednesday, 27th March 2024 9:22:26 am
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

import java.util.concurrent.RecursiveTask;

import lombok.Getter;

public class ReturnResultTask extends RecursiveTask<Integer> {

    @Getter
    int[] array;
    int start;
    int end;

    private static final int THRESHOLD = 100_000;

    public ReturnResultTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {
        if (end - start < THRESHOLD) {
            return computeDirectly();
        } else {
            int middle = (end + start) / 2;

            ReturnResultTask subTask1 = new ReturnResultTask(array, start, middle);
            ReturnResultTask subTask2 = new ReturnResultTask(array, middle, end);

            invokeAll(subTask1, subTask2);

            return subTask1.join() + subTask2.join();
        }
    }

    protected Integer computeDirectly() {
        Integer count = 0;

        for (int i = start; i < end; i++) {
            if (array[i] % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}