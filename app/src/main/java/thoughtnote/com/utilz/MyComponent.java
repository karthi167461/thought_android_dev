package thoughtnote.com.utilz;


public class MyComponent<T> implements androidx.databinding.DataBindingComponent {

    private T instance;

    public MyComponent(T t) {
        instance = t;
    }
}