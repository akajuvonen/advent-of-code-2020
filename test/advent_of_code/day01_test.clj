(ns advent-of-code.day01-test
  (:require [clojure.test :refer [deftest is testing]]
            [advent-of-code.day01]))

(deftest part1-test
  (testing "find-product"
    (is (= (advent-of-code.day01/find-product #{2 8 13} 10 1) 16))))