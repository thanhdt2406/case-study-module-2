package controller.productCommander;

public interface Command<E,T> {
     E excuse(T t);
}
