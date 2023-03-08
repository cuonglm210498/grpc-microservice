package vn.vss.grpc.common.validate;

import lombok.Data;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author CuongLM18
 * @created 04/01/2023 - 10:48 AM
 * @project grpc-master
 */
public class Validator<T> {

    private T data;

    public Validator(T data) {
        this.data = data;
    }

    public static <T> Validator<T> data(T data) {
        return new Validator<>(data);
    }

    public <R> Validator<T> validate(Function<T, R> map, Predicate<R> filter, Supplier<? extends RuntimeException> exception) {
        if (filter.test(map.apply(data)) == true) {
            throw exception.get();
        }

        return this;
    }

    public T getData() {
        return data;
    }
}
