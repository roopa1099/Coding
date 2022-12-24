package com.coding;

import java.util.Arrays;
import java.util.List;


/**
 * Given a list of database transactions, find all read-write conflicts among them. Assume 
 * that there is no strict two-phase locking (Strict 2PL) protocol to prevent read-write conflicts.

Each database transaction is given in the form of a tuple. The tuple ('T', 'A', 't', 'R') indicates

that a transaction T accessed a database record A at a time t, and a read operation is performed on the record.

Assume that a data conflict happens when two transactions access the same record in the database within an interval of 5 units. At least one write operation is performed on the record.
 */
class Transaction {
    String name;
    String record;
    int timestamp;
    char operation;

    public Transaction(String name, String record, int timestamp, char operation) {
        this.name = name;
        this.record = record;
        this.timestamp = timestamp;
        this.operation = operation;
    }
}

public class DatabaseConflict {

    public static void conflictProcess(List<Transaction> transactions) {

        transactions.sort((t1, t2) -> {
            // first sort based on record A/B/C....
            if (!(t1.record).equals(t2.record)) {
                return (t1.record).compareTo(t2.record);
            }
            // else sort based on timestamp
            return t1.timestamp - t2.timestamp;
        });

        for (int i = 1; i < transactions.size(); i++) {
            int j = i - 1;
            // compare with elements before i
            while (j >= 0 && (transactions.get(i).record == transactions.get(j).record)
                    && (transactions.get(i).timestamp <= transactions.get(j).timestamp + 5)) {
                        // conflict is when either of them is write operation
                if (transactions.get(i).operation == 'W' || transactions.get(j).operation == 'W')
                    System.out.println(transactions.get(j).name + "-" + transactions.get(i).name);
                j--;
            }
        }

    }

    public static void main(String[] args) {
        List<Transaction> t = Arrays.asList(
            new Transaction("T1", "A", 0, 'R'),
            new Transaction("T2", "A", 2, 'W'),
            new Transaction("T3", "B", 4, 'W'),
            new Transaction("T4", "C", 5, 'W'),
            new Transaction("T5", "B", 7, 'R'),
            new Transaction("T6", "C", 8, 'W'),
            new Transaction("T7", "A", 9, 'R'));

    conflictProcess(t);
        
    }
}
