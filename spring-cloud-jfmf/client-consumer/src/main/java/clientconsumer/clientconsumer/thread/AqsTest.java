package clientconsumer.clientconsumer.thread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author zhbr
 * @title: AqsTest
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/2/2615:15
 */
public class AqsTest extends AbstractQueuedSynchronizer {


    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }
}
