package com.ideas2it.parkinglot;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class DataHolder {
    private static List<Long> parkingSlots = new LinkedList<Long>();
    private static final Long EMPTY_SLOT = -1L;
    private static Queue<Integer> emptySlots = new PriorityQueue<Integer>();

    public static void insert(Long carNumber) {
        if (emptySlots.size() == 0) {
            parkingSlots.add(carNumber);
        } else {
            int emptySlot = emptySlots.poll();
            parkingSlots.set(emptySlot, carNumber);
        }
    }

    public static void remove(Long carNUmber) {
        int slot = parkingSlots.indexOf(carNUmber);
        if (slot == -1) {
            System.out.println(String.format("%1$s not parked in parking lot", carNUmber));
        } else {
            System.out.println(slot);
            parkingSlots.set(slot, EMPTY_SLOT);
            System.out.println("Car is unparked");
            emptySlots.add(slot);
        }
    }

    public static boolean peek(int slotId) {
        if (!parkingSlots.isEmpty() && slotId < parkingSlots.size()) {
            return EMPTY_SLOT != parkingSlots.get(slotId);
        } else
            return false;
    }

    public static int poll(Long carNUmber) {
        if (!parkingSlots.isEmpty()) {
            return parkingSlots.indexOf(carNUmber);
        }
        else {
            return -1;
        }
    }

    public static List<Long> fetchAll(){
        return parkingSlots;
    }

}

