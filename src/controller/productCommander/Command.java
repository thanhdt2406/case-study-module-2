package controller.productCommander;

import model.Product;

import java.util.List;

public interface Command<T> {
     List<Product> excuse(T t);
}
