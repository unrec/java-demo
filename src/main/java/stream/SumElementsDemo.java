package stream;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class SumElementsDemo {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product().setCount(10).setWeight(5),
                new Product().setCount(5).setWeight(2),
                new Product().setCount(100).setWeight(1),
                new Product().setCount(25).setWeight(4));

        int getOrderWeight = products.stream()
                .map(product -> product.getWeight() * product.getCount())
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("getOrderWeight = " + getOrderWeight);
    }

    @Data
    @NoArgsConstructor
    private static class Product {
        private Integer weight;
        private Integer count;
    }
}