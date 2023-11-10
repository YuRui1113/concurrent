package com.taylor.concurrent;

import java.util.concurrent.ForkJoinPool;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import com.taylor.concurrent.resolver.NoResultTaskParameterResolver;
import com.taylor.concurrent.resolver.ReturnResultTaskParameterResolver;
import com.taylor.concurrent.task.NoResultTask;
import com.taylor.concurrent.task.ReturnResultTask;

@ExtendWith(NoResultTaskParameterResolver.class)
@ExtendWith(ReturnResultTaskParameterResolver.class)
@SpringBootTest
class ConcurrentApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testExecuteNoResultTask(NoResultTask mainTask) {
		System.out.println("First 10 elements of the array before: ");
		printFirstTenInArray(mainTask.getArray());

		ForkJoinPool pool = ForkJoinPool.commonPool();
		pool.invoke(mainTask);

		System.out.println("First 10 elements of the array after: ");
		printFirstTenInArray(mainTask.getArray());
	}

	void printFirstTenInArray(int[] array) {
		for (int i = 0; i < 10; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.println();
	}

	@Test
	void testExecuteReturnResultTask(ReturnResultTask mainTask) {
		ForkJoinPool pool = ForkJoinPool.commonPool();
		Integer evenNumberCount = pool.invoke(mainTask);

		System.out.println("Number of even numbers: " + evenNumberCount);
	}
}
