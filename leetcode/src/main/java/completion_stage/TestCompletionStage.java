package completion_stage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class TestCompletionStage {

    public static void randomSleep(){
        try {
            Random random = new Random();
            long randomLong = Math.abs(random.nextLong()) % 9000 + 1000;
            System.out.println(randomLong);
            Thread.sleep(randomLong);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void completedFutureExample(){
        CompletableFuture cf = CompletableFuture.completedFuture("message");
        System.out.println(cf.isDone());
        System.out.println(cf.getNow(null));
    }
    public static void runAsyncExample(){
        CompletableFuture cf = CompletableFuture.runAsync(()->{
           Thread.currentThread().isDaemon();
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("completed");
        });
        System.out.println(cf.isDone());
        try {
            Thread.sleep(12000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(cf.isDone());
    }

    public static void thenApplyExample(){
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApply(i->{
            return i.toUpperCase();
        });
        System.out.println(cf.getNow(null));
    }

    public static void thenApplyAsyncExample(){
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(i->{
//            Thread.currentThread().isDaemon();
            randomSleep();
            return i.toUpperCase();
        });

        System.out.println(cf.getNow(null));
        System.out.println(cf.join());
    }
    static ExecutorService executor = Executors.newFixedThreadPool(3, new ThreadFactory() {
        int count = 1;
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"custom-executor-"+count++);
        }
    });
    public static void thenApplyAsyncWithExecutorExample(){
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(i->{
            System.out.println(Thread.currentThread().getName());
            randomSleep();
            return i.toUpperCase();
        },executor);
        System.out.println(cf.getNow(null));
        System.out.println(cf.join());
    }

    //
    public static void thenAcceptExample(){
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture("thenAccept message").thenApply(i->{
            randomSleep();
            return i.toUpperCase();
        }).thenAccept(s->result.append(s));

        System.out.println(result.toString());
    }
    public static void thenAcceptAsyncExample(){
        StringBuilder result = new StringBuilder();
        CompletableFuture cf = CompletableFuture.completedFuture("thenAccept message").thenApplyAsync(i->{
            randomSleep();
            return i.toUpperCase();
        }).thenAcceptAsync(s->result.append(s));

        cf.join();

        System.out.println(result.toString());
    }

    static void completeExceptionallyExample() {
//        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase,
//                CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS));
//        CompletableFuture exceptionHandler = cf.handle((s, th) -> { return (th != null) ? "message upon cancel" : ""; });
//        cf.completeExceptionally(new RuntimeException("completed exceptionally"));
//        assertTrue("Was not completed exceptionally", cf.isCompletedExceptionally());
//        try {
//            cf.join();
//            fail("Should have thrown an exception");
//        } catch(CompletionException ex) { // just for testing
//            assertEquals("completed exceptionally", ex.getCause().getMessage());
//        }
//
//        assertEquals("message upon cancel", exceptionHandler.join());
    }
    static void cancelExample() {
//        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase,
//                CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS));
//        CompletableFuture cf2 = cf.exceptionally(throwable -> "canceled message");
//        assertTrue("Was not canceled", cf.cancel(true));
//        assertTrue("Was not completed exceptionally", cf.isCompletedExceptionally());
//        assertEquals("canceled message", cf2.join());
    }

    static void thenAcceptBothExample() {
        String original = "Message";
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture(original).thenApply(String::toUpperCase).thenAcceptBoth(
                CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
                (s1, s2) -> result.append(s1 + s2));
        System.out.println(result.toString());
    }
    static void thenCombineExample() {
//        String original = "Message";
//        CompletableFuture cf = CompletableFuture.completedFuture(original).thenApply(s -> delayedUpperCase(s))
//                .thenCombine(CompletableFuture.completedFuture(original).thenApply(s -> delayedLowerCase(s)),
//                        (s1, s2) -> s1 + s2);
//        System.out.println(cf.getNow(null));
    }
    static void anyOfExample() {
//        StringBuilder result = new StringBuilder();
//        List messages = Arrays.asList("a", "b", "c");
//        List<CompletableFuture> futures = messages.stream()
//                .map(msg -> CompletableFuture.completedFuture(msg).thenApply(s -> delayedUpperCase(s)))
//                .collect(Collectors.toList());
//        CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()])).whenComplete((res, th) -> {
//            if(th == null) {
//                assertTrue(isUpperCase((String) res));
//                result.append(res);
//            }
//        });
//        assertTrue("Result was empty", result.length() > 0);
    }
    public static void main(String[] args){
//        runAsyncExample();
//        thenApplyExample();
//        thenApplyAsyncExample();
//        thenApplyAsyncWithExecutorExample();
//        thenAcceptExample();
//        thenAcceptAsyncExample();
        thenAcceptBothExample();
    }

}
