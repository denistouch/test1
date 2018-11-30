package denistouch.splat.test1.educationThread;
/*
* представляет собой основной класс,
* который создаёт объект класса Thinker
* запускает его, а в этот момент выводит на экран сообщение
* brain think и добавляет по символу ".",
* ждёт 250 миллисекунд и если времени не хватило
* выводит повторяет цикл, выполняет до тех пор
* пока brain не закончил свою работу.
* */
public class Program {
    public static void main(String[] args) {
        Thinker brain = new Thinker();
        brain.start();
        System.out.println("brain think");
        do {
            System.out.print(".");

            try {
                brain.join(250);
            } catch (InterruptedException e) {
            }
        } while (brain.isAlive());
        System.out.print("brain finished");
    }
    /* public static int value = 0;

     static Incremenator incremenator;

     public static void main(String[] args) {
         incremenator = new Incremenator();
         System.out.print("Value = ");
         incremenator.start();
         for (int i = 1; i <= 3; i++) {
             try {
                 Thread.sleep(i * 2 * 1000);
             } catch (InterruptedException e) {
             }
             incremenator.changeAction();
         }
         incremenator.interrupt();
     }*/
}
