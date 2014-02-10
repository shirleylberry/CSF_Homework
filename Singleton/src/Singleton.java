public class Singleton {

    private static Singleton s;

    private Singleton(){
        super();
    }

    public static Singleton getInstance(){
        if (s == null){
            s = new Singleton();
            // saying Singleton s = new Singleton(); creates a new local variable within this method;
            // when we exit the if, the variable exits scope and gets thrown away.  If we return the instance inside
            // the if loop, it will override a previously created instance, because it's being set to null
            // every time the method is called and creates a new instance of the class.
            // here, we could also say if (Singleton.s == null){Singleton s = new Singleton();}
            // and it would work fine; we can't use this.s because the this keyword refers to an INSTANCE of a class
            // and this is a static variable.
        }
        else {
            return s;
        }
        return s;
    }
}
