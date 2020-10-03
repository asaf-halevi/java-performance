package garbagecollector;

public class GcScope extends AbstractGcExample {
    GcScope t;
    private int i;

    public static void main(String args[]) {
        GcScope t1 = new GcScope(1);
        GcScope t2 = new GcScope(2);
        GcScope t3 = new GcScope(3);

        // No Object Is Eligible for GC

        t1.t = t2; // No Object Is Eligible for GC
        t2.t = t3; // No Object Is Eligible for GC
        t3.t = t1; // No Object Is Eligible for GC

        t1 = null;
        // No Object Is Eligible for GC (t3.t still has a reference to t1)

        t2 = null;
        // No Object Is Eligible for GC (t3.t.t still has a reference to t2)

        t3 = null;
        // All the 3 Object Is Eligible for GC (None of them have a reference.
        // only the variable t of the objects are referring each other in a
        // rounded fashion forming the Island of objects with out any external
        // reference)

        wasteTime();
    }

    public GcScope(int i) {
        this.i = i;
    }

    @Override
    protected void finalize() {
        System.out.println("Garbage collected from object " + i);
    }
}
