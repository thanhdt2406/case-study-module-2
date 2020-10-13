package controller.productCommander;

import model.Product;

import java.util.List;

public interface Command<E,T> {
     E excuse(T t);
}
