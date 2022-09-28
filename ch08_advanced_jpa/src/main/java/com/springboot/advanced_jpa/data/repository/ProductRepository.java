package com.springboot.advanced_jpa.data.repository;

import com.springboot.advanced_jpa.data.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
  // find...By
  Optional<Product> findByNumber(Long number);
  List<Product> findAllByName(String name);
  Product queryByNumber(Long number);

  // exists...By
  boolean existsByNumber(Long number);

  // count...By
  long countByName(String name);

  // delete...By / remove...By
  void deleteByNumber(Long number);
  long removeByName(String name);

  // ...First<number>... / ...Top<number>...
  List<Product> findFirst5ByName(String name);
  List<Product> findTop10ByName(String name);

  // Is, Equals - findByNumber method와 동일하게 동작
  Product findByNumberIs(Long number);
  Product findByNumberEquals(Long number);

  // (Is)Not
  Product findByNumberIsNot(Long number);
  Product findByNumberNot(Long number);

  // (Is)Null / (Is)NotNull
  List<Product> findByUpdatedAtNull();
  List<Product> findByUpdatedAtIsNull();
  List<Product> findByUpdatedAtNotNull();
  List<Product> findByUpdatedAtIsNotNull();

//  // (Is)True / (Is)False
//  Product findByisActiveTrue();
//  Product findByisActiveIsTrue();
//  Product findByisActiveFalse();
//  Product findByisActiveIsFalse();

  // And / Or
  Product findByNumberAndName(Long number, String name);
  Product findByNumberOrName(Long number, String name);

  // (Is)GreaterThan / (Is)LessThan / (Is)Between
  List<Product> findByPriceIsGreaterThan(Integer price);
  List<Product> findByPriceGreaterThan(Integer price);
  List<Product> findByPriceGreaterThanEqual(Integer price);
  List<Product> findByPriceIsLessThan(Integer price);
  List<Product> findByPriceLessThan(Integer price);
  List<Product> findByPriceLessThanEqual(Integer price);
  List<Product> findByPriceIsBetween(Integer lowPrice, Integer highPrice);
  List<Product> findByPriceBetween(Integer lowPrice, Integer highPrice);

  // (Is)StartingWith (= StartsWith) / (Is)EndingWith (= EndsWith) / (Is)Containing (= Contains) / (Is)Like
  List<Product> findByNameStartsWith(String name);
  List<Product> findByNameStartingWith(String name);
  List<Product> findByNameIsStartingWith(String name);
  List<Product> findByNameEndsWith(String name);
  List<Product> findByNameEndingWith(String name);
  List<Product> findByNameIsEndingWith(String name);
  List<Product> findByNameContains(String name);
  List<Product> findByNameContaining(String name);
  List<Product> findByNameIsContaining(String name);
  List<Product> findByNameIsLike(String name);
  List<Product> findByNameLike(String name);

  // Asc : 오름차순 / Desc : 내림차순
  List<Product> findByNameOrderByNumberAsc(String name);
  List<Product> findByNameOrderByNumberDesc(String name);

  // And나 Or 키워드 붙이지 않음
  List<Product> findByNameOrderByPriceAscStockDesc(String name);

  // 매개변수를 활용한 쿼리 정렬
  List<Product> findByName(String name, Sort sort);
}
