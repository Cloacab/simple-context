package com.yuri;

import com.yuri.service.announcer.Announcer;
import com.yuri.service.announcer.ConsoleAnnouncer;
import com.yuri.model.Room;
import com.yuri.service.CoronaDisinfector;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = Application.run("org.intro", new HashMap<>(Map.of(Announcer.class, ConsoleAnnouncer.class)));
        CoronaDisinfector coronaDisinfector = context.getObject(CoronaDisinfector.class);
        coronaDisinfector.start(new Room());

//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            int finalI = i;
//            ForkJoinPool.commonPool().submit(() -> {
//                try {
//                    int time = random.nextInt(300);
//                    Thread.sleep(time);
//                    System.out.printf("Thread {%d} in {%d} done\n", finalI, time);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//        ForkJoinPool.commonPool().awaitTermination(1000, TimeUnit.MILLISECONDS);
//        System.out.println("That's it.");
    }
}
