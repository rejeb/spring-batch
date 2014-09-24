/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.batch.partionner;

import java.util.HashMap;
import java.util.Map;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

/**
 *
 * @author r.benrejeb
 */
public class RangePartitioner implements Partitioner {

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {

        Map<String, ExecutionContext> result = new HashMap<String, ExecutionContext>();


        for (int i = 1; i <= gridSize; i++) {
            ExecutionContext value = new ExecutionContext();

            System.out.println("\nStarting : Thread" + i);

            value.putInt("threadNum", (i - 1));

            // give each thread a name, thread 1,2,3
            value.putString("name", "Thread" + i);

            result.put("partition" + i, value);


        }

        return result;
    }
}
