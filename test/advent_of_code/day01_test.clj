(ns advent-of-code.day01-test
  (:require [clojure.test :refer :all]
            [advent-of-code.day01 :refer :all]))

(deftest part1-test
  (testing "find-product"
    (is (= (advent-of-code.day01/find-product #{2 8 13} 10 1) 16))))