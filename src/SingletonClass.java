public class SingletonClass {

    private static volatile SingletonClass instance = null;

    private SingletonClass(){}

    /**
     * Using synchronized on method signature without static keyword is Object level Lock
     * Using synchronized on method signature with static keyword is by default class level lock
     * Object level lock is associated with instance of class, means other instances of the class can be accessible
     * to other threads
     * Class level lock  is associated with class, multiple threads can access the resources only one at a time.
     *
     * @return SingletonClass instance.
     */
    public static /*synchronized*/ SingletonClass getInstance() {
        if(instance == null) {
            synchronized (SingletonClass.class) {
                if(instance == null) {
                    instance = new SingletonClass();
                    return instance;
                }
            }
        }

        return instance;
    }

    public void doSomeWork() {
        System.out.println("Doing some work with single instance of this class");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    protected Object readResolve() {
        return instance;
    }
}