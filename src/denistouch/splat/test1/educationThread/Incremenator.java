package denistouch.splat.test1.educationThread;
/*
public class Incremenator extends Thread {
    private volatile boolean isIncrement = true;

    public void changeAction() {
        isIncrement = !isIncrement;
    }


    @Override
    public void run() {
        do {
            if (!Thread.interrupted()) {
                if (isIncrement)
                    Program.value++;
                else
                    Program.value--;
                System.out.print(Program.value + " ");
            } else return;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        } while (true);
    }
}

*/